package vn.codegym.services.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.models.AppUser;
import vn.codegym.repository.user.AppUserRepository;
import vn.codegym.services.user.AppUserService;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService {

    @Autowired
    private AppUserRepository repository;

    @Override
    public List<AppUser> findAll() {
        return repository.findAll();
    }

    @Override
    public AppUser findByUsername(String username) {
        return repository.findByUsername(username);
    }

    @Override
    public void save(AppUser appUser) {
        repository.save(appUser);
    }
}
