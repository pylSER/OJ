package HelloTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("dishdao")
public interface DishDao extends JpaRepository<DishesEntity, Long> {
    DishesEntity findByStyle(String style);
}
