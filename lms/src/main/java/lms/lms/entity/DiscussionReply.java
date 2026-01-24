package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "discussion_replies")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiscussionReply {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "discussion_id")
    private Discussion discussion;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    private LocalDateTime createdAt;
    private Integer upvotes;
}