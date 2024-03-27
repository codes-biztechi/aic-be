package biztechi.aic.service.post;

import biztechi.aic.domain.Post;
import biztechi.aic.model.response.PostDto;
import biztechi.aic.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository dao;

    @Override
    public PostDto findById(Long id) {
        return dao.findById(id)
                .map(Post::getDto)
                .orElseThrow(() -> new RuntimeException("Post not found"));
    }
}
