package edu.tongji.CMS.Service.service;

import java.io.File;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.repository.Repository;
import org.springframework.stereotype.Service;

public interface RDFService {
	
	Model latheModelGenerator();
	
	Model latheRDFParser();
	
	Model generateRDFModel();
	
	Repository accessRDFServer();

	void uploadRDFFiles(File file);

	void saveByuploadExcel(File file);
	
}
