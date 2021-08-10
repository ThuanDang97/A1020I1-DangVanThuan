package vn.codegym.repository.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.ResortService;

public interface ResortServiceRepository extends JpaRepository<ResortService, String> {

    Page<ResortService> findAll(Pageable pageable);

}
