package ttreposi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.ttentry;

@Repository
public interface entry extends JpaRepository<ttentry, Long> {
}
