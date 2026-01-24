package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;

@Entity
@Table(name = "discussions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Discussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id")
    private Lesson lesson; // optional
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User author;
    
    private String title;
    
    @Column(columnDefinition = "TEXT")
    private String content;
    
    private LocalDateTime createdAt;
    
    @OneToMany(mappedBy = "discussion", cascade = CascadeType.ALL)
    private List<DiscussionReply> replies = new ArrayList<>();
    
    private Integer upvotes;
}