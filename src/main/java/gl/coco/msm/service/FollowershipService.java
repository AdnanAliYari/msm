package gl.coco.msm.service;

import gl.coco.msm.entity.Followership;
import gl.coco.msm.entity.User;
import gl.coco.msm.model.entity.follow.FollowershipCreationDTO;
import gl.coco.msm.repository.FollowershipRepository;
import gl.coco.msm.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;

@Component
public class FollowershipService extends AbstractEntityService<Followership, FollowershipRepository, FollowershipCreationDTO> {
    private final FollowershipRepository repository;
    private final UserRepository userRepository;

    public FollowershipService(FollowershipRepository repository, UserRepository userRepository) {
        super(repository);
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    @Override
    public Followership create(FollowershipCreationDTO creationDTO) {
        validateCreationDTO(creationDTO);
        Followership entity = createNewTransientInstance();
        entity.setFollower(userRepository.findByUid(creationDTO.getFollowerUid()).get());
        entity.setFollowee(userRepository.findByUid(creationDTO.getFolloweeUid()).get());
        return repository.save(entity);
    }

    @Override
    public Followership createNewTransientInstance() {
        return new Followership();
    }

    @Override
    protected void validateCreationDTO(FollowershipCreationDTO creationDTO) {
        User followee = userRepository.findByUid(creationDTO.getFolloweeUid())
                .orElseThrow(() -> new EntityNotFoundException("uid: " + creationDTO.getFolloweeUid()));
        User follower = userRepository.findByUid(creationDTO.getFollowerUid())
                .orElseThrow(() -> new EntityNotFoundException("uid: " + creationDTO.getFollowerUid()));

        if (repository.findByFollowerAndFollowee(follower, followee).isPresent())
            throw new IllegalStateException("followership exists");

        if (creationDTO.getFollowerUid().equals(creationDTO.getFolloweeUid()))
            throw new IllegalStateException("you cannot follow yourself!");
    }
}
