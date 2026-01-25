package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import lms.lms.entity.Review;
import lms.lms.entity.Course;
import lms.lms.entity.User;
import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCourseOrderByCreatedAtDesc(Course course);
    Optional<Review> findByCourseAndUser(Course course, User user);
    
    @Query("SELECT AVG(r.rating) FROM Review r WHERE r.course = :course")
    Double findAverageRatingByCourse(@Param("course") Course course);
}