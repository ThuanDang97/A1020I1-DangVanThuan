package vn.codegym.repository.contract;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.ContractDetail;

public interface ContractDetailRepository extends JpaRepository<ContractDetail, Integer> {
}
