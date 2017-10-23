package edu.tongji.CMS.Service.partnerSelect;

import edu.tongji.CMS.domain.Users.Partner;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ouzhou on 2017/5/23.
 */

@Service
public class PartnerSelectServiceImpl implements PartnerSelectSerivce {

    @Override
    public List<Partner> preliminaryScreening(PartnerPreliminaryScreeningStrategy partnerPreliminaryScreeningStrategy) {
        return null;
    }

    @Override
    public List<Partner> partnerSelectByANP() {
        return null;
    }

}
