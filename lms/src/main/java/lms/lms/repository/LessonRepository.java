package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Lesson;
import lms.lms.entity.Module;
import lms.lms.entity.Course;
import java.util.List;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
    List<Lesson> findByModuleOrderByOrderIndexAsc(Module module);
    List<Lesson> findByCourseAndIsPreviewTrue(Course course);
}