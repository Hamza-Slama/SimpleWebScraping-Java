package model;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Hamza Slama (Hamzeoui) on 11/17/18 .
 * Email : hamzaslama8@gmail.com
 */
public class Data {

    private static final AtomicInteger count = new AtomicInteger(0);
    int nbrLink;
    boolean visited ;
    int id;

    public Data( int nbrLink, boolean visited) {

        this.nbrLink = nbrLink;
        this.visited = visited;
        this.id = count.incrementAndGet();
    }

    public static AtomicInteger getCount() {
        return count;
    }

    public int getNbrLink() {
        return nbrLink;
    }

    public void setNbrLink(int nbrLink) {
        this.nbrLink = nbrLink;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
