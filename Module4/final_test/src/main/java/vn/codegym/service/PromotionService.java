package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Promotion;

import java.util.List;

public interface PromotionService {

    Page<Promotion> findAll(Pageable pageable);

    List<Promotion> findAll();

    Promotion findById(int id);

    void save (Promotion promotion);

    void delete (Promotion promotion);

    Page<Promotion> findAllByKey(String key, Pageable pageable);
}
