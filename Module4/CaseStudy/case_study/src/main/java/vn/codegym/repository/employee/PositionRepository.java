package vn.codegym.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.Position;

public interface PositionRepository extends JpaRepository<Position, Integer> {
}
