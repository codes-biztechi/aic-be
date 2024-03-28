package biztechi.aic.service.post;

import biztechi.aic.domain.Member;
import biztechi.aic.domain.Post;
import biztechi.aic.error.exception.ResourceNotFoundException;
import biztechi.aic.error.exception.ResourceUnauthorizedException;
import biztechi.aic.model.request.UpdatePostDto;
import biztechi.aic.model.response.PostDto;
import biztechi.aic.repository.post.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepository dao;

    @Override
    public PostDto findById(Long id) {
        return dao.findById(id)
                .map(Post::getDto)
                .orElseThrow(() -> new ResourceNotFoundException("Post not found"));
    }

    @Override
    public PostDto updateById(Long id, UpdatePostDto updatePost) {
        Optional<Post> foundPost = dao.findById(id);
        if (foundPost.isPresent()) {
            Post post = foundPost.get();
            Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (member.getId().equals(post.getCreatedBy().getId())) {
                dao.updateById(id, updatePost);
                return dao.findById(id).orElseThrow(() -> new RuntimeException("Internal server exception")).getDto();
            }
            throw new ResourceUnauthorizedException("You are not authorized to update this post");
        }
        throw new ResourceNotFoundException("Post not found");
    }

    @Override
    public void deleteById(Long id) {
        Optional<Post> foundPost = dao.findById(id);
        if (foundPost.isPresent()) {
            Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            if (member.getId().equals(foundPost.get().getCreatedBy().getId())) {
                dao.deleteById(id);
            }
            throw new ResourceUnauthorizedException("You are not authorized to delete this post");
        }
        throw new ResourceNotFoundException("Post not found");
    }
}
