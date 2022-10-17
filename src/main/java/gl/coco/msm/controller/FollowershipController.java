package gl.coco.msm.controller;

import gl.coco.msm.controller.abstracts.AbstractEntityDTOController;
import gl.coco.msm.entity.Followership;
import gl.coco.msm.model.entity.follow.FollowershipCreationDTO;
import gl.coco.msm.model.entity.follow.FollowershipFullDTO;
import gl.coco.msm.model.entity.follow.FollowershipUpdateDTO;
import gl.coco.msm.repository.AbstractEntityRepository;
import gl.coco.msm.service.AbstractEntityService;
import gl.coco.msm.service.FollowershipService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("followership")
@AllArgsConstructor
public class FollowershipController extends AbstractEntityDTOController<Followership, FollowershipFullDTO, FollowershipUpdateDTO, FollowershipCreationDTO> {
    private final FollowershipService service;

    @Override
    protected AbstractEntityService<Followership, ? extends AbstractEntityRepository<Followership>, FollowershipCreationDTO> getService() {
        return service;
    }

    @Override
    protected Supplier<FollowershipFullDTO> getLoaderDTOSupplier() {
        return FollowershipFullDTO::new;
    }
}
