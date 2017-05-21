package edu.tongji.CMS.dao.demands;

import edu.tongji.CMS.domain.Demands;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by ouzhou on 2017/5/21.
 */
public interface DemandsRepository extends CrudRepository<Demands, Long> {
    List<Demands> findByStatus(String status);
    List<Demands> findByPublisher(String publisher);
    long countByStatus(String status);
    long countByPublisher(String publisher);
}
