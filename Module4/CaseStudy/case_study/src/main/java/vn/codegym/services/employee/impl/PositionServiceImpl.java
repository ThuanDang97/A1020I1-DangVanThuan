package vn.codegym.services.employee.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.models.Position;
import vn.codegym.repository.employee.PositionRepository;
import vn.codegym.services.employee.PositionService;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    private PositionRepository repository;

    @Override
    public List<Position> findAll() {
        return repository.findAll();
    }

}
