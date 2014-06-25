package de.hawai.mps.transport;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@Entity(name = "TransportTask")
@Table(appliesTo = "TransportTask")
@XmlRootElement(name = "account")
public class TransportTaskBean implements Serializable {

    @Id
    @GeneratedValue
    @GenericGenerator(name = "idGen", strategy = "increment")
    private int id;

    @Column
    private int remoteId;

    @Column
    private String countryCode;

    @Column
    private String city;

    @Column
    private String postal;

    @Column
    private String address;

    @Column
    private boolean send;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRemoteId() {
        return remoteId;
    }

    public void setRemoteId(int remoteId) {
        this.remoteId = remoteId;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isSend() {
        return send;
    }

    public void setSend(boolean send) {
        this.send = send;
    }
}
