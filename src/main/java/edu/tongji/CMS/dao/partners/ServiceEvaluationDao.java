package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.ServiceEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ServiceEvaluationDao  extends JpaRepository<ServiceEvaluation, Long> {
    List<ServiceEvaluation> findByUserId(Long userId);
}
