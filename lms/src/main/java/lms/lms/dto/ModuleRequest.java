package lms.lms.dto;

import lombok.*;
import jakarta.validation.constraints.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ModuleRequest {
    @NotBlank(message = "Module title is required")
    private String title;
    
    private String description;
    
    @NotNull(message = "Order index is required")
    private Integer orderIndex;
}
