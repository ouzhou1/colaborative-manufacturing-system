package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.Candidates;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatesDao extends JpaRepository<Candidates, Long> {
}
