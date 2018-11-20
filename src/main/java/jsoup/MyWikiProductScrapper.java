package jsoup;

import model.MyteckProduct;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import static utils.Const.CSV_FILE_WIKI_PC_GAMER;
import static utils.Const.WIKI_URL_PC_GAMER;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/19/18 .
 * Email : hamzaslama8@gmail.com
 */
public class MyWikiProductScrapper {


    private static final int NBR_PAGE = 3;


    public static void main(String[] args) throws Exception {

        ArrayList<MyteckProduct> maps = getLinkHashMap(WIKI_URL_PC_GAMER);
        Charset charset = Charset.forName("UTF-8");
        maps.forEach(myteckProduct -> System.out.println(myteckProduct.getPrice()));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_WIKI_PC_GAMER));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "productName", "price", "desciption","linkToDetails","imgPath"));) {

            maps.forEach((myteckProduct)->{
                try {

                    csvPrinter.printRecord(myteckProduct.getId(),myteckProduct.getProductName()
                            ,myteckProduct.getPrice(),myteckProduct.getDesciption(),
                            myteckProduct.getLinkToDetails(),
                            myteckProduct.getImgPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
        }

    }

    public static  ArrayList<MyteckProduct> getLinkHashMap (String BASE_URL){
        String productName ="";
        String price ="";
        String desciption="" ;
        String linkToDetails="" ;
        String imgPath ="";
        ArrayList<MyteckProduct> myteckProducts = new ArrayList<>();
        int countPage = 1 ;
        try {
            while(countPage<NBR_PAGE){

                System.out.println("Page number ° "+countPage +"------------\n \n ");
                String url = BASE_URL+Integer.toString(countPage) ;
                System.out.println("-------------------------------------\n");
                System.out.println("URL " + url);
                System.out.println("-------------------------------------\n");
                final Document documents = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                        .referrer("http://www.google.com")
                        .ignoreHttpErrors(true)
                        .get();
                Elements links = documents.select("div.product-container");

                int i = 0 ;
                for (Element row : links){
                    System.out.println("---------------Product n° "+ i+" ---------------");

//                      left-block
                    Elements innerDivs = row.select("div.left-block");
                    for (Element rows : innerDivs){
                        Elements links1 =   rows.select("a[href]");
                        for (Element link1 : links1){
                            System.out.println(link1.attr("href") +
                                    " title = "+link1.attr("title"));
                            linkToDetails = link1.attr("href") ;
                        }
//                        System.out.println("-----Images-------\n");
                        Elements pngs = rows.select("img[src]");
                        for (Element png : pngs) {
//                            System.out.println("title: " + png.attr("alt"));
                            System.out.println("src: " + png.attr("src"));
                            imgPath  = png.attr("src")  ;
                            productName = png.attr("alt")  ;
                        }

                    }
//
                    Elements innerDivsRightBlock = row.select("div.right-block");
//                //product-desc
                    for (Element rows : innerDivsRightBlock){
                        Elements links1 =   rows.select("span.desc_list");
                        for (Element link1 : links1){
                            System.out.println("------- Description-----\n");
                            System.out.println(link1.html());
                            desciption = link1.html() ;

                        }
                        System.out.println("----------------Prices -----------------------\n");
                        Elements pngs = rows.select("span.price");
                        for (Element png : pngs) {
                            System.out.println(png.html());
                            price = png.html();
                        }

                    }
                    //adding
                    myteckProducts .add(new MyteckProduct(productName ,price,desciption,linkToDetails,imgPath));
                    i++;
                    System.out.println("\n \n ");
                }

                countPage++;
            }
            return myteckProducts ;
        } catch (NullPointerException e) { e.printStackTrace(); } catch (HttpStatusException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
        return  null ;

    }


}
