package lms.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lms.lms.entity.Certificate;
import lms.lms.entity.Enrollment;
import java.util.Optional;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
    Optional<Certificate> findByEnrollment(Enrollment enrollment);
    Optional<Certificate> findByCertificateNumber(String certificateNumber);
}