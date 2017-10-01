package live.daniel.webapps.model;

import javax.persistence.*;

/**
 * Created by Daniel on 29.09.2017.
 */
@Entity
@Table(name = "Registry")
public class Registry {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "link")
    private String link;

    @Column(name = "ip")
    private String ip;

    @Column(name = "date")
    private String date;

    protected Registry() {
    }

    public Registry(String link, String ip, String date) {
        this.link = link;
        this.ip = ip;
        this.date = date;
    }

    @Override
    public String toString() {
        return "{" + "\"id\":" + id + ",\"link\":\"" + link + "\",\"ip\":\"" + ip + "\",\"date\":\"" + date + "\"}";
    }
}
