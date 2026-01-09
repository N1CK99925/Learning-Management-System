package lms.lms.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Builder;
import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CourseResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer availableSeats;
    private String category;
    private Boolean active;
    private List<String> materials;
    private LocalDateTime createdAt;
    private boolean enrolled;
}