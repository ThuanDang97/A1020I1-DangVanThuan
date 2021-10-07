package vn.codegym.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import vn.codegym.model.Promotion;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion, Integer> {

    Page<Promotion> findAll(Pageable pageable);

    @Query("SELECT c FROM Promotion c WHERE " +
            "c.discount LIKE %:key% OR " +
            "c.startDate LIKE %:key% OR " +
            "c.endDate LIKE %:key%")
    Page<Promotion> findAllByKey(String key, Pageable pageable);

}
