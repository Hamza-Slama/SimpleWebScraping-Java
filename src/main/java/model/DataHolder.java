package model;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author hamzewi
 */
public class DataHolder    {
    private static final AtomicInteger count = new AtomicInteger(0);
    String webSite ;
    int nbrLink;
       boolean visited ;
       int id;
    public DataHolder(String webSite, int nbrLink, boolean visited) {
        webSite = webSite;
        this.nbrLink = nbrLink;
        this.visited = visited;
        id = count.incrementAndGet();
    }
    public DataHolder(String webSite, int nbrLink, boolean visited, int id) {
        webSite = webSite;
        this.nbrLink = nbrLink;
        this.visited = visited;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataHolder that = (DataHolder) o;
        return id == that.id &&
                Objects.equals(webSite, that.webSite);
    }

    @Override
    public int hashCode() {

        return Objects.hash(webSite, id);
    }



        public String getWebSite() {
            return webSite;
        }

        public int getNbrLink() {
            return nbrLink;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setwebSite(String webSite) {
            webSite = webSite;
        }

        public void setNbrLink(int nbrLink) {
            this.nbrLink = nbrLink;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

    }





