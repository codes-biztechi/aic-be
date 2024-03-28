package biztechi.aic.controller;

import biztechi.aic.model.response.PostDto;
import biztechi.aic.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping("/{postId}")
    public PostDto getPost(@PathVariable Long postId) {
        return service.findById(postId);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        service.deleteById(postId);
    }
}
