package lms.lms.controller;



import lms.lms.dto.CourseResponse;
import lms.lms.dto.EnrollmentResponse;
import lms.lms.entity.User;
import lms.lms.security.JwtService;
import lms.lms.service.CourseService;
import lms.lms.service.EnrollmentService;
import lms.lms.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/student")
@PreAuthorize("hasRole('STUDENT')")
@RequiredArgsConstructor
public class StudentController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final UserService userService;
    private final JwtService jwtService;

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getAvailableCourses(
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        List<CourseResponse> courses = courseService.getAllActiveCourses(student);
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseResponse> getCourseDetails(
            @PathVariable Long id,
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        CourseResponse course = courseService.getCourseResponse(id, student);
        return ResponseEntity.ok(course);
    }

    @GetMapping("/courses/category/{category}")
    public ResponseEntity<List<CourseResponse>> getCoursesByCategory(
            @PathVariable String category,
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        List<CourseResponse> courses = courseService.getCoursesByCategory(category, student);
        return ResponseEntity.ok(courses);
    }

    @PostMapping("/enroll/{courseId}")
    public ResponseEntity<Map<String, Object>> enrollInCourse(
            @PathVariable Long courseId,
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        EnrollmentResponse enrollment = enrollmentService.enrollStudent(student, courseId);
        
        return ResponseEntity.ok(Map.of(
                "message", "Successfully enrolled in course",
                "enrollment", enrollment
        ));
    }

    @PostMapping("/drop/{courseId}")
    public ResponseEntity<Map<String, String>> dropCourse(
            @PathVariable Long courseId,
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        enrollmentService.dropEnrollment(student, courseId);
        
        return ResponseEntity.ok(Map.of("message", "Successfully dropped course"));
    }

    @GetMapping("/enrollments")
    public ResponseEntity<List<EnrollmentResponse>> getMyEnrollments(
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        List<EnrollmentResponse> enrollments = enrollmentService.getStudentEnrollments(student);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/enrollments/active")
    public ResponseEntity<List<EnrollmentResponse>> getMyActiveEnrollments(
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        List<EnrollmentResponse> enrollments = enrollmentService.getStudentActiveEnrollments(student);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/enrollments/check/{courseId}")
    public ResponseEntity<Map<String, Boolean>> checkEnrollment(
            @PathVariable Long courseId,
            @RequestHeader("Authorization") String authHeader) {
        User student = getCurrentUser(authHeader);
        boolean isEnrolled = enrollmentService.isStudentEnrolled(student, courseId);
        return ResponseEntity.ok(Map.of("enrolled", isEnrolled));
    }

    private User getCurrentUser(String authHeader) {
        String token = authHeader.substring(7);
        String email = jwtService.extractUsername(token);
        return userService.getUserByEmail(email);
    }
}