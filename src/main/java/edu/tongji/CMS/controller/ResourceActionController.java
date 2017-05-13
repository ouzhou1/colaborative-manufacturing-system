package edu.tongji.CMS.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.tongji.CMS.Service.service.RDFService;
import edu.tongji.CMS.dao.HardwareResourceDao;
import edu.tongji.CMS.domain.HardwareResource;

@RestController
public class ResourceActionController {

	private static final Log logger = LogFactory.getLog(ResourceActionController.class);
	private String localtime = new Date().toString();

	@Autowired
	private RDFService rdfGenerateService;

	@Autowired
	private HardwareResourceDao hardWareResourceDao;

	// Detect Image pull request by docker pull api
	// "/v2/{project}/{repository}/manifests/{tag}"
	// and save pull info
	@GetMapping(value = "/hardresources")
	public Iterable<HardwareResource> queryHardwareResources() {
		return hardWareResourceDao.findAll();
		// return Rio.write(rdfGenerateService.latheModelGenerator(),
		// System.out, RDFFormat.RDFXML);
	}

	@GetMapping("rdf_model")
	public ModelAndView rdfModel() {
		return new ModelAndView("messages/rdf_model", "message", null);
	}

	@GetMapping("rdf_xml")
	public ModelAndView rdfXMLView() {
		return new ModelAndView("messages/rdf_xml", "message", null);
	}

}
