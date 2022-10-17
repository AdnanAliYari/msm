package gl.coco.msm.model.abstracts;

import gl.coco.msm.entity.AbstractEntity;

public interface LoaderDTO<E extends AbstractEntity> {
    void loadFrom(E entity);
}
