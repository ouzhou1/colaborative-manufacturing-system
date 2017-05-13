package sample.web.ui;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

import org.eclipse.rdf4j.model.Model;
import org.eclipse.rdf4j.model.util.ModelBuilder;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.Rio;
import org.springframework.stereotype.Service;

@Service
public class RDFGenerateServiceIml {
	
	public Model latheModelGenerator() {
		ModelBuilder builder = new ModelBuilder();
		builder
				.setNamespace("pre", "http://cms.tongji.edu.cn/")
				.subject("pre:lathe")
					.add("pre:deviceCode", "170001")
					.add("pre:deviceCateory", "manufacturing")
					.add("pre:deviceOwner", "tongji")
					.add("pre:dateOfProduction", "2017-2-27")
					.add("pre:functionName", "lathe product")
					.add("pre:currentStatus", "running")
					.add("pre:operationDays", "100")
					.add("pre:loadStatus", "normal");
		Model model = builder.build();

		// Instead of simply printing the statements to the screen, we use a Rio writer to
		// write the model in RDF/XML syntax:
		OutputStream outputStream = null;
		try {
			outputStream = new FileOutputStream("src/main/resources/templates/lathe.xml");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Rio.write(model, outputStream, RDFFormat.RDFXML);
		return model;
	}
}