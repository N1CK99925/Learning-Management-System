package lms.lms.entity;

import jakarta.persistence.*;
import java.util.List;
import java.util.ArrayList;
import lombok.*;

@Entity
@Table(name = "instructors")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Instructor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private String bio;
    private String expertise;
    private String profileImageUrl;
    private String linkedin;
    private String website;
    
    @OneToMany(mappedBy = "instructor")
    @Builder.Default
    private List<Course> courses = new ArrayList<>();
}