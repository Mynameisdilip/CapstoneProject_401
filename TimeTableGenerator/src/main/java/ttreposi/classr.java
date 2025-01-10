package ttreposi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Classr;

@Repository
public interface classr extends JpaRepository<Classr, Long> {
}
