package vn.codegym.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import vn.codegym.models.AppUser;
import vn.codegym.models.UserRole;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

    List<UserRole> findAllByAppUser(AppUser appUser);

}
