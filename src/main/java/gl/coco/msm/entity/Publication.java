package gl.coco.msm.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public abstract class Publication extends AbstractEntity {
    @ManyToOne
    private User publisher;
    @Column(nullable = false, name = "is_private")
    private boolean isPrivate;
}
