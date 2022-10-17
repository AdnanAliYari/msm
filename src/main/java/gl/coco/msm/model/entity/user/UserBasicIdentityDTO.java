package gl.coco.msm.model.entity.user;

import gl.coco.msm.entity.User;
import gl.coco.msm.model.abstracts.LoaderDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserBasicIdentityDTO implements LoaderDTO<User> {
    private String uid;
    private String firstname;
    private String lastName;
    private String username;

    public static UserBasicIdentityDTO build(User publisher) {
        UserBasicIdentityDTO DTO = new UserBasicIdentityDTO();
        DTO.loadFrom(publisher);
        return DTO;
    }

    @Override
    public void loadFrom(User entity) {
        this.setUid(entity.getUid());
        this.setFirstname(entity.getFirstname());
        this.setLastName(entity.getLastname());
        this.setUsername(entity.getUsername());
    }
}
