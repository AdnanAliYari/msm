package gl.coco.msm.model.entity.follow;

import gl.coco.msm.entity.Followership;
import gl.coco.msm.model.abstracts.SaverDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowershipUpdateDTO implements SaverDTO<Followership> {
    private String uid;

    @Override
    public String getEntityIdentifier() {
        return uid;
    }

    @Override
    public void saveTo(Followership entity) {

    }
}
