package gl.coco.msm.model.entity.post;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.model.abstracts.CreationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostPublicationCreationDTO implements CreationDTO<PostPublication> {
    private String publisherUid;
    private boolean isPrivate;
    private String caption;

    @Override
    public PostPublication create(PostPublication emptyInstance) {
        emptyInstance.setCaption(caption);
        emptyInstance.setPrivate(isPrivate);
        return emptyInstance;
    }
}
