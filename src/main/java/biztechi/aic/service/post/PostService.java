package biztechi.aic.service.post;

import biztechi.aic.model.request.UpdatePostDto;
import biztechi.aic.model.response.PostDto;

public interface PostService {

    PostDto findById(Long id);

    PostDto updateById(Long id, UpdatePostDto post);

    void deleteById(Long id);
}
