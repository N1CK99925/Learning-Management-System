package lms.lms.service;


import lms.lms.dto.CourseRequest;
import lms.lms.dto.CourseResponse;
import lms.lms.entity.Course;
import lms.lms.entity.User;
import lms.lms.exception.ResourceNotFoundException;
import lms.lms.repository.CourseRepository;
import lms.lms.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final EnrollmentRepository enrollmentRepository;

    @Transactional
    public CourseResponse createCourse(CourseRequest request) {
        Course course = Course.builder()
                .name(request.getName())
                .description(request.getDescription())
                .price(request.getPrice())
                .availableSeats(request.getAvailableSeats())
                .category(request.getCategory())
                .active(true)
                .build();

        Course savedCourse = courseRepository.save(course);
        return mapToResponse(savedCourse, null);
    }

    @Transactional
    public CourseResponse updateCourse(Long id, CourseRequest request) {
        Course course = getCourseById(id);
        
        course.setName(request.getName());
        course.setDescription(request.getDescription());
        course.setPrice(request.getPrice());
        course.setAvailableSeats(request.getAvailableSeats());
        course.setCategory(request.getCategory());

        Course updatedCourse = courseRepository.save(course);
        return mapToResponse(updatedCourse, null);
    }

    @Transactional
    public void deleteCourse(Long id) {
        Course course = getCourseById(id);
        courseRepository.delete(course);
    }

    @Transactional
    public void deactivateCourse(Long id) {
        Course course = getCourseById(id);
        course.setActive(false);
        courseRepository.save(course);
    }

    @Transactional
    public void activateCourse(Long id) {
        Course course = getCourseById(id);
        course.setActive(true);
        courseRepository.save(course);
    }

    @Transactional(readOnly = true)
    public Course getCourseById(Long id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public CourseResponse getCourseResponse(Long id, User student) {
        Course course = getCourseById(id);
        return mapToResponse(course, student);
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> getAllActiveCourses(User student) {
        return courseRepository.findByActiveTrue().stream()
                .map(course -> mapToResponse(course, student))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> getAllCourses() {
        return courseRepository.findAll().stream()
                .map(course -> mapToResponse(course, null))
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<CourseResponse> getCoursesByCategory(String category, User student) {
        return courseRepository.findByActiveTrueAndCategory(category).stream()
                .map(course -> mapToResponse(course, student))
                .collect(Collectors.toList());
    }

    @Transactional
    public void addMaterial(Long courseId, String materialPath) {
        Course course = getCourseById(courseId);
        course.getMaterials().add(materialPath);
        courseRepository.save(course);
    }

    @Transactional
    public void removeMaterial(Long courseId, String materialPath) {
        Course course = getCourseById(courseId);
        course.getMaterials().remove(materialPath);
        courseRepository.save(course);
    }

    private CourseResponse mapToResponse(Course course, User student) {
        boolean isEnrolled = false;
        if (student != null) {
            isEnrolled = enrollmentRepository.existsByStudentAndCourse(student, course);
        }

        return CourseResponse.builder()
                .id(course.getId())
                .name(course.getName())
                .description(course.getDescription())
                .price(course.getPrice())
                .availableSeats(course.getAvailableSeats())
                .category(course.getCategory())
                .active(course.getActive())
                .materials(course.getMaterials())
                .createdAt(course.getCreatedAt())
                .enrolled(isEnrolled)
                .build();
    }
}