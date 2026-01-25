package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;
import java.util.List;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DiscussionResponse {
    private Long id;
    private Long courseId;
    private Long lessonId;
    private String lessonTitle;
    private Long authorId;
    private String authorName;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private Integer upvotes;
    private Integer repliesCount;
    private List<DiscussionReplyResponse> replies;
}