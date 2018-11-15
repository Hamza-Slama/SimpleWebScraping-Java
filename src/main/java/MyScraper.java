import org.jsoup.HttpStatusException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/14/18 .
 * Email : hamzaslama8@gmail.com
 */

public class MyScraper {
    //psvm
    public static String BASE_URL = "https://www.mytek.tn";
  //  public static Set<String> listLink = new HashSet<>();
    public static Set<dataHolder> listLink = new HashSet<>();
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
    int count2 = 0 ;


        try {
            final Document documents = Jsoup.connect(BASE_URL)
                    .userAgent("Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:25.0) Gecko/20100101 Firefox/25.0")
                    .referrer("http://www.google.com")
                    .ignoreHttpErrors(true)
                    .get();
        System.out.println(documents.outerHtml());
            Elements links = documents.select("a[href]");
            int count = 0 ;
            int countBase = 0 ;
            int i = 0 ;
            for (Element link : links){

                if (link.attr("href").contains(BASE_URL)){
                  //  listLink.add(link.attr("href"));

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
                                    //System.out.println("\n link "+link1.attr("href"));
                                    //System.out.println("Text : "+link1.text());
                                    listLink.add(new dataHolder(link1.attr("href"),0,false));
                                    count2++;

                                }

                            }

                    listLink.add(new dataHolder(link.attr("href"),count2,true));
                    System.out.println("le nombre des link de site n° "+i +" = "+count2);
                    count+=count2;
                    count2 = 0 ;
                    long finish = System.currentTimeMillis();
                    long timeElapsed = finish - start;
                    System.out.println(""+timeElapsed+"ms" );
                    i++;
                    System.out.println("\n Number of Link = "+count);

                    countBase++;
                }

            }

            listLink.add(new dataHolder(BASE_URL,countBase,true));
            System.out.println("\n Number of Link  with set= "+listLink.size());
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

        System.out.println("-----------------------\n");

        for (Iterator<dataHolder> it = listLink.iterator(); it.hasNext(); ) {
            dataHolder data = it.next();
            System.out.println(data.Website + " nbr link "+data.nbrLink +"visited "+data.visited);
        }

    }
}

/*
 if (link.attr("href").contains(BASE_URL)){

                count++;
                listLink.add(link.attr("href"));
                    System.out.println("\n link "+link.attr("href"));
                }
            }
            System.out.println("\n Number of Link = "+count);
            System.out.println("\n Number of Link  with set= "+listLink.size());
 */