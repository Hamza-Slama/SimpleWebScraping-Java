package model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/20/18 .
 * Email : hamzaslama8@gmail.com
 */
public class JumiaProduct { 
    
    private static  final AtomicInteger count = new AtomicInteger(0);
    private int id ;
    private String productName ;
    private String price ;
    private String currency ;
    private String brand ;
    private String linkToDetails ;
    private String imgPath;


    public JumiaProduct(){

    }


    public JumiaProduct(String productName, String price, String currency, String brand, String linkToDetails, String imgPath) {
        id=count.incrementAndGet();
        this.productName = productName;
        this.price = price;
        this.currency = currency;
        this.brand = brand;
        this.linkToDetails = linkToDetails;
        this.imgPath = imgPath;
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

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

