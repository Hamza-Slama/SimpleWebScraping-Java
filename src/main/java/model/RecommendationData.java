/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author hamzewi
 */
public class RecommendationData {
    int userId;
    int productId;
    int coeff ; 

    public RecommendationData() {
    }

    public RecommendationData(int userId, int productId, int coeff) {
        this.userId = userId;
        this.productId = productId;
        this.coeff = coeff;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCoeff() {
        return coeff;
    }

    public void setCoeff(int coeff) {
        this.coeff = coeff;
    }
    
    
    
}
