package edu.tongji.CMS.dao.services;

import org.springframework.data.repository.CrudRepository;

import edu.tongji.CMS.domain.Resource.HardwareResource;

public interface HardwareResourceDao extends CrudRepository<HardwareResource, Long> {

}
