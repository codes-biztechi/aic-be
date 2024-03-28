package biztechi.aic.repository.post;

import biztechi.aic.domain.Post;
import biztechi.aic.model.request.UpdatePostDto;

import java.util.List;
import java.util.Optional;

public interface PostRepository {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void updateById(Long id, UpdatePostDto post);

    void deleteById(Long id);
}
