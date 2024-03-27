package biztechi.aic.controller;

import biztechi.aic.model.response.PostDto;
import biztechi.aic.service.post.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService service;

    @GetMapping("/{postId}")
    public PostDto getPost(@PathVariable Long postId) {
        return service.findById(postId);
    }
}
