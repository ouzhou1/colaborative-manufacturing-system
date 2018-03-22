package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.QualityEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QualityEvaluationDao  extends JpaRepository<QualityEvaluation, Long> {
    List<QualityEvaluation> findByUserId(Long userId);
}
