package gl.coco.msm.model.entity.follow;

import gl.coco.msm.entity.Followership;
import gl.coco.msm.model.abstracts.LoaderDTO;
import gl.coco.msm.model.entity.user.UserBasicIdentityDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FollowershipFullDTO implements LoaderDTO<Followership> {
    private String uid;
    private UserBasicIdentityDTO followee;
    private UserBasicIdentityDTO follower;

    @Override
    public void loadFrom(Followership entity) {
        setUid(entity.getUid());
        setFollowee(UserBasicIdentityDTO.build(entity.getFollowee()));
        setFollower(UserBasicIdentityDTO.build(entity.getFollower()));
    }
}
