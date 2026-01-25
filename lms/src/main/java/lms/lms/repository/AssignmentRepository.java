package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Assignment;
import lms.lms.entity.Lesson;
import java.util.Optional;

public interface AssignmentRepository extends JpaRepository<Assignment, Long> {
    Optional<Assignment> findByLesson(Lesson lesson);
}