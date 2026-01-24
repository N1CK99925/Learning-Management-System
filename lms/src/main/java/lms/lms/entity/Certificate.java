package lms.lms.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "certificates")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Certificate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "enrollment_id")
    private Enrollment enrollment;
    
    private String certificateNumber;
    private LocalDateTime issuedAt;
    private String certificateUrl; // PDF path
    private Integer finalGrade;
}