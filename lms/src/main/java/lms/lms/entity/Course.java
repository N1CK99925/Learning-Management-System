package lms.lms.entity;


import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Integer availableSeats;

    @Column(nullable = false)
    private String category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "teacher_id", nullable = false)
    private User teacher;

    @ElementCollection
    @CollectionTable(name = "course_materials", joinColumns = @JoinColumn(name = "course_id"))
    @Column(name = "file_path")
    @Builder.Default
    private List<String> materials = new ArrayList<>();

    @Builder.Default
    @Column(nullable = false)
    private Boolean active = true;

    @Column(name = "start_date")
    private LocalDateTime startDate;

    @Column(name = "end_date")
    private LocalDateTime endDate;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Enrollment> enrollments = new ArrayList<>();

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }
    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public boolean hasAvailableSeats() {
        return availableSeats != null && availableSeats > 0;
    }

    public void decrementSeats() {
        if (hasAvailableSeats()) {
            availableSeats--;
        }
    }

    public void incrementSeats() {
        if (availableSeats != null) {
            availableSeats++;
        }
    }
     @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "instructor_id")
    private Instructor instructor; // change from teacher
    
    private String coverImageUrl;
    private String previewVideoUrl;
    
    @Enumerated(EnumType.STRING)
    private DifficultyLevel level; // BEGINNER, INTERMEDIATE, ADVANCED
    
    @ElementCollection
    @Builder.Default
    private List<String> learningOutcomes = new ArrayList<>();
    
    @ElementCollection
    @Builder.Default
    private List<String> prerequisites = new ArrayList<>();
    
    private Integer estimatedDuration; // in hours
    
    @Column(columnDefinition = "DECIMAL(3,2)")
    private Double averageRating; // 0.00 to 5.00
    
    private Integer totalReviews;
    
    private Integer totalEnrollments;
    
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @Builder.Default
    private List<Module> modules = new ArrayList<>();
    
    @OneToMany(mappedBy = "course")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
    
    @Builder.Default
    private Boolean isFeatured = false;
    
    @ElementCollection
    @Builder.Default
    private List<String> tags = new ArrayList<>();
    
    public enum DifficultyLevel {
        BEGINNER, INTERMEDIATE, ADVANCED, ALL_LEVELS
    }
}

