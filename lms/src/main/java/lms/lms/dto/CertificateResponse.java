package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateResponse {
    private Long id;
    private String certificateNumber;
    private Long courseId;
    private String courseName;
    private String studentName;
    private LocalDateTime issuedAt;
    private String certificateUrl;
    private Integer finalGrade;
}
