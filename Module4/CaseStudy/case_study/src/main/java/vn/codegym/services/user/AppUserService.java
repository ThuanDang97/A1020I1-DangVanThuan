package vn.codegym.services.user;

import vn.codegym.models.AppUser;

import java.util.List;

public interface AppUserService {

    List<AppUser> findAll();

    AppUser findByUsername(String username);

    void save(AppUser appUser);

}
