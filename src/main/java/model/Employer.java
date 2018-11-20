package model;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/17/18 .
 * Email : hamzaslama8@gmail.com
 */
public class Employer {
    public int id ;
    public String name ;
    public String destination;
    public String company ;

    public Employer(int id, String name, String destination, String company) {
        this.id = id;
        this.name = name;
        this.destination = destination;
        this.company = company;
    }
    public Employer (){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
