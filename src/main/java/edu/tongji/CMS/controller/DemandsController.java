package edu.tongji.CMS.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.dao.demands.DemandsDao;
import edu.tongji.CMS.domain.Demands;

@Controller
@RequestMapping("/demands")
public class DemandsController {

	@Autowired
	private DemandsDao demandsDao;

	@GetMapping(value = "")
	public String servicesAllList(Model model) {
		model.addAttribute("demands", demandsDao.findAll());
		model.addAttribute("demands_personal", demandsDao.findByPublisher("同济大学"));
		model.addAttribute("demands_finished", demandsDao.findByStatus("已接单"));
		model.addAttribute("demands_unfinished", demandsDao.findByStatus("等待接单"));
		model.addAttribute("demands_count", demandsDao.count());
		model.addAttribute("demands_personal_count", demandsDao.countByPublisher("同济大学"));
		model.addAttribute("demands_finished_count", demandsDao.countByStatus("已接单"));
		model.addAttribute("demands_unfinished_count", demandsDao.countByStatus("等待接单"));
		return "demands/dashboard";
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Demands viewOrder(@PathVariable("id") long id) {
		Demands demands = demandsDao.findOne(id);
		return demands;
	}

	@GetMapping("/details/{id}")
	public ModelAndView demandsDetails(@ModelAttribute Demands demands, @PathVariable("id") long id) {
		Demands demand = demandsDao.findOne(id);
		return new ModelAndView("demands/details", "demand", demand);
	}

	@GetMapping("/publish")
	public ModelAndView demandsCreateForm(@ModelAttribute Demands demands) {
		return new ModelAndView("demands/publish");
	}
}
