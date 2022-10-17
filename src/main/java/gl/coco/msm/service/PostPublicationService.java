package gl.coco.msm.service;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.entity.User;
import gl.coco.msm.model.entity.post.PostPublicationCreationDTO;
import gl.coco.msm.repository.PostPublicationRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Component
public class PostPublicationService extends AbstractEntityService<PostPublication, PostPublicationRepository, PostPublicationCreationDTO> {
    private final PostPublicationRepository repository;
    private final UserService userService;

    public PostPublicationService(PostPublicationRepository repository, UserService userService) {
        super(repository);
        this.repository = repository;
        this.userService = userService;
    }

    public List<PostPublication> getPostsOfUser(User publisher) {
        return repository.getAllByPublisherOrderByCreatedAtDesc(publisher);
    }

    @Override
    public PostPublication create(PostPublicationCreationDTO creationDTO) {
        validateCreationDTO(creationDTO);
        PostPublication postPublication = creationDTO.create(createNewTransientInstance());
        postPublication.setPublisher(userService.findByUid(creationDTO.getPublisherUid())
                .orElseThrow(() -> new EntityNotFoundException("uid" + creationDTO.getPublisherUid())));
        return repository.save(postPublication);
    }

    @Override
    public PostPublication createNewTransientInstance() {
        return new PostPublication();
    }

    @Override
    protected void validateCreationDTO(PostPublicationCreationDTO creationDTO) {
        if (Optional.ofNullable(creationDTO.getPublisherUid()).isEmpty())
            throw new IllegalArgumentException("publisher uid cannot be null");
        if (Optional.ofNullable(creationDTO.getCaption()).isEmpty())
            throw new IllegalArgumentException("caption cannot be null");
    }
}
