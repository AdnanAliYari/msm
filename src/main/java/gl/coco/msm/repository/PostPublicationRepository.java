package gl.coco.msm.repository;

import gl.coco.msm.entity.PostPublication;
import gl.coco.msm.entity.User;

import java.util.List;

public interface PostPublicationRepository extends AbstractEntityRepository<PostPublication> {
    List<PostPublication> getAllByPublisher(User publisher);
    List<PostPublication> getAllByPublisherOrderByCreatedAtDesc(User publisher);
    void deleteByPublisher(User publisher);
}
