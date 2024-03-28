package biztechi.aic.repository.post;

import biztechi.aic.domain.Post;
import biztechi.aic.model.request.UpdatePostDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface PostMapper {

    List<Post> findAll();

    Optional<Post> findById(Long id);

    void updateById(Long id, UpdatePostDto post);

    void deleteById(Long id);
}
