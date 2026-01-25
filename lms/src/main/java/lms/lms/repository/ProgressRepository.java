package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Progress;
import lms.lms.entity.Enrollment;
import lms.lms.entity.Lesson;
import java.util.List;
import java.util.Optional;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
    Optional<Progress> findByEnrollmentAndLesson(Enrollment enrollment, Lesson lesson);
    List<Progress> findByEnrollment(Enrollment enrollment);
    Long countByEnrollmentAndCompletedTrue(Enrollment enrollment);
}