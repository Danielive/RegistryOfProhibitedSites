package live.daniel.webapps.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Daniel on 29.09.2017.
 */
@Entity
@Table(name = "Registry")
public class Registry implements Serializable {
    private static final long serialVersionUID = -3009157732242241606L;
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
        return String.format("Registry[id=%d, link='%s', ip='%s', date='%s']", id, link, ip, date);
    }
}
