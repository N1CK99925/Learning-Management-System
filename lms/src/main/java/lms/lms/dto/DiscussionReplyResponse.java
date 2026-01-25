package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionReplyResponse {
    private Long id;
    private Long discussionId;
    private Long authorId;
    private String authorName;
    private String content;
    private LocalDateTime createdAt;
    private Integer upvotes;
}