package gl.coco.msm.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = Followership.ENTITY_NAME)
@Table(name = Followership.TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class Followership extends AbstractEntity {
    public static final String ENTITY_NAME = "Followership";
    public static final String TABLE_NAME = "followership";

    @ManyToOne
    @EqualsAndHashCode.Include
    private User follower;
    @ManyToOne
    @EqualsAndHashCode.Include
    private User followee;
}
