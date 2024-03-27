package biztechi.aic.repository.post;

import biztechi.aic.domain.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class PostMyBatisRepository implements PostRepository {

    private final PostMapper mapper;

    @Override
    public Optional<Post> findById(Long id) {
        return mapper.findById(id);
    }
}
