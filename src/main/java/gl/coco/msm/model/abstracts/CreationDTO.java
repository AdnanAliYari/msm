package gl.coco.msm.model.abstracts;

import gl.coco.msm.entity.AbstractEntity;

public interface CreationDTO<E extends AbstractEntity> {
    E create(E emptyInstance);
}
