package gl.coco.msm.model.entity.post;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.model.abstracts.LoaderDTO;
import gl.coco.msm.model.entity.user.UserBasicIdentityDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPublicationFullDTO implements LoaderDTO<PostPublication> {
    private String uid;
    private String captions;
    private long likes;
    private UserBasicIdentityDTO publisher;

    @Override
    public void loadFrom(PostPublication entity) {
        this.setUid(entity.getUid());
        this.setCaptions(entity.getCaption());
        this.setLikes(entity.getLikes());
        this.setPublisher(UserBasicIdentityDTO.build(entity.getPublisher()));
    }
}
