package csv;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/17/18 .
 * Email : hamzaslama8@gmail.com
 */
import model.Employer;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;

public class GenerateCSV {
    private static final String SAMPLE_CSV_FILE = "./sample.csv";

    public static void main(String[] args) throws IOException {
        Charset charset = Charset.forName("UTF-8");
        //WRITE INTO  CSV
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE), charset, StandardOpenOption.APPEND);

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Designation", "Company")
                        .withFirstRecordAsHeader());
        ) {
            csvPrinter.printRecord("1", "Sundar Pichai ♥", "CEO", "Google");
            csvPrinter.printRecord("2", "Satya Nadella", "CEO", "Microsoft");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");
            csvPrinter.printRecord("3", "Tim cook", "CEO", "Apple");

            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "CEO", "Facebook"));
            Employer em = new Employer(4,"Mark","CEO","Facebook");
            csvPrinter.printRecord(em.getId(),em.getName(),em.getDestination(),em.getCompany());

            csvPrinter.flush();
        }

        //READ FROM  CSV
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE));
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "Designation", "Company")
                        .withIgnoreHeaderCase()
                        .withTrim());
        ) {
            for (CSVRecord csvRecord : csvParser) {
//                // Accessing Values by Column Index
//                String name = csvRecord.get(0);
//                String email = csvRecord.get(1);
//                String phone = csvRecord.get(2);
//                String country = csvRecord.get(3);

                String id = csvRecord.get("ID");
                String name = csvRecord.get("Name");
                String dsignation = csvRecord.get("Designation");
                String company = csvRecord.get("Company");

                System.out.println("Record No = " + csvRecord.getRecordNumber());
                System.out.println("---------------");
                System.out.println("Name : " + id);
                System.out.println("Email : " + name);
                System.out.println("Phone : " + dsignation);
                System.out.println("Country : " + company);
                System.out.println("---------------\n\n");
            }
        }
    }
}