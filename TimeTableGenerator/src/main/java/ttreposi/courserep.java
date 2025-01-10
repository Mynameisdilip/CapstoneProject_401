package ttreposi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.coursemodel;

@Repository
public interface courserep extends JpaRepository<courserep, Long> {
}
