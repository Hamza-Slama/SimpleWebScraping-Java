package jsoup;

import model.JumiaProduct;
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
import java.util.ArrayList;

import static utils.Const.*;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/20/18 .
 * Email : hamzaslama8@gmail.com
 */
public class MyJumiaProductScrapper {


    private static final int NBR_PAGE_PC_PORTABLE = 4;
//    private static final int NBR_PAGE_PC_GAMER = 3;


    public static void main(String[] args) throws Exception {

        ArrayList<JumiaProduct> maps = getProductFromJumia(JUMIA_URL_PC_PORTABLE);
        System.out.println("\n");
        maps.forEach(jumiaProduct -> System.out.println(jumiaProduct.getPrice()));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_JUMIA_PC_PORTABLE));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "productName", "price", "currency","brand","linkToDetails","imgPath"));) {

            maps.forEach((jumiaProduct)->{
                try {
//                    System.out.println();
                    csvPrinter.printRecord(jumiaProduct.getId(),jumiaProduct.getProductName()
                            ,jumiaProduct.getPrice(),jumiaProduct.getCurrency(),
                            jumiaProduct.getBrand(),
                            jumiaProduct.getLinkToDetails(),
                            jumiaProduct.getImgPath());
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
        }

    }

    public static  ArrayList<JumiaProduct> getProductFromJumia (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
        String productName ="";
        String price ="";
        String currency="" ;
        String brand="" ;
        String linkToDetails="" ;
        String imgPath ="";
        ArrayList<JumiaProduct> jumiaProducts = new ArrayList<>();
        int countPage = 1 ;
        try {
            while(countPage<NBR_PAGE_PC_PORTABLE){

                System.out.println("Page number ° "+countPage +"------------\n  ");
                String url = BASE_URL+Integer.toString(countPage) ;
                System.out.println("-------------------------------------\n");
                System.out.println("URL " + url);
                System.out.println("-------------------------------------\n");
                final Document documents = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                        .referrer("http://www.google.com")
                        .ignoreHttpErrors(true)
                        .get();
                Elements links = documents.select("section.products div.sku");

                int i = 0 ;
                for (Element row : links){
                    System.out.println("---------------Product n° "+ i+" -------------");
//                    System.out.println(row);
                    Elements links1 =   row.select("a[href]");
//                    Elements img =   row.select("img.image");
                    for (Element link1 : links1){
                        linkToDetails = link1.attr("href") ;
                        System.out.println("link details = " + linkToDetails);
                    }
//                    //  left-block
//                    Elements innerDivs = row.select("div.left-block");
//                    for (Element rows : innerDivs){

//                        System.out.println("-----Images -------\n");
                        Elements pngs = row.select("img.image");
                        for (Element png : pngs) {
                            if (!png.attr("alt").isEmpty()){
                                productName = png.attr("alt")  ;
                                System.out.println("productName:  " + productName);
                            }
                            if (png.attr("src").contains(JUMIA_URLIMAGE_PATTERN)){
                                imgPath  = png.attr("src")  ;
                                System.out.println("imgPath: " + imgPath);
                            }
                        }
                    Elements prices = row.select("span.price span[dir]");
                        //data-price
                    Float min = Float.valueOf(Integer.MAX_VALUE);
                    Float priceNumber = Float.valueOf(0 );
                    for (Element pri : prices){
//                        System.out.println(pri);
                        price = pri.attr("data-price") ;
                        priceNumber = Float.parseFloat(price);
                        if (min>priceNumber)min = priceNumber;

                    }
                    price = min.toString();
                    System.out.println("prix = " + price);

                    Elements pricesCurency = row.select("span.price span[data-currency-iso]");
                    for (Element priCur : pricesCurency){
//                        System.out.println(pri);
                        currency=priCur.attr("data-currency-iso");
                        System.out.println("data currency " + price  + currency);
                    }

                    Elements brands = row.select("span.brand");
                    for (Element bran : brands){
                        brand = bran.html();
                        System.out.println(brand);
                    }
//                    //adding
                    jumiaProducts .add(new JumiaProduct(productName ,price,currency,brand,linkToDetails,imgPath));
                    i++;
//                    System.out.println("\n \n ");
                }

                countPage++;
            }
            return jumiaProducts ;
        } catch (NullPointerException e) { e.printStackTrace(); } catch (HttpStatusException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
        return  null ;

    }


}
