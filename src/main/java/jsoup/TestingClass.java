/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsoup;

import java.util.ArrayList;
import model.MyTeckFullDescription;

/**
 *
 * @author hamzewi
 */
public class TestingClass {
    public static void main(String[] args) {
        
       /* String str = "Ecran&nbsp;14.1\"&nbsp;IPS Full HD&nbsp;(1920 x 1080 px) - Processeur:&nbsp;Intel Atom x5-8350&nbsp;Quad-Core&nbsp;(1,44 GHz&nbsp;up to&nbsp;1.92 Ghz,&nbsp;2 Mo&nbsp;de Mémoire cache) - Systéme d'exploitation:&nbsp;Windows 10&nbsp;-&nbsp;Mémoire RAM:&nbsp;2 Go&nbsp;-&nbsp;Disque Dur:&nbsp;32 Go eMMC&nbsp;-&nbsp;Carte graphique:&nbsp;&nbsp;Intel HD Graphics, avec USB 3.0, Mini HDMI, Wifi, et Webcam 0.3 MP -&nbsp;Garantie:&nbsp;2&nbsp;ans Retrait en Magasin ou Livraison";
        String[] parts = str.split("-");
        for (int i = 0 ; i< str.length() -1 ; i++){
            System.out.println(""+parts[i]);
        }
        
        */
      /* MyTeckFullDescription n  = new MyTeckFullDescription();
        ArrayList<DataModelTest> m = new ArrayList<>();
        m.add(new DataModelTest(1,"d","d",n,"d","d","d"));
        */
      /*String s = "Frequence Processeur";
      if (s.contains("Référence Processeur"))System.out.println("ok");*/
     String description  = "Ecran:&nbsp;15.6'' IPS FHD (1920 x 1080 px),&nbsp;Processeur:&nbsp;Intel Core I5-7440HQ 7è gén (2.8 GHz jusqu‘à 3.8 GHz, 6Mo de mémoire cache, Quad-Core),&nbsp;Systéme d'exploitation: Windows 10 Pro&nbsp;-&nbsp;Mémoire RAM:&nbsp;8Go DDR4 2400 MHz,&nbsp;Disque Dur:&nbsp;256 Go SSDTo -&nbsp;Carte Graphique:&nbsp;NVIDIA&nbsp;Quadro&nbsp;M620 (2&nbsp;Go de mémoire GDDR5)&nbsp;avec USB-C&nbsp;, USB&nbsp;3.0 , HDMI, VGA et lecteur de cartes ";
      
      String unescapedString = org.jsoup.parser.Parser.unescapeEntities(description, true);
                        System.out.println(unescapedString);
                        description = unescapedString ;
        System.out.println(description);
    }
    
}
