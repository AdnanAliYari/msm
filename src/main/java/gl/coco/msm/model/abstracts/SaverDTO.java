package gl.coco.msm.model.abstracts;

import gl.coco.msm.entity.AbstractEntity;

public interface SaverDTO<E extends AbstractEntity> {
    String getEntityIdentifier();
    void saveTo(E entity);
}
