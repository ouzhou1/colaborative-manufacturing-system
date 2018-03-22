package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.AbilityEvaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AbilityEvaluationDao  extends JpaRepository<AbilityEvaluation, Long> {
    List<AbilityEvaluation> findByUserId(Long userId);
}
