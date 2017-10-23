package edu.tongji.CMS.controller;

import edu.tongji.CMS.Service.partnerSelect.PartnerSelectSerivce;
import edu.tongji.CMS.dao.partners.PartnersDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by ouzhou on 2017/5/23.
 */

@Controller
public class PartnerChooseController {

    @Autowired
    PartnersDao partnerDao;

    @Autowired
    PartnerSelectSerivce partnerSelectSerivce;

    @ResponseBody
    @GetMapping("/partner/select")
    public String partnerChoose(Model model) {
//        // Get partners by preliminary screening
//        PartnerPreliminaryScreeningStrategy preliminaryScreeningStrategy = new PartnerPreliminaryScreeningStrategy();
//        List<Partner> p_preliminary_screening_list = partnerSelectSerivce.preliminaryScreening(preliminaryScreeningStrategy);
//        model.addAttribute("preliminary_screening_partner_list", p_preliminary_screening_list);
        return "partner/select";
    }
}
