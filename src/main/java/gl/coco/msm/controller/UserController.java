package gl.coco.msm.controller;

import gl.coco.msm.controller.abstracts.AbstractEntityDTOController;
import gl.coco.msm.entity.User;
import gl.coco.msm.model.entity.post.PostPublicationListingDTO;
import gl.coco.msm.model.entity.user.UserCreationDTO;
import gl.coco.msm.model.entity.user.UserFullDTO;
import gl.coco.msm.model.entity.user.UserUpdateDTO;
import gl.coco.msm.repository.AbstractEntityRepository;
import gl.coco.msm.service.AbstractEntityService;
import gl.coco.msm.service.PostPublicationService;
import gl.coco.msm.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityNotFoundException;
import java.util.function.Supplier;

@RestController
@RequestMapping("user")
@AllArgsConstructor
public class UserController extends AbstractEntityDTOController<User, UserFullDTO, UserUpdateDTO, UserCreationDTO> {
    private final UserService service;
    private final PostPublicationService postPublicationService;

    @GetMapping("{uid}/posts")
    public PostPublicationListingDTO getAllPostPublications(@PathVariable String uid) {
        User user = service.findByUid(uid)
                .orElseThrow(() -> new EntityNotFoundException("there is no entity under given uid"));
        return new PostPublicationListingDTO(postPublicationService.getPostsOfUser(user));
    }

    @Override
    protected AbstractEntityService<User, ? extends AbstractEntityRepository<User>, UserCreationDTO> getService() {
        return service;
    }

    @Override
    protected Supplier<UserFullDTO> getLoaderDTOSupplier() {
        return UserFullDTO::new;
    }
}
