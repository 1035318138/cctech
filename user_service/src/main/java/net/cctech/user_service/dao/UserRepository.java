package net.cctech.user_service.dao;

import net.cctech.user_service.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Can.Ru
 */

public interface UserRepository extends JpaRepository<User,Integer> {

    User findOneById(int id);
}
