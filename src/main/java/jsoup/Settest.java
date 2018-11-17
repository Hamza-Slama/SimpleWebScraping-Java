package jsoup;

import jsoup.DataHolder;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/14/18 .
 * Email : hamzaslama8@gmail.com
 */
public class Settest {
    public static void main(String[] args) {
//        Set<String> set = new LinkedHashSet<String>();
//        set.add("Hamza");
//        set.add("Hamza");
//        set.add("Hamza");
//        set.add("Hamza");
//        set.add("Hamza");
//        set.add("Hamza");
//        set.add("Hamza Slama");
//        System.out.println(set.size());

        Set<DataHolder> AllLink = new LinkedHashSet<>();
        AllLink.add(new DataHolder("Hamza",12,true));
        AllLink.add(new DataHolder("Hamza",14,true));
        AllLink.add(new DataHolder("Hamza",10,false));
        AllLink.add(new DataHolder("Hamza a",12,true));
        AllLink.add(new DataHolder("Hamza",115,false));
        AllLink.add(new DataHolder("Hamza",115,true));
        System.out.println(AllLink.size());
        for (Iterator<DataHolder> it = AllLink.iterator(); it.hasNext(); ) {
            DataHolder data = it.next();
            System.out.println("id = "+data.id);
            System.out.println("website = "+data.Website + " ,  nbr link =  "+data.nbrLink +" , visited "+data.visited);
        }
    }

   
}
