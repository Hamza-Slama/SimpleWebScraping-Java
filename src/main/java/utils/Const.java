package utils;

import java.net.URI;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/19/18 .
 * Email : hamzaslama8@gmail.com
 */
public class Const {


    //MY_TECK
    public static String MY_TECK_BASE_URL = "https://www.mytek.tn";
    public static String MYTECK_URL_PC_PORTABLE = "https://www.mytek.tn/13-pc-portable?selected_filters=page-";
    public static String MYTECK_URL_PC_GAMER= "https://www.mytek.tn/15-pc-gamer-tunisie?selected_filters=page-";


    //WIKI
    public static String WIKI_BASE_URL = "https://www.wiki.tn";
    public static String WIKI_URL_PC_PORTABLE = "https://www.wiki.tn/pc-portable-120.html?selected_filters=page-";
    public static String WIKI_URL_PC_GAMER= "https://www.wiki.tn/pc-portable-gamer-85.html?selected_filters=page-";


    public static String JUMIA_BASE_URL = "https://www.jumia.com.tn/ordinateurs-portables/";
    public static String JUMIA_URL_PC_PORTABLE = "https://www.jumia.com.tn/ordinateurs-portables/?page=";
    public static String JUMIA_URLIMAGE_PATTERN = "https://tn.jumia.is";


    //FILE_NAMES
    public static  String SAMPLE_CSV_FILE = "./WIKILinkHashMpas.csv";
    public static  String SAMPLE_CSV_FILE_HashMap = "./WIKILinkSet.csv";

    public static  String CSV_FILE_WIKI_PC_GAMER = "./WikiPCPortableGamer.csv";

    public static  String CSV_FILE_MY_TECK_GAMER = "./myteckPCGamer.csv";
    public static  String CSV_FILE_MY_TECK_PC_PORTABLE = "./myteckPCPortable.csv";

    public static  String CSV_FILE_JUMIA_PC_PORTABLE = "./JumiaPCPortable.csv";

    public static void main(String[] args) {
        Float n = Float.valueOf(2);
        System.out.println(n);
    }
}


/*/*
1-myteck
2- https://www.jumia.com.tn/ordinateurs-portables/
3-https://www.wiki.tn/pc-portable-120.html
3- https://www.wiki.tn/pc-portable-120.html?selected_filters=page-5
4- https://www.spacenet.tn/ordinateur/ordinateurs-portables/pc-portable.html
5-https://www.scoop.com.tn/scoop-1-0-0-pc-portables-pc-portables
6-http://www.electro-tunis.tn/28-pc-portable
7http://www.mega.tn/informatique/ordinateur_portable
8-https://informatica.tn/24-pc-portable
 */