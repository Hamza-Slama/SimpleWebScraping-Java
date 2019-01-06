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

    


import java.io.File;
import java.util.List;

import org.apache.mahout.cf.taste.impl.model.file.FileDataModel;
import org.apache.mahout.cf.taste.impl.neighborhood.ThresholdUserNeighborhood;
import org.apache.mahout.cf.taste.impl.recommender.GenericUserBasedRecommender;
import org.apache.mahout.cf.taste.impl.similarity.CityBlockSimilarity;
import org.apache.mahout.cf.taste.model.DataModel;
import org.apache.mahout.cf.taste.neighborhood.UserNeighborhood;
import org.apache.mahout.cf.taste.recommender.RecommendedItem;
import org.apache.mahout.cf.taste.recommender.UserBasedRecommender;

public class FirstExp {

	public static void main(String[] args) {
	try {
		DataModel model = new FileDataModel(new File("./data.csv"));
		CityBlockSimilarity similarity = new CityBlockSimilarity(model);
		UserNeighborhood neighborhood = new ThresholdUserNeighborhood(0.1,similarity, model);
		UserBasedRecommender recommender = new GenericUserBasedRecommender(model, neighborhood, similarity);
		  
     		// The First argument is the userID and the Second parameter is 'HOW MANY'
      		List<RecommendedItem> recommendations = recommender.recommend(2,2);      
			
     		for (RecommendedItem recommendation : recommendations) {
			System.out.println(recommendation);
		}
		} catch (Exception e) {
			System.out.println("Exception occured !");
		}

	}

}