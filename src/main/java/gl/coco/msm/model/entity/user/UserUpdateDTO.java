package gl.coco.msm.model.entity.user;

import gl.coco.msm.entity.User;
import gl.coco.msm.model.abstracts.SaverDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDTO implements SaverDTO<User> {
    private String uid;
    private String firstname;
    private String lastname;

    @Override
    public String getEntityIdentifier() {
        return null;
    }

    @Override
    public void saveTo(User entity) {
        entity.setFirstname(getFirstname());
        entity.setLastname(getLastname());
    }
}
