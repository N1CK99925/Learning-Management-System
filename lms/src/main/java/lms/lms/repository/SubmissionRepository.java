package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Submission;
import lms.lms.entity.Assignment;
import lms.lms.entity.Enrollment;
import java.util.List;
import java.util.Optional;

public interface SubmissionRepository extends JpaRepository<Submission, Long> {
    Optional<Submission> findByAssignmentAndEnrollment(Assignment assignment, Enrollment enrollment);
    List<Submission> findByAssignment(Assignment assignment);
}