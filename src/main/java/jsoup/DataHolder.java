package jsoup;

import java.util.Comparator;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;


/**
 *
 * @author hamzewi
 */
public class DataHolder    {
    private static final AtomicInteger count = new AtomicInteger(0);
    String Website ;
    int nbrLink;
       boolean visited ;
       int id;

    public DataHolder(String website, int nbrLink, boolean visited, int id) {
        Website = website;
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
                Objects.equals(Website, that.Website);
    }

    @Override
    public int hashCode() {

        return Objects.hash(Website, id);
    }

    public DataHolder(String website, int nbrLink, boolean visited) {
            Website = website;
            this.nbrLink = nbrLink;
            this.visited = visited;
            id = count.incrementAndGet();
    }

        public String getWebsite() {
            return Website;
        }

        public int getNbrLink() {
            return nbrLink;
        }

        public boolean isVisited() {
            return visited;
        }

        public void setWebsite(String website) {
            Website = website;
        }

        public void setNbrLink(int nbrLink) {
            this.nbrLink = nbrLink;
        }

        public void setVisited(boolean visited) {
            this.visited = visited;
        }

    }





