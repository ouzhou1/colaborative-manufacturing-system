package sample.web.ui;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class RDFTest {
    public static void main(String[] a) throws IOException {
        //new RDFGenerateServiceIml().latheModelGenerator();
        Reader in = new StringReader("a,b,c");
        for (CSVRecord record : CSVFormat.DEFAULT.parse(in)) {
            for (String field : record) {
                System.out.print("\"" + field + "\", ");
            }
            System.out.println();
        }
    }
}
