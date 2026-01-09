package lms.lms.service;



import lms.lms.dto.EnrollmentResponse;
import lms.lms.entity.Course;
import lms.lms.entity.Enrollment;
import lms.lms.entity.User;
import lms.lms.exception.EnrollmentException;
import lms.lms.exception.ResourceNotFoundException;
import lms.lms.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;
    private final CourseService courseService;

    @Transactional
    public EnrollmentResponse enrollStudent(User student, Long courseId) {
        Course course = courseService.getCourseById(courseId);

        // Check if student is already enrolled
        if (enrollmentRepository.existsByStudentAndCourse(student, course)) {
            throw new EnrollmentException("You are already enrolled in this course");
        }

        // Check if course is active
        if (!course.getActive()) {
            throw new EnrollmentException("This course is not currently available for enrollment");
        }

        // Check if seats are available
        if (!course.hasAvailableSeats()) {
            throw new EnrollmentException("No available seats for this course");
        }

        // Create enrollment
        Enrollment enrollment = Enrollment.builder()
                .student(student)
                .course(course)
                .status(Enrollment.EnrollmentStatus.ACTIVE)
                .build();

        // Decrement available seats
        course.decrementSeats();

        Enrollment savedEnrollment = enrollmentRepository.save(enrollment);
        return mapToResponse(savedEnrollment);
    }

    @Transactional
    public void dropEnrollment(User student, Long courseId) {
        Course course = courseService.getCourseById(courseId);
        
        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        if (enrollment.getStatus() == Enrollment.EnrollmentStatus.DROPPED) {
            throw new EnrollmentException("Enrollment already dropped");
        }

        // Update status and increment available seats
        enrollment.setStatus(Enrollment.EnrollmentStatus.DROPPED);
        course.incrementSeats();
        
        enrollmentRepository.save(enrollment);
    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> getStudentEnrollments(User student) {
        return enrollmentRepository.findByStudent(student).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> getStudentActiveEnrollments(User student) {
        return enrollmentRepository.findByStudentAndStatus(student, Enrollment.EnrollmentStatus.ACTIVE)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<EnrollmentResponse> getCourseEnrollments(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return enrollmentRepository.findByCourse(course).stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public boolean isStudentEnrolled(User student, Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return enrollmentRepository.existsByStudentAndCourse(student, course);
    }

    @Transactional(readOnly = true)
    public long getEnrollmentCount(Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return enrollmentRepository.countByCourse(course);
    }

    @Transactional
    public void completeEnrollment(User student, Long courseId) {
        Course course = courseService.getCourseById(courseId);
        
        Enrollment enrollment = enrollmentRepository.findByStudentAndCourse(student, course)
                .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found"));

        enrollment.setStatus(Enrollment.EnrollmentStatus.COMPLETED);
        enrollmentRepository.save(enrollment);
    }

    private EnrollmentResponse mapToResponse(Enrollment enrollment) {
        Course course = enrollment.getCourse();
        return EnrollmentResponse.builder()
                .id(enrollment.getId())
                .courseId(course.getId())
                .courseName(course.getName())
                .courseCategory(course.getCategory())
                .coursePrice(course.getPrice())
                .enrolledAt(enrollment.getEnrolledAt())
                .status(enrollment.getStatus().name())
                .build();
    }
}