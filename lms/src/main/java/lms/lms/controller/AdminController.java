package lms.lms.controller;


import lms.lms.dto.CourseRequest;
import lms.lms.dto.CourseResponse;
import lms.lms.dto.EnrollmentResponse;
import lms.lms.dto.RegistrationRequest;
import lms.lms.dto.UserResponse;
import lms.lms.service.CourseService;
import lms.lms.service.EnrollmentService;
import lms.lms.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
@PreAuthorize("hasRole('ADMIN')")
@RequiredArgsConstructor
public class AdminController {

    private final CourseService courseService;
    private final EnrollmentService enrollmentService;
    private final UserService userService;
    
    @PostMapping("/courses")
    public ResponseEntity<CourseResponse> createCourse(@Valid @RequestBody CourseRequest request) {
        CourseResponse course = courseService.createCourse(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(course);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<CourseResponse> updateCourse(
            @PathVariable Long id,
            @Valid @RequestBody CourseRequest request) {
        CourseResponse course = courseService.updateCourse(id, request);
        return ResponseEntity.ok(course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Map<String, String>> deleteCourse(@PathVariable Long id) {
        courseService.deleteCourse(id);
        return ResponseEntity.ok(Map.of("message", "Course deleted successfully"));
    }

    @PatchMapping("/courses/{id}/deactivate")
    public ResponseEntity<Map<String, String>> deactivateCourse(@PathVariable Long id) {
        courseService.deactivateCourse(id);
        return ResponseEntity.ok(Map.of("message", "Course deactivated successfully"));
    }

    @PatchMapping("/courses/{id}/activate")
    public ResponseEntity<Map<String, String>> activateCourse(@PathVariable Long id) {
        courseService.activateCourse(id);
        return ResponseEntity.ok(Map.of("message", "Course activated successfully"));
    }

    @GetMapping("/courses")
    public ResponseEntity<List<CourseResponse>> getAllCourses() {
        List<CourseResponse> courses = courseService.getAllCourses();
        return ResponseEntity.ok(courses);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<CourseResponse> getCourse(@PathVariable Long id) {
        CourseResponse course = courseService.getCourseResponse(id, null);
        return ResponseEntity.ok(course);
    }

    @PostMapping("/courses/{id}/materials")
    public ResponseEntity<Map<String, String>> addMaterial(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String materialPath = request.get("materialPath");
        courseService.addMaterial(id, materialPath);
        return ResponseEntity.ok(Map.of("message", "Material added successfully"));
    }

    @DeleteMapping("/courses/{id}/materials")
    public ResponseEntity<Map<String, String>> removeMaterial(
            @PathVariable Long id,
            @RequestBody Map<String, String> request) {
        String materialPath = request.get("materialPath");
        courseService.removeMaterial(id, materialPath);
        return ResponseEntity.ok(Map.of("message", "Material removed successfully"));
    }

    @GetMapping("/courses/{id}/enrollments")
    public ResponseEntity<List<EnrollmentResponse>> getCourseEnrollments(@PathVariable Long id) {
        List<EnrollmentResponse> enrollments = enrollmentService.getCourseEnrollments(id);
        return ResponseEntity.ok(enrollments);
    }

    @GetMapping("/courses/{id}/enrollment-count")
    public ResponseEntity<Map<String, Long>> getEnrollmentCount(@PathVariable Long id) {
        long count = enrollmentService.getEnrollmentCount(id);
        return ResponseEntity.ok(Map.of("count", count));
    }

    @PostMapping("/users/admin")
    public ResponseEntity<UserResponse> createAdmin(@Valid @RequestBody RegistrationRequest request) {
        UserResponse admin = userService.createAdmin(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(admin);
    }

    @GetMapping("/users/students")
    public ResponseEntity<List<UserResponse>> getAllStudents() {
        List<UserResponse> students = userService.getAllStudents();
        return ResponseEntity.ok(students);
    }

    @PatchMapping("/users/{email}/promote")
    public ResponseEntity<UserResponse> promoteToAdmin(@PathVariable String email) {
        UserResponse user = userService.promoteToAdmin(email);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Map<String, String>> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok(Map.of("message", "User deleted successfully"));
    }

  

    @GetMapping("/dashboard/stats")
    public ResponseEntity<Map<String, Object>> getDashboardStats() {
        List<CourseResponse> allCourses = courseService.getAllCourses();
        List<UserResponse> allStudents = userService.getAllStudents();
        
        long activeCourses = allCourses.stream().filter(CourseResponse::getActive).count();
        
        Map<String, Object> stats = Map.of(
                "totalCourses", allCourses.size(),
                "activeCourses", activeCourses,
                "totalStudents", allStudents.size()
        );
        
        return ResponseEntity.ok(stats);
    }
}