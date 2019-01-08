package jsoup;

import model.Data;
import model.DataHolder;
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
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import model.MyTeckFullDescription;
import model.MyTeckFullModel;
import static utils.Const.*;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/17/18 .
 * Email : hamzaslama8@gmail.com
 */
public class MyteckProductScrapper {


//    private static final int NBR_PAGE_PC_PORTABLE = 19;
    private static final int NBR_PAGE_PC_GAMER = 3;


    public static void main(String[] args) throws Exception {

       /* ArrayList<MyteckProduct> maps = getMyTeckProduct(MYTECK_URL_PC_GAMER);
        //ArrayList<MyteckProduct> maps = getMyTeckProduct(MYTECK_URL_PC_PORTABLE);
        System.out.println("\n");
//        maps.forEach(myteckProduct -> System.out.println(myteckProduct.getPrice()));
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FILE_MY_TECK_GAMER));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                     .withHeader("ID", "productName", "price", "desciption","linkToDetails","imgPath"));) {

            maps.forEach((myteckProduct)->{
                try {
                    System.out.println();
                    csvPrinter.printRecord(myteckProduct.getId(),myteckProduct.getProductName()
                            ,myteckProduct.getPrice(),myteckProduct.getDesciption(),
                            myteckProduct.getLinkToDetails(),
                            myteckProduct.getImgPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
        }*/
String url  = "https://www.mytek.tn/pc-portable/18036-pc-portable-schneider-scl141ctp-quad-core-2go-32go-emmc.html?fbclid=IwAR1anBf8qtXumT9-zFAbiMA49rtvRIDvubHBzxy1yrz-HDomQvbiri6X-lw";
/*ArrayList<String> arr=  getDescriptionMyTeckByProduct(url);
        System.out.println(arr.size());*/
//getMyTeckProduct(MYTECK_URL_PC_PORTABLE+"1");
//getMyTeckProductWithDescription(MYTECK_URL_PC_PORTABLE);
getDescriptionMyTeckByProduct(url);
    }

   
public static  ArrayList<MyteckProduct> getMyTeckProduct (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
         String productName ="";
         String price ="";
         String desciption="" ;
         String linkToDetails="" ;
         String imgPath ="";
        ArrayList<MyteckProduct> myteckProducts = new ArrayList<>();
        int countPage = 1 ;
        try {
            while(countPage<NBR_PAGE_PC_GAMER){

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

              //  left-block
                Elements innerDivs = row.select("div.left-block");
                for (Element rows : innerDivs){
                    Elements links1 =   rows.select("a[href]");
                    for (Element link1 : links1){
                        System.out.println(link1.attr("href") +
                                " title = "+link1.attr("title"));
                        linkToDetails = link1.attr("href") ;
                        System.out.println("----------------Details--------------------\n\n");
                    }
                    System.out.println("-----Images-------\n");
                    Elements pngs = rows.select("img[src]");
                    for (Element png : pngs) {
                        System.out.println("title: " + png.attr("alt"));
                        System.out.println("src: " + png.attr("src"));
                        imgPath  = png.attr("src")  ;
                        productName = png.attr("alt")  ;
                    }

                }
//
                Elements innerDivsRightBlock = row.select("div.right-block");
//                //product-desc
                for (Element rows : innerDivsRightBlock){
                    Elements links1 =   rows.select("p.product-desc");
                    for (Element link1 : links1){
                        System.out.println("------- Description-----\n");
                        System.out.println(link1.html());
                        desciption = link1.html() ;

                    }
                    System.out.println("----------------Prices -----------------------\n");
                    Elements pngs = rows.select("table td span.price");
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

public static  ArrayList<String> getDescriptionMyTeckByProduct (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
        
        String type ;
        
        String gamer ; 
        String systemVersion ; 
        String os ; 
        String processeur ; 
        String typeProcesseur ; 
        String reffProcesseur ; 
        String freqProcesseur ; 
        String memoireCache ; 
        String typeDeBaterrie ; 
        String webCam ; 
        String mememoire ; 
        String typesDeBaterrie ; 
        String lecteurDeCarteMémoire ; 
        String tailleDEcran ; 
        String ecran ; 
        String resolutionEcran ; 
        String ecranTactile ; 
        String disqueDur ; 
        String carteGraphique ; 
        String connectiviteSansFil ; 
        String apaciteDeLaBatterie	 ; 
        String typeCarteGraphique		 ; 
        String connecteurs; 
        String garantie; 
        
        ArrayList<String> myteckDescriptionsProducts = new ArrayList<>();
 
        try {
                
            final Document documents = Jsoup.connect(BASE_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
            Elements links = documents.select("table.table-data-sheet");

            int i = 0 ;
            for (Element row : links){
                
                Elements innerDivs = row.select("tr");
                for (Element rows : innerDivs){
                    Elements tdBalise =   rows.select("td");
                    int cc = 1 ; 
                    for (Element tdBal : tdBalise){
                         //  System.out.println(tdBal.text());
                        if (tdBal.text().equals("MEMOIRE")){
                         
                            System.out.println("That s memoire");
                            System.out.println(tdBal.nextElementSibling().text());
                       // System.out.println("******");
                       }
                        if (cc % 2 == 0 )  {
                           // System.out.println(tdBal.text());
                            myteckDescriptionsProducts.add(tdBal.text());
                        }
                        cc++;
                       
                    }
                }
             
                //myteckDescriptionsProducts .add(new MyteckProduct(productName ,price,desciption,linkToDetails,imgPath));
                 i++;
               
            }

           
            return myteckDescriptionsProducts ;
        } catch (NullPointerException e) { e.printStackTrace(); } catch (HttpStatusException e) { e.printStackTrace(); } catch (IOException e) { e.printStackTrace(); }
       return  null ;

    }

public static  ArrayList<MyTeckFullModel> getMyTeckProductWithDescription (String BASE_URL){
        long start = System.currentTimeMillis();
        int count2 = 0 ;
         String productName ="";
         String price ="";
         String desciption="" ;
         String linkToDetails="" ;
         String imgPath ="";
        ArrayList<MyTeckFullModel> myteckProducts = new ArrayList<>();
        ArrayList<String> myteckDetailsByProducts = new ArrayList<>();
        int countPage = 1 ;
        try {
            while(countPage<NBR_PAGE_PC_GAMER){

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

              //  left-block
                Elements innerDivs = row.select("div.left-block");
                for (Element rows : innerDivs){
                    Elements links1 =   rows.select("a[href]");
                    for (Element link1 : links1){
                        System.out.println(link1.attr("href") +
                                " title = "+link1.attr("title"));
                        linkToDetails = link1.attr("href") ;
                        System.out.println("----------------Details--------------------\n\n");
                       myteckDetailsByProducts =  getDescriptionMyTeckByProduct(linkToDetails);
                    }
                    System.out.println("-----Images-------\n");
                    Elements pngs = rows.select("img[src]");
                    for (Element png : pngs) {
                        System.out.println("title: " + png.attr("alt"));
                        System.out.println("src: " + png.attr("src"));
                        imgPath  = png.attr("src")  ;
                        productName = png.attr("alt")  ;
                    }

                }
//
                Elements innerDivsRightBlock = row.select("div.right-block");
//                //product-desc
                for (Element rows : innerDivsRightBlock){
                    Elements links1 =   rows.select("p.product-desc");
                    for (Element link1 : links1){
                        System.out.println("------- Description-----\n");
                        System.out.println(link1.html());
                        desciption = link1.html() ;

                    }
                    System.out.println("----------------Prices -----------------------\n");
                    Elements pngs = rows.select("table td span.price");
                    for (Element png : pngs) {
                        System.out.println(png.html());
                        price = png.html();
                    }

                }
                //adding
                myteckProducts .add(new MyTeckFullModel(productName ,price,myteckDetailsByProducts, desciption,linkToDetails,imgPath));
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


