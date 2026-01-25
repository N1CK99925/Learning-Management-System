package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Wishlist;
import lms.lms.entity.User;
import lms.lms.entity.Course;
import java.util.List;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {
    List<Wishlist> findByUser(User user);
    boolean existsByUserAndCourse(User user, Course course);
    void deleteByUserAndCourse(User user, Course course);
}