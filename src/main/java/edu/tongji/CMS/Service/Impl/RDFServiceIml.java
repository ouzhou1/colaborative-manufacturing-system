package edu.tongji.CMS.Service.Impl;

import edu.tongji.CMS.Service.service.ExcelToList;
import edu.tongji.CMS.Service.service.RDFService;
import edu.tongji.CMS.dao.services.ServicesDao;
import edu.tongji.CMS.domain.Services.Services;
import org.apache.jena.rdf.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class RDFServiceIml implements RDFService {

	@Autowired
	ExcelToList excelToList;
	@Autowired
	ServicesDao servicesDao;

	String CMS_URL = "http://cms.tongji.edu.cn/";
	@Override
	public Model latheModelGenerator() {
//		Model model = ModelFactory.createDefaultModel();
//		Resource latheResource = model.createResource(CMS_URL).addProperty(RDF.subject, "lathe")
//				.addProperty(RDF.object, model.createResource().addProperty());
//		ModelBuilder builder = new ModelBuilder();
//		builder.setNamespace("pre", "http://cms.tongji.edu.cn/").subject("pre:lathe").add("pre:deviceCode", "170001")
//				.add("pre:deviceCateory", "manufacturing").add("pre:deviceOwner", "tongji")
//				.add("pre:dateOfProduction", "2017-2-27").add("pre:functionName", "lathe product")
//				.add("pre:currentStatus", "running").add("pre:operationDays", "100").add("pre:loadStatus", "normal");
//		Model model = builder.build();
//
//		// Instead of simply printing the statements to the screen, we use a Rio
//		// writer to
//		// write the model in RDF/XML syntax:
//		OutputStream outputStream = null;
//		try {
//			outputStream = new FileOutputStream("src/main/resources/templates/lathe.html");
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		Rio.write(model, outputStream, RDFFormat.RDFXML);
		return null;
	}

	@Override
	public Model latheRDFParser() {
//		String filename = "lathe.xml";
//		// read the file as an InputStream.
//		InputStream input = RDFServiceIml.class.getResourceAsStream(filename);
//
//		// Rio also accepts a java.io.Reader as input for the parser.
//		Model model = null;
//		try {
//			model = Rio.parse(input, "", RDFFormat.RDFXML);
//		} catch (RDFParseException | UnsupportedRDFormatException | IOException e) {
//			e.printStackTrace();
//		}
//		return model;
        return null;
	}
	
	@Override
	public void uploadRDFFiles(File file) {
//		String rdf4jServer = "http://localhost:8081/rdf4j-server/";
//		String repositoryID = "test";
//		Repository repo = new HTTPRepository(rdf4jServer, repositoryID);
//		String baseURI = "http://example.org/";
//		File file1  = new File("/home/ouzhou/rdf.xml");
//		RepositoryConnection con = repo.getConnection();
//		try {
//			con.add(file1, baseURI, RDFFormat.RDFXML);
//			URL url = new URL(rdf4jServer);
//			con.add(url, url.toString(), RDFFormat.RDFXML);
//		} catch (RDFParseException | RepositoryException | IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} finally {
//			con.close();
//		}
	}

	@Override
	public void saveByuploadExcel(File file) {
		List<Services> servicesList = null;
		try {
			servicesList = excelToList.convertExcelToArrayList(file.getAbsolutePath());
		} catch (Exception e) {
			e.printStackTrace();
		}
		for(Services services : servicesList) {
			servicesDao.save(services);
		}
	}

	@Override
	public Model generateRDFModel() {
//		ModelBuilder builder = new ModelBuilder();
//		// Access relational database
//		Service services = null;
//		Model model = builder.build();
//		return model;
        return null;
	}

}