import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/14/18 .
 * Email : hamzaslama8@gmail.com
 */
public class MyScraper {
    //psvm
    public static String BASE_URL = "https://www.mytek.tn";
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
    int count2 = 0 ;


        try {
            final Document documents = Jsoup.connect("https://www.mytek.tn")
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
//        System.out.println(documents.outerHtml());
            Elements links = documents.select("a[href]");
            int count = 0 ;
            int i = 0 ;
            for (Element link : links){
                if (link.attr("href").contains(BASE_URL)){
                    System.out.println("--------------------- Site n ° "+i+" ----------------");
                    System.out.println("\n link "+link.attr("href"));
                    System.out.println("Text : "+link.text());
                    final Document document1 = Jsoup.connect(link.attr("href"))
                            .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                            .referrer("http://www.google.com")
                            .ignoreHttpErrors(true)
                            .get();
                    Elements links1 = document1.select("a[href]");
                    for (Element link1 : links1){
                        count2++;
                        if (link1.attr("href").contains(BASE_URL)){
                            //  System.out.println("\n link "+link1.attr("href"));
                            //System.out.println("Text : "+link1.text());
                            count2++;

                        }

                    }
                    System.out.println("le nombre des link de site n° "+i +" = "+count2);
                    count+=count2;
                    count2 = 0 ;
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println(""+timeElapsed+"ms" );
                    i++;
                    System.out.println("\n Number of Link = "+count);

                }
            }
            System.out.println("\n Number of Link = "+count);
            long finish = System.currentTimeMillis();
            long timeElapsed = finish - start;
            System.out.println(""+timeElapsed+"s" );

        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (HttpStatusException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
