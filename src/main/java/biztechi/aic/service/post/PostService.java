package biztechi.aic.service.post;

import biztechi.aic.model.response.PostDto;

public interface PostService {

    PostDto findById(Long id);

    void deleteById(Long id);
}
