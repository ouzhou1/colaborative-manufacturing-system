package edu.tongji.CMS.Service.service;

import java.io.File;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.repository.Repository;

public interface RDFService {
	
	public Model latheModelGenerator();
	
	public Model latheRDFParser();
	
	public Model generateRDFModel();
	
	public Repository accessRDFServer();

	void uploadRDFFiles(File file);
	
}
