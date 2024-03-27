package biztechi.aic.repository.post;

import biztechi.aic.domain.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface PostMapper {

    Optional<Post> findById(Long id);
}
