package biztechi.aic.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private Long postId;
    private String title;
    private String content;
    private String code;
    private String label;
    private Long creatorId;
    private String creator;
    private LocalDateTime createdAt;
    private Long updaterId;
    private String updater;
    private LocalDateTime updatedAt;
}
