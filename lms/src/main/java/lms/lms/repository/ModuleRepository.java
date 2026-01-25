package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Module;
import lms.lms.entity.Course;
import java.util.List;

public interface ModuleRepository extends JpaRepository<Module, Long> {
    List<Module> findByCourseOrderByOrderIndexAsc(Course course);
}