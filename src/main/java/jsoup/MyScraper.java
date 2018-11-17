package jsoup;

import csv.Employer;
import jsoup.DataHolder;
import model.Data;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/14/18 .
 * Email : hamzaslama8@gmail.com
 */

public class MyScraper {
    //psvm
    public static String BASE_URL = "https://www.mytek.tn";
//    public static String BASE_URL = "https://www.tutorialspoint.com/";
    private static final String SAMPLE_CSV_FILE = "./mytekLinkHashMpas.csv";
    private static final String SAMPLE_CSV_FILE_HashMap = "./mytekLinkSet.csv";

    public static void main(String[] args) throws Exception {

          Set<DataHolder> listLink = getLinks(BASE_URL);
          HashMap<String, Data> maps = getLinkHashMap(BASE_URL);

        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE));

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Website", "nbrLink", "visited"));
        ) {

            for (Iterator<DataHolder> it = listLink.iterator(); it.hasNext(); ) {
                DataHolder data = it.next();
                csvPrinter.printRecord(data.getId(),data.getWebsite(),data.getNbrLink(),data.isVisited());
            }




            csvPrinter.flush();
        }

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_HashMap));
                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Website", "nbrLink", "visited"));) {

            maps.forEach((k,v)->{
                try {
                    csvPrinter.printRecord(v.getId(),k,v.getNbrLink(),v.isVisited());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
        }
    }

    public static   HashMap<String, Data> getLinkHashMap (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
        HashMap<String, Data> maps = new HashMap<>();
        try {
            final Document documents = Jsoup.connect(BASE_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
           // System.out.println(documents.outerHtml());
            Elements links = documents.select("a[href]");
            int count = 0 ;
            int countBase = 0 ;
            int i = 0 ;
            for (Element link : links){

                if (link.attr("href").contains(BASE_URL)){
                    System.out.println("--------------------- Site n ° "+i+" ----------------");
                    final Document document1 = Jsoup.connect(link.attr("href"))
                            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                            .referrer("http://www.google.com")
                            .ignoreHttpErrors(true)
                            .get();
                    Elements links1 = document1.select("a[href]");

                    for (Element link1 : links1){
                        count2++;
                        if (link1.attr("href").contains(BASE_URL)){
                            maps.put(link1.attr("href"),new Data(0,false));
                            count2++;
                        }

                    }


                    maps.put(link.attr("href"),new Data(count2,true));
                    count+=count2;
                    count2 = 0 ;
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println(""+timeElapsed+"ms" );
                    i++;
                    countBase++;
                }

            }


            maps.put(BASE_URL,new Data(countBase,true));
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
//            System.out.println("getLinkHashMap = "+timeElapsed+"s" );

        } catch (NullPointerException e) { e.printStackTrace(); } catch (HttpStatusException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
        return maps ;
    }


    public static  Set<DataHolder> getLinks (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
        Set<DataHolder> listLink = new HashSet<>();
        HashMap<String, Data> maps = new HashMap<>();
        try {
        final Document documents = Jsoup.connect(BASE_URL).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").referrer("http://www.google.com").ignoreHttpErrors(true).get();
        Elements links = documents.select("a[href]");
            Elements pngs = documents.select("img[src]");
            for (Element png : pngs) {
                System.out.println("Name: " + png.attr("alt"));
                System.out.println("src: " + png.attr("src"));
//                System.out.println("Name: " + png);
            }
        int count = 0 ;
        int countBase = 0 ;
        int i = 0 ;
        for (Element link : links){

            if (link.attr("href").contains(BASE_URL)){
                System.out.println("--------------------- Site n ° "+i+" ----------------");
                final Document document1 = Jsoup.connect(link.attr("href")).userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0").referrer("http://www.google.com").ignoreHttpErrors(true).get();
                Elements links1 = document1.select("a[href]");
                for (Element link1 : links1){
                    count2++;
                    if (link1.attr("href").contains(BASE_URL)){
                        listLink.add(new DataHolder(link1.attr("href"),0,false));
                        count2++;
                    }

                }

                listLink.add(new DataHolder(link.attr("href"),count2,true));
                count+=count2;
                count2 = 0 ;
                long finish = System.currentTimeMillis();
                long timeElapsed = finish - start;
               // System.out.println(""+timeElapsed+"ms" );
                i++;
                countBase++;
            }

        }
        listLink.add(new DataHolder(BASE_URL,countBase,true));
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println("getLinkSet "+timeElapsed+"s" );

    } catch (NullPointerException e) {
        e.printStackTrace();
    } catch (HttpStatusException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
        return listLink ;
    }
}

/*

 */
