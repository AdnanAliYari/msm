package gl.coco.msm.model.entity.user;

import gl.coco.msm.entity.User;
import gl.coco.msm.model.abstracts.CreationDTO;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class UserCreationDTO implements CreationDTO<User> {
    private String firstname;
    private String lastName;
    private String username;
    private String phoneNumber;
    private String email;

    @Override
    public User create(User emptyInstance) {
        emptyInstance.setFirstname(firstname);
        emptyInstance.setLastname(lastName);
        emptyInstance.setUsername(username);
        emptyInstance.setPhoneNumber(phoneNumber);
        emptyInstance.setEmail(email);
        emptyInstance.setSignedUpAt(LocalDateTime.now());
        return emptyInstance;
    }
}
