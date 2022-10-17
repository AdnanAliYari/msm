package gl.coco.msm.model.entity.post;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.model.entity.user.UserFullDTO;
import lombok.Getter;
import lombok.Setter;

import java.util.Collection;
import java.util.stream.Collectors;

@Getter
@Setter
public class PostPublicationListingDTO {
    private UserFullDTO user;
    private Collection<PostPublicationLightDTO> posts;

    public PostPublicationListingDTO(Collection<PostPublication> posts) {
        UserFullDTO user = posts.stream()
                .distinct()
                .findFirst()
                .map(PostPublication::getPublisher)
                .map(publisher -> {
                    UserFullDTO DTO = new UserFullDTO();
                    DTO.loadFrom(publisher);
                    return DTO;
                }).orElse(new UserFullDTO());
        this.setUser(user);

        this.setPosts(posts.stream()
                .map(PostPublicationLightDTO::build)
                .collect(Collectors.toList())
        );
    }
}
