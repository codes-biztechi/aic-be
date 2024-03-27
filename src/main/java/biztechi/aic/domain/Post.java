package biztechi.aic.domain;

import biztechi.aic.model.response.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    private Long id;
    private String title;
    private String content;
    private Category category;
    private Member createdBy;
    private LocalDateTime createAt;
    private Member updatedBy;
    private LocalDateTime updatedAt;

    public PostDto getDto() {
        return PostDto.builder()
                .postId(id)
                .title(title)
                .content(content)
                .code(category.getCode())
                .label(category.getLabel())
                .creatorId(createdBy.getId())
                .creator(createdBy.getName())
                .createdAt(createAt)
                .updaterId(updatedBy.getId())
                .updater(updatedBy.getName())
                .updatedAt(updatedAt)
                .build();
    }
}
