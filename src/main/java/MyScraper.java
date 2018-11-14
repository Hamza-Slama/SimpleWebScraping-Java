import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/14/18 .
 * Email : hamzaslama8@gmail.com
 */
public class MyScraper {
    //psvm
    public static String BASE_URL = "https://www.mytek.tn";
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();


        final Document documents = Jsoup.connect("https://www.mytek.tn").get();
//        System.out.println(documents.outerHtml());
        Elements links = documents.select("a[href]");
        int count = 0 ;
        for (Element link : links){
            if (link.attr("href").contains(BASE_URL)){
            System.out.println("\n link "+link.attr("href"));
            System.out.println("Text : "+link.text());
            count++;
        }
        }
        System.out.println("\n Number of Link = "+count);
        long finish = System.currentTimeMillis();
        long timeElapsed = finish - start;
        System.out.println(""+timeElapsed+"s" );
    }
}
