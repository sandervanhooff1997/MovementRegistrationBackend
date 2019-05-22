package models;

import javax.persistence.*;
import java.awt.geom.Point2D;
import java.util.Date;

@Entity
@Table(name = "movements")
public class Movement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String serialNumber;

    private String address;

    private Point2D.Double coordinate;

    private String authCode;

    private Date date;

    private Long carTracker_id;


    public Movement() {
    }

    public Movement(String serialNumber, Long carTracker) {
        this.serialNumber = serialNumber;
        this.carTracker_id = carTracker;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Point2D.Double getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Point2D.Double coordinate) {
        this.coordinate = coordinate;
    }

    public String getAuthCode() {
        return authCode;
    }

    public void setAuthCode(String authCode) {
        this.authCode = authCode;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getCarTracker_id() {
        return carTracker_id;
    }

    public void setCarTracker_id(Long carTracker_id) {
        this.carTracker_id = carTracker_id;
    }

    @Override
    public String toString() {
        return "Movement{" +
                "id=" + id +
                ", serialNumber='" + serialNumber + '\'' +
                ", address='" + address + '\'' +
                ", coordinate=" + coordinate +
                ", authCode='" + authCode + '\'' +
                ", date=" + date +
                ", carTracker=" + carTracker_id +
                '}';
    }
}
