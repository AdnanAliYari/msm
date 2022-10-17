package gl.coco.msm.controller;

import gl.coco.msm.controller.abstracts.AbstractEntityDTOController;
import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.model.entity.post.PostPublicationCreationDTO;
import gl.coco.msm.model.entity.post.PostPublicationFullDTO;
import gl.coco.msm.model.entity.post.PostPublicationUpdateDTO;
import gl.coco.msm.repository.AbstractEntityRepository;
import gl.coco.msm.service.AbstractEntityService;
import gl.coco.msm.service.PostPublicationService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Supplier;

@RestController
@RequestMapping("post")
@AllArgsConstructor
public class PostPublicationController extends AbstractEntityDTOController<PostPublication, PostPublicationFullDTO, PostPublicationUpdateDTO, PostPublicationCreationDTO> {
    private final PostPublicationService service;

    @Override
    protected AbstractEntityService<PostPublication, ? extends AbstractEntityRepository<PostPublication>, PostPublicationCreationDTO> getService() {
        return service;
    }

    @Override
    protected Supplier<PostPublicationFullDTO> getLoaderDTOSupplier() {
        return PostPublicationFullDTO::new;
    }
}
