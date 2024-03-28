package biztechi.aic.controller;

import biztechi.aic.model.request.UpdatePostDto;
import biztechi.aic.model.response.PostDto;
import biztechi.aic.service.post.PostService;
import jakarta.validation.Valid;
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

    @PatchMapping("/{postId}")
    public PostDto updatePost(@PathVariable Long postId, @Valid @RequestBody UpdatePostDto post) {
        return service.updateById(postId, post);
    }

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        service.deleteById(postId);
    }
}
