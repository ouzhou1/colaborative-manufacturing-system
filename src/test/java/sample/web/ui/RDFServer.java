package sample.web.ui;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.util.FileManager;
import org.apache.jena.vocabulary.VCARD;

import java.io.InputStream;

public class RDFServer {
    public static void main(String[] a) {
        String inputFileName = "./lathe.xml";
        // create an empty model
        Model model = ModelFactory.createDefaultModel();
        // use the FileManager to find the input file
        InputStream in = FileManager.get().open(inputFileName);
        if (in == null) {
            throw new IllegalArgumentException(
                    "File: " + inputFileName + " not found");
        }

        // read the RDF/XML file
        model.read(in, null);
        StmtIterator iter = model.listStatements(null, null, "Smith");
        // write it to standard out
        if (iter.hasNext()) {
            System.out.println("The database contains vcards for:");
            while (iter.hasNext()) {
                System.out.println("  " + iter.nextStatement()
                        .getProperty(VCARD.FN)
                        .getString());
            }
        } else {
            System.out.println("No vcards were found in the database");
        }
    }
}
