package ttreposi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.teachermodel;

@Repository
public interface teacher extends JpaRepository<teacher, Long> {
}
