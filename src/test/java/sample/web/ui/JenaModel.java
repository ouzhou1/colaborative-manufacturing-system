package sample.web.ui;

import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.VCARD;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class JenaModel {
    public static void main(String a[]) throws FileNotFoundException {
        // some definitions
        String personURI = "http://somewhere/JohnSmith";
        String givenName = "John";
        String familyName = "Smith";
        String fullName = givenName + " " + familyName;

        // create an empty Model
        Model model = ModelFactory.createDefaultModel();

        // create the Resource and add the properties cascading style
        Resource johnSmith
                = model.createResource(personURI)
                .addProperty(VCARD.FN, fullName)
                .addProperty(VCARD.N,
                        model.createResource()
                                .addProperty(VCARD.Given, givenName)
                                .addProperty(VCARD.Family, familyName));

        OutputStream outputStream = new FileOutputStream("./lathe.xml");
        model.write(outputStream);
        // create a bag
        Bag smiths = model.createBag();

        // select all the resources with a VCARD.FN property
        // whose value ends with "Smith"
        StmtIterator iter = model.listStatements(
                new SimpleSelector(null, VCARD.FN, (RDFNode) null) {
                    public boolean selects(Statement s) {
                        return s.getString().endsWith("Smith");
                    }
                });
        // add the Smith's to the bag
        while (iter.hasNext()) {
            smiths.add(iter.nextStatement().getSubject());
        }
        // print out the members of the bag
        NodeIterator iter2 = smiths.iterator();
        if (iter2.hasNext()) {
            System.out.println("The bag contains:");
            while (iter2.hasNext()) {
                System.out.println("  " +
                        ((Resource) iter2.next())
                                .getProperty(VCARD.FN)
                                .getString());
            }
        } else {
            System.out.println("The bag is empty");
        }
        Resource vcard = model.getResource(personURI);
        System.out.println(vcard.getProperty(VCARD.N).getResource().getProperty(VCARD.Given));
    }
}
