package gl.coco.msm.model.entity.follow;

import gl.coco.msm.entity.Followership;
import gl.coco.msm.model.abstracts.CreationDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowershipCreationDTO implements CreationDTO<Followership> {
    private String followeeUid;
    private String followerUid;

    @Override
    public Followership create(Followership emptyInstance) {
        return emptyInstance;
    }
}
