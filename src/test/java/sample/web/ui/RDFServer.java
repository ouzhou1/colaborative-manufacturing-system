package sample.web.ui;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import org.eclipse.rdf4j.repository.Repository;
import org.eclipse.rdf4j.repository.RepositoryConnection;
import org.eclipse.rdf4j.repository.RepositoryException;
import org.eclipse.rdf4j.repository.http.HTTPRepository;
import org.eclipse.rdf4j.rio.RDFFormat;
import org.eclipse.rdf4j.rio.RDFParseException;



public class RDFServer {
	public static void main(String[] a) throws RDFParseException, RepositoryException, IOException {
		String rdf4jServer = "http://localhost:8081/rdf4j-server/";
		String repositoryID = "semiconductor-service";
		Repository repo = new HTTPRepository(rdf4jServer, repositoryID);
		File file = new File("/home/ouzhou/rdf.xml");
		String baseURI = "http://example.org/";
		RepositoryConnection con = repo.getConnection();
		try {
			con.add(file, baseURI, RDFFormat.RDFXML);
			URL url = new URL(rdf4jServer);
			con.add(url, url.toString(), RDFFormat.RDFXML);
		} finally {
			con.close();
		}
		System.out.println();
	}
}
