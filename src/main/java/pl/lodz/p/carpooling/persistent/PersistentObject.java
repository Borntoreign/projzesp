package pl.lodz.p.carpooling.persistent;

import javax.persistence.*;

/**
 * Created by Mateusz Surmanski on 01.11.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class PersistentObject {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private long id;

    public long getId() {
        return id;
    }
}
