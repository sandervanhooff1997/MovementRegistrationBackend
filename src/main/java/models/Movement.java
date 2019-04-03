package models;

import javax.persistence.*;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue
    private Long id;

    private String serialNumber;

    @ManyToOne
    private Cartracker cartracker;

    public Movement() {

    }

    public Movement(String serialNumber, Cartracker cartracker) {
        this.serialNumber = serialNumber;
        this.cartracker = cartracker;
    }

    public Movement(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Cartracker getCartracker() {
        return cartracker;
    }

    public void setCartracker(Cartracker cartracker) {
        this.cartracker = cartracker;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", cartracker=" + cartracker +
                '}';
    }
}
