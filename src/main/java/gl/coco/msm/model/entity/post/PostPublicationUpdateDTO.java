package gl.coco.msm.model.entity.post;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.model.abstracts.SaverDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPublicationUpdateDTO implements SaverDTO<PostPublication> {
    private String uid;
    private String caption;

    @Override
    public String getEntityIdentifier() {
        return uid;
    }

    @Override
    public void saveTo(PostPublication entity) {
        entity.setCaption(getCaption());
    }
}
