package edu.tongji.CMS.dao.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Users;

import java.util.List;

public interface UsersDao extends CrudRepository<Users, Long>{

    @Query(value = "select u from Users u where u.user_category = ?1")
    List<Users> findByUserCategory(String category);

    @Query(value = "select count(u) from Users u")
    int getUserCount();

    Users findByUsername(String username);
}