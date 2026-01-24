package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import java.util.ArrayList;

import java.util.List;

// Module.java - Group lessons into modules/weeks
@Entity
@Table(name = "modules")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;
    
    private String title;
    private String description;
    private Integer orderIndex;
    
    @OneToMany(mappedBy = "module", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Lesson> lessons = new ArrayList<>();
}