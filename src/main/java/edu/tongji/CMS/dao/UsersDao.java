package edu.tongji.CMS.dao;

import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Users;

public interface UsersDao extends CrudRepository<Users, Long>{

}
