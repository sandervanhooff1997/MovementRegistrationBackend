package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cartrackers")
public class Cartracker {

    @Id
    @GeneratedValue
    private Long id;

    @OneToMany
    private List<Movement> movements = new ArrayList<>();

    public Cartracker() {
    }
}
