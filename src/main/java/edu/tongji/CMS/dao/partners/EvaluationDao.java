package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.Evaluation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EvaluationDao extends JpaRepository<Evaluation, Long> {
    List<Evaluation> findByUserId(Long userId);
}
