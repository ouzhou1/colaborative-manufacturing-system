package edu.tongji.CMS.Service.service;

import org.apache.jena.rdf.model.Model;

import java.io.File;


public interface RDFService {
	
	Model latheModelGenerator();
	
	Model latheRDFParser();
	
	Model generateRDFModel();

	void uploadRDFFiles(File file);

	void saveByuploadExcel(File file);
	
}
