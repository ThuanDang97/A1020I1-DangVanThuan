package vn.codegym.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.AppUser;

public interface AppUserRepository extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

}
