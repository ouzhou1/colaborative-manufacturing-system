package sample.web.ui;

import java.io.IOException;

import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;
import org.eclipse.rdf4j.rio.Rio;
import org.eclipse.rdf4j.rio.UnsupportedRDFormatException;

import edu.tongji.CMS.Service.Impl.RDFServiceIml;

public class RioTest {
	public static void main(String a[]) throws RDFParseException, UnsupportedRDFormatException, IOException {
		RDFServiceIml rdf = new RDFServiceIml();
		rdf.latheModelGenerator();
		Rio.write(rdf.latheModelGenerator(), System.out, RDFFormat.RDFXML);
		// Set<Statement> paintings = model.filter(null,
		// SimpleValueFactory.getInstance().createIRI(NAMESPACE, localName),
		// null);
		// for (Statement painting : paintings) {
		//
		// // write the info about this painting to the console in Turtle
		// // format
		// System.out.println("--- information about painting: " + painting);
		// Rio.write(painting, System.out, RDFFormat.RDFXML);
		// System.out.println();
		// }
		// First load our RDF file as a Model.
		// String filename = "lathe.xml";
		// InputStream input = new FileInputStream(filename);
		//
		// Model model = Rio.parse(input, "", RDFFormat.RDFXML);
		//
		// // Create a new Repository. Here, we choose a database implementation
		// // that simply stores everything in main memory.
		// Repository db = new SailRepository(new MemoryStore());
		// db.initialize();
		//
		// // Open a connection to the database
		// try (RepositoryConnection conn = db.getConnection()) {
		// // add the model
		// conn.add(model);
		//
		// // let's check that our data is actually in the database
		// try (RepositoryResult<Statement> result = conn.getStatements(null,
		// null, null);) {
		// while (result.hasNext()) {
		// Statement st = result.next();
		// System.out.println("db contains: " + st);
		// }
		// }
		// }
		// finally {
		// // before our program exits, make sure the database is properly shut
		// down.
		// db.shutDown();
		// }
	}
}
