package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Quiz;
import lms.lms.entity.Lesson;
import java.util.Optional;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
    Optional<Quiz> findByLesson(Lesson lesson);
}