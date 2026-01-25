package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Discussion;
import lms.lms.entity.Course;
import lms.lms.entity.Lesson;
import java.util.List;

public interface DiscussionRepository extends JpaRepository<Discussion, Long> {
    List<Discussion> findByCourseOrderByCreatedAtDesc(Course course);
    List<Discussion> findByLessonOrderByCreatedAtDesc(Lesson lesson);
}