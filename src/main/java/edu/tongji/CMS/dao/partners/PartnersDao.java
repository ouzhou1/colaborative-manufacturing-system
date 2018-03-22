package edu.tongji.CMS.dao.partners;

import edu.tongji.CMS.domain.Users.Partner;

import java.util.List;

/**
 * Created by ouzhou on 2017/5/23.
 */
public interface PartnersDao extends PartnerRepository {
    List<Partner> findByUserId(Long userId);
}
