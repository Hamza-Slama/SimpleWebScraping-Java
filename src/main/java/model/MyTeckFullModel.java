/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author hamzewi
 */
public class MyTeckFullModel {
        private static  final AtomicInteger count = new AtomicInteger(0);
    private int id ;
    private String productName ;
    private String price ;
    private ArrayList<String> fulldescription  ; 
    private String desciption ;
    private String linkToDetails ;
    private String imgPath;

    public MyTeckFullModel() {
    }

    public MyTeckFullModel( String productName, String price, ArrayList<String> fulldescription, String desciption, String linkToDetails, String imgPath) {
         id = count.incrementAndGet();
        this.productName = productName;
        this.price = price;
        this.fulldescription = fulldescription;
        this.desciption = desciption;
        this.linkToDetails = linkToDetails;
        this.imgPath = imgPath;
    }

    public ArrayList<String> getFulldescription() {
        return fulldescription;
    }

    public void setFulldescription(ArrayList<String> fulldescription) {
        this.fulldescription = fulldescription;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public String getLinkToDetails() {
        return linkToDetails;
    }

    public void setLinkToDetails(String linkToDetails) {
        this.linkToDetails = linkToDetails;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
    
    
    
}
