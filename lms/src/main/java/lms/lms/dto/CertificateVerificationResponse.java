package lms.lms.dto;

import lombok.*;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CertificateVerificationResponse {
    private Boolean isValid;
    private String certificateNumber;
    private String studentName;
    private String courseName;
    private LocalDateTime issuedAt;
    private String message;
}