package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.TimeEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TimeEvaluationDao extends JpaRepository<TimeEvaluation, Long> {
    List<TimeEvaluation> findByUserId(Long userId);
}
