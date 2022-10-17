package gl.coco.msm.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity(name = User.ENTITY_NAME)
@Table(name = User.TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class User extends AbstractEntity {
    public static final String ENTITY_NAME = "User";
    public static final String TABLE_NAME = "users";

    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String firstname;
    @Column(nullable = false)
    @EqualsAndHashCode.Include
    private String lastname;
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String username;
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String email;
    @Column(unique = true, nullable = false)
    @EqualsAndHashCode.Include
    private String phoneNumber;
    @Column(nullable = false)
    private LocalDateTime signedUpAt;
}
