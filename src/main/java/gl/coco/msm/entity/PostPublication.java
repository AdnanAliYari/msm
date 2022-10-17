package gl.coco.msm.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity(name = PostPublication.ENTITY_NAME)
@Table(name = PostPublication.TABLE_NAME)
@Getter
@Setter
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class PostPublication extends Publication {
    public static final String ENTITY_NAME = "PostPublication";
    public static final String TABLE_NAME = "post_publications";

    @Column(nullable = false)
    private String caption;
    private long likes;
}
