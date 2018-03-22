package edu.tongji.CMS.controller;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import edu.tongji.CMS.dao.orders.OrdersDao;
import edu.tongji.CMS.dao.services.ServiceOrderBindingDao;
import edu.tongji.CMS.domain.Services.ServiceOrderBinding;
import edu.tongji.CMS.domain.order.Orders;
import edu.tongji.CMS.domain.Resource.ManufacturingService;
import edu.tongji.CMS.domain.vo.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import edu.tongji.CMS.Service.service.RDFService;
import edu.tongji.CMS.dao.services.HardwareResourceDao;
import edu.tongji.CMS.dao.services.ServicesDao;
import edu.tongji.CMS.domain.Resource.HardwareResource;
import edu.tongji.CMS.domain.Services.Services;
import edu.tongji.CMS.domain.Resource.SoftwareResource;

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
    private OrdersDao ordersDao;

	@Autowired
    private ServiceOrderBindingDao serviceOrderBindingDao;

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
	public String serviceCreate(@ModelAttribute Services services) {
	    // Save service
        String url = "services/%s";
		Services newService = new Services();
		newService.setServicename(services.getServicename());
		newService.setOwner("Tongji");
		newService.setCategory(services.getCategory());
		newService.setSummary(services.getSummary());
		newService.setField(services.getField());
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		newService.setPublishtime(simpleDateFormat.format(new Date()));
		newService.setStatus("NEW");
		newService.setCapacity(services.getCapacity());
        servicesDao.save(newService);
        // Redirect direction
		if ("硬件资源类".equals(services.getCategory()))
			url = String.format(url, "hardresource");
		else if ("软件资源类".equals(services.getCategory()))
			url = String.format(url, "softresource");
		else
			url = String.format(url, "manufacturingservice");
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
		newService.setOwner(hardresource.getOwner());
		newService.setCategory(hardresource.getCategory());
		newService.setFunctionDescription(hardresource.getFunctionDescription());
		newService.setFunctionName(hardresource.getFunctionName());
		newService.setCurrentStatus("NEW");
		newService.setOperationDays(hardresource.getOperationDays());
		newService.setUseDate(hardresource.getUseDate());
		newService.setDescription(hardresource.getDescription());
		newService.setResourceCode(hardresource.getResourceCode());
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
	public ModelAndView manufacturingService(@ModelAttribute ManufacturingService manufacturingService) {
		return new ModelAndView("services/manufacturingservice", "manufacturingService", manufacturingService);
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

	@PostMapping(value = "import")
	public void servicesImportByExcel(@ModelAttribute File file) {
        rdfService.saveByuploadExcel(file);
    }

	@GetMapping(value = "delete/{id}")
	public void servicesDelete(@PathVariable("id") Long id) {
		servicesDao.delete(id);
	}

	@GetMapping(value = "modify/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Services message) {
		return new ModelAndView("messages/form", "message", message);
	}

	// Detail Page of Services with ID
	@GetMapping("/details/{id}")
	public ModelAndView serviceDetails(@PathVariable("id") long id) {
		Services service = servicesDao.findOne(id);
		return new ModelAndView("services/details", "service", service);
	}

    @GetMapping("/request/{serviceid}")
    public ModelAndView serviceRequest(@PathVariable("serviceid") Long id, @ModelAttribute Services services) {
        List<Orders> activeOrders = ordersDao.findActiveOrders(OrderStatus.PROCESSING, OrderStatus.ESTABLISHED);
        ModelAndView modelAndView = new ModelAndView("services/binding", "orders", activeOrders);
        modelAndView.addObject("serviceid", id);
        return modelAndView;
    }

    @RequestMapping(value = "/request/binding/{serviceid}/{orderid}", method = RequestMethod.POST)
    public ModelAndView serviceOrderBinding(@PathVariable("serviceid") long serviceId, @PathVariable("orderid") long orderId) {
        ServiceOrderBinding serviceOrderBinding = new ServiceOrderBinding();
        serviceOrderBinding.setOrderId(orderId);
        serviceOrderBinding.setServiceId(serviceId);
        serviceOrderBinding.setStatus("ACTIVE");
        serviceOrderBindingDao.save(serviceOrderBinding);
        return new ModelAndView("redirect:/services", "orders",
                ordersDao.findActiveOrders(OrderStatus.PROCESSING, OrderStatus.ESTABLISHED));
    }

    @GetMapping("/search")
    public ModelAndView serviceSearch(@ModelAttribute Services services) {
        Iterable<Services> activeServices = servicesDao.findAll();
        return new ModelAndView("services/search", "services", activeServices);
    }

    @GetMapping("/search/result")
    public String serviceSearchResult(@ModelAttribute Services services) {
        return "services/searchresult";
    }

    @GetMapping("/{orderid}/searchservices")
    public ModelAndView actviceServices(@PathVariable Long orderid) {
	    List<Services> activeServices = servicesDao.findActiveServices("NEW", "PROCESSING");
        ModelAndView modelAndView = new ModelAndView("services/searchservices", "activeservices", activeServices);
        modelAndView.addObject("orderid", orderid);
        return modelAndView;
    }
}
