package edu.tongji.CMS.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.tongji.CMS.Service.service.RDFService;
import edu.tongji.CMS.dao.services.HardwareResourceDao;
import edu.tongji.CMS.dao.services.ServicesDao;
import edu.tongji.CMS.domain.HardwareResource;
import edu.tongji.CMS.domain.Services;
import edu.tongji.CMS.domain.SoftwareResource;

/**
 * @author ouzhou
 */
@Controller
@RequestMapping("/services")
public class ServicesController {

	private final Path rootLocation = Paths.get("/home/ouzhou");
	@Autowired
	private ServicesDao servicesDao;
	@Autowired
	private HardwareResourceDao hardResourceDao;
	@Autowired
	private RDFService rdfService;

	@GetMapping(value = "")
	public ModelAndView servicesAllList() {
		Iterable<Services> services = servicesDao.findAll();
		return new ModelAndView("services/dashboard", "services", services);
	}

	@GetMapping("/{id}")
	@ResponseBody
	public Services view(@PathVariable("id") long id) {
		Services services = servicesDao.findOne(id);
		return services;
	}

	@GetMapping("/form")
	public ModelAndView serviceCreateForm(@ModelAttribute Services services) {
		return new ModelAndView("services/form");
	}

	@PostMapping("/create")
	public String serviceCreate(Services services) {
		Services newService = new Services();
		String url = "services/%s";
		newService.setServicename(services.getServicename());
		newService.setOwner(services.getOwner());
		newService.setCategory(services.getCategory());
		newService.setSummary(services.getSummary());
		newService.setField(services.getField());
		newService.setPublishtime(new Date().toString());
		newService.setStatus("运行中");
		if ("硬件资源类".equals(services.getCategory()))
			url = String.format(url, "hardresource");
		else if ("软件资源类".equals(services.getCategory()))
			url = String.format(url, "softresource");
		else
			url = String.format(url, "manufacturingservice");
		servicesDao.save(newService);
		return String.format("redirect:/%s/form", url);
	}

	@GetMapping("/hardresource/form")
	public ModelAndView hardResource(@ModelAttribute HardwareResource hardresource) {
		return new ModelAndView("services/hardresource", "hardresource", hardresource);
	}

	@PostMapping("/hardresource/formcreate")
	public String hardResourceFormCreate(@ModelAttribute HardwareResource hardresource) {
		HardwareResource newService = new HardwareResource();
		newService.setName(hardresource.getName());
		newService.setDeviceOwner(hardresource.getDeviceOwner());
		newService.setDeviceCategory(hardresource.getDeviceCategory());
		newService.setFunctionDescription(hardresource.getFunctionDescription());
		newService.setFunctionName(hardresource.getFunctionName());
		newService.setCurrentStatus("运行中");
		newService.setOperationDays(hardresource.getOperationDays());
		newService.setProductionDate(hardresource.getProductionDate());
		newService.setDescription(hardresource.getDescription());
		newService.setDeviceCode(hardresource.getDeviceCode());
		newService.setLoadStatus("");
		hardResourceDao.save(newService);
		return "redirect:/services";
	}
	@PostMapping("/filecreate")
	public String hardResourceFileCreate(@RequestParam("file") File file,
            RedirectAttributes redirectAttributes) throws Exception {
		System.out.println(file.getAbsolutePath());
        redirectAttributes.addFlashAttribute("message",
                "You successfully uploaded " + file.getAbsolutePath() + "!");
		try {
			rdfService.uploadRDFFiles(file);
		}
		catch(Exception e) {
			redirectAttributes.addFlashAttribute("message",
	                "Uploade " + file.getAbsolutePath() + "failed!");
		}
		return "redirect:/services";
	}

	@GetMapping("/softresource/form")
	public ModelAndView softResource(@ModelAttribute SoftwareResource softresource) {
		return new ModelAndView("services/softresource", "softresource", softresource);
	}

	@PostMapping("/softresource/create")
	public ModelAndView softResourceCreate(@ModelAttribute SoftwareResource softresource) {
		return new ModelAndView("services/softresource");
	}

	@GetMapping("/manufacturingservice/form")
	public ModelAndView manufacturingService(@ModelAttribute Services services) {
		return new ModelAndView("services/manufacturingservice");
	}

	@PostMapping("/manufacturingservice/create")
	public ModelAndView manufacturingServiceCreate(@ModelAttribute Services services) {
		return new ModelAndView("services/manufacturingservice");
	}

	@PostMapping
	public ModelAndView servicesCreate(@Valid Services message, BindingResult result, RedirectAttributes redirect) {
		if (result.hasErrors()) {
			return new ModelAndView("messages/form", "formErrors", result.getAllErrors());
		}
		// message = this.messageRepository.save(message);
		// redirect.addFlashAttribute("globalMessage", "Successfully created a
		// new message");
		// return new ModelAndView("redirect:/{message.id}", "message.id",
		// message.getId());
		return null;
	}

	@GetMapping(value = "delete/{id}")
	public void servicesDelete(@PathVariable("id") Long id) {
		servicesDao.delete(id);
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Services message) {
		return new ModelAndView("messages/form", "message", message);
	}

}
