package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Promotion;
import vn.codegym.repository.PromotionRepository;

import java.util.List;

@Service
public class PromotionServiceImpl implements PromotionService {

    @Autowired
    PromotionRepository promotionRepository;

    @Override
    public Page<Promotion> findAll(Pageable pageable) {
        return promotionRepository.findAll(pageable);
    }

    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Promotion findById(int id) {
        return promotionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Promotion promotion) {
        promotionRepository.save(promotion);
    }

    @Override
    public void delete(Promotion promotion) {
        promotionRepository.delete(promotion);
    }

    @Override
    public Page<Promotion> findAllByKey(String key, Pageable pageable) {
        return promotionRepository.findAllByKey(key,pageable);
    }
}
