package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.QuizAttempt;
import lms.lms.entity.Enrollment;
import lms.lms.entity.Quiz;
import java.util.List;

public interface QuizAttemptRepository extends JpaRepository<QuizAttempt, Long> {
    List<QuizAttempt> findByEnrollmentAndQuizOrderByAttemptNumberDesc(Enrollment enrollment, Quiz quiz);
    Integer countByEnrollmentAndQuiz(Enrollment enrollment, Quiz quiz);
}