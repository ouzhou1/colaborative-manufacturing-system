package edu.tongji.CMS.dao.services;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Services.Services;

import java.util.List;

public interface ServicesDao extends CrudRepository<Services, Long> {
    @Query("select s from Services s where s.status = ?1 or s.status = ?2")
    List<Services> findActiveServices(String status1, String status2);
}
