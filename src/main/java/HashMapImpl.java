/**
 * Created by Hamza Slama (Hamzeoui) on 11/17/18 .
 * Email : hamzaslama8@gmail.com
 */

// Java program to illustrate
// Java.util.HashMap
import model.Data;

import java.util.HashMap;
import java.util.Map;

public class HashMapImpl
{
    public static void main(String[] args)
    {

        HashMap<String, Integer> map = new HashMap<>();

        HashMap<String, Data> maps = new HashMap<>();

        //print(map);
        maps.put("myteck.tn",new Data(12,true));
        maps.put("myteck.tn/",new Data(11,true));
        maps.put("myteck.tn/hamza",new Data(14,true));
        maps.put("myteck.tn",new Data(1112,false));


        maps.forEach((k,v)->System.out.println("Key: " + k + " Value: " + v.getId() + " nbrLink "+v.getNbrLink()));
        map.put("vishal", 10);
        map.put("sachin", 30);
        map.put("vaibhav", 20);
        map.put("vaibhav", 20);

        map.clear();
       // print(map);
    }

    public static void print(Map<String, Integer> map)
    {
        if (map.isEmpty())
        {
            System.out.println("map is empty");
        }

        else
        {
            System.out.println(map);
        }
    }
}