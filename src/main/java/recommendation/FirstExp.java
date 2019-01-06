/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recommendation;

/**
 *
 * @author hamzewi
 */

    


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static jsoup.MyJumiaProductScrapper.getProductFromJumia;
import model.JumiaProduct;
import model.RecommendationData;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;
import static utils.Const.CSV_FAKE_DATA;
import static utils.Const.CSV_FILE_JUMIA_PC_PORTABLE;
import static utils.Const.JUMIA_URL_PC_PORTABLE;

public class FirstExp {
        static int  x = 1 ;
	public static void main(String[] args) throws IOException {
   
            // SaveData();
          
         getItemIdListRecommended(1L,10);
           
            //SaveData();
	
        
      /*  double m =Math.floor(Math.ceil( Math.random()*10000));
         //   System.out.println(m);
            System.out.println(String.format ("%,.0f", m));*/
	}
        
        public static ArrayList<RecommendationData> getList(){
            
            ArrayList<RecommendationData> arr = new ArrayList<>();
            for (int i = 0 ; i< 10000; i++){
                
                Random r = new Random();
                int lowerBound = 1;
                int upperBound = 100;
                int userId = r.nextInt(upperBound-lowerBound) + lowerBound;
               //int userId =Math.floor(Math.ceil( Math.random()*10000));
         //   System.out.println(m);
            
            
             int productId =r.nextInt(upperBound-lowerBound) + lowerBound;
             
              int coeff =r.nextInt(1000) + lowerBound;
            arr.add(new RecommendationData(userId,productId,coeff));
                
                System.out.println("UserId = "+userId+" , productId = "+productId + " , Coeff = "+coeff);
            }
            
            
            return arr;
        }
        
        public static void SaveData() throws IOException{
             ArrayList<RecommendationData> maps = getList();
        
          try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(CSV_FAKE_DATA));
             CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT);
                  //   .withHeader("ID", "productName", "price", "currency","brand","linkToDetails","imgPath")
                  ) {

            maps.forEach((recomData)->{
                try {
                    System.out.println(recomData.getUserId());
                    csvPrinter.printRecord(recomData.getUserId(),recomData.getProductId()
                            ,recomData.getCoeff());
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            csvPrinter.flush();
        }
        }
        
        public static ArrayList<Long> getItemIdListRecommended(Long itemId , int nbrmItem){
            ArrayList<Long> arr = new ArrayList<>();
            try {
            
		DataModel model = new FileDataModel(new File("./data.csv"));
		CityBlockSimilarity similarity = new CityBlockSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.0001,similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		  
     		// The First argument is the userID and the Second parameter is 'HOW MANY'
      		List<RecommendedItem> recommendations = recommender.recommend(itemId,nbrmItem);      
			
     		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
                      //  System.out.println();
                      arr.add(recommendation.getItemID());
		}
                
                
		} catch (Exception e) {
			System.out.println("Exception occured !");
		}
            return arr ; 

        }

       
}