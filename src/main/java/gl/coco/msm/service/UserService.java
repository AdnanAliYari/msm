package gl.coco.msm.service;

import gl.coco.msm.entity.User;
import gl.coco.msm.model.entity.user.UserCreationDTO;
import gl.coco.msm.repository.FollowershipRepository;
import gl.coco.msm.repository.PostPublicationRepository;
import gl.coco.msm.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Component
public class UserService extends AbstractEntityService<User, UserRepository, UserCreationDTO> {
    private final UserRepository repository;
    private final PostPublicationRepository postRepository;
    private final FollowershipRepository followershipRepository;

    public UserService(UserRepository repository, PostPublicationRepository postRepository, FollowershipRepository followershipRepository) {
        super(repository);
        this.repository = repository;
        this.postRepository = postRepository;
        this.followershipRepository = followershipRepository;
    }

    @Transactional
    @Override
    public void deleteByUid(String uid) {
        User user = repository.findByUid(uid).orElseThrow(() -> new EntityNotFoundException("uid: " + uid));
        postRepository.deleteByPublisher(user);
        followershipRepository.deleteByFolloweeOrFollower(user, user);
        super.deleteByUid(uid);
    }

    @Override
    public User createNewTransientInstance() {
        return new User();
    }

    @Override
    protected void validateCreationDTO(UserCreationDTO creationDTO) {
        if (repository.findByEmail(creationDTO.getEmail()).isPresent())
            throw new IllegalArgumentException("email is registered already");
        if (repository.findByPhoneNumber(creationDTO.getPhoneNumber()).isPresent())
            throw new IllegalArgumentException("phone number is registered already");
        if (repository.findByUsername(creationDTO.getUsername()).isPresent())
            throw new IllegalArgumentException("username is taken already");
    }
}
