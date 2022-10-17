package gl.coco.msm.controller.abstracts;


import gl.coco.msm.entity.AbstractEntity;
import gl.coco.msm.model.abstracts.CreationDTO;
import gl.coco.msm.model.abstracts.LoaderDTO;
import gl.coco.msm.model.abstracts.SaverDTO;
import gl.coco.msm.repository.AbstractEntityRepository;
import gl.coco.msm.service.AbstractEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.function.Supplier;
import java.util.stream.Collectors;


public abstract class AbstractEntityDTOController<E extends AbstractEntity, D extends LoaderDTO<E>, S extends SaverDTO<E>, C extends CreationDTO<E>>
        implements BasicControllerExceptionHandler {

    @GetMapping("entity/{uid}")
    public D getFullEntity(@PathVariable String uid) {
        return getService().getEntity(uid, getLoaderDTOSupplier());
    }

    @GetMapping("entity")
    public Collection<D> getFullEntity() {
        return getService().getAll()
                .stream()
                .map(entity -> {
                    D DTO = getLoaderDTOSupplier().get();
                    DTO.loadFrom(entity);
                    return DTO;
                }).collect(Collectors.toList());
    }

    @PostMapping("entity")
    public ResponseEntity<D> createEntity(@RequestBody C creationDTO) {
        E entity = getService().create(creationDTO);
        D DTO = getLoaderDTOSupplier().get();
        DTO.loadFrom(entity);
        return ResponseEntity.ok(DTO);
    }

    @PutMapping("entity")
    public ResponseEntity<S> updateEntity(@RequestBody S updateDTO) {
        return ResponseEntity.ok(getService().updateEntity(updateDTO));
    }

    @DeleteMapping("entity/{uid}")
    public ResponseEntity<String> deleteEntity(@PathVariable String uid) {
        getService().deleteByUid(uid);
        return ResponseEntity.ok(uid);
    }

    protected abstract AbstractEntityService<E, ? extends AbstractEntityRepository<E>, C> getService();
    protected abstract Supplier<D> getLoaderDTOSupplier();
}
