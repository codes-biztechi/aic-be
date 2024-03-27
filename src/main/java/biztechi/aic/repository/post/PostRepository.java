package biztechi.aic.repository.post;

import biztechi.aic.domain.Post;

import java.util.Optional;

public interface PostRepository {

    Optional<Post> findById(Long id);
}
