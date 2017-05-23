package edu.tongji.CMS.dao.users;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Users;

import java.util.List;

public interface UsersDao extends CrudRepository<Users, Long>{

    @Query("select u from Users u where u.user_category = ?")
    List<Users> findByUserCategory(String category);
}