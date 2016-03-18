package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Struct;
import java.util.ArrayList;

public class Personale {

    private SimpleStringProperty name;
    private SimpleIntegerProperty mobilnr;
    private SimpleStringProperty address;
    private SimpleIntegerProperty cprnr;
    private SimpleStringProperty mandagtid, tirsdagtid, onsdagtid, torsdagtid, fredagtid;
    private ArrayList<String> vagttider;



    public Personale(String name, int mobilnr, String address, int cprnr, String mantid,String tirstid,String onstid,String torstid,String fretid) {
        this.name = new SimpleStringProperty (name);
        this.mobilnr = new SimpleIntegerProperty(mobilnr);
        this.address = new SimpleStringProperty(address);
        this.cprnr = new SimpleIntegerProperty(cprnr);
        this.mandagtid = new SimpleStringProperty(mantid);
        this.tirsdagtid = new SimpleStringProperty(tirstid);
        this.onsdagtid = new SimpleStringProperty(onstid);
        this.torsdagtid = new SimpleStringProperty(torstid);
        this.fredagtid = new SimpleStringProperty(fretid);
    }

    public Personale() {
        this.name = new SimpleStringProperty("");
        this.mobilnr = new SimpleIntegerProperty(0);
        this.address = new SimpleStringProperty("");
        this.cprnr = new SimpleIntegerProperty(0);
        this.mandagtid = new SimpleStringProperty("");
        this.tirsdagtid = new SimpleStringProperty("");
        this.onsdagtid = new SimpleStringProperty("");
        this.torsdagtid = new SimpleStringProperty("");
        this.fredagtid = new SimpleStringProperty("");
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getMobilnr() {
        return mobilnr.get();
    }

    public SimpleIntegerProperty mobilnrProperty() {
        return mobilnr;
    }

    public void setMobilnr(int mobilnr) {
        this.mobilnr.set(mobilnr);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public int getCprnr() {
        return cprnr.get();
    }

    public SimpleIntegerProperty cprnrProperty() {
        return cprnr;
    }

    public void setCprnr(int cprnr) {
        this.cprnr.set(cprnr);
    }

    public String getMandagtid() {
        return mandagtid.get();
    }

    public SimpleStringProperty mandagtidProperty() {
        return mandagtid;
    }

    public void setMandagtid(String mandagtid) {
        this.mandagtid.set(mandagtid);
    }

    public String getTirsdagtid() {
        return tirsdagtid.get();
    }

    public SimpleStringProperty tirsdagtidProperty() {
        return tirsdagtid;
    }

    public void setTirsdagtid(String tirsdagtid) {
        this.tirsdagtid.set(tirsdagtid);
    }

    public String getOnsdagtid() {
        return onsdagtid.get();
    }

    public SimpleStringProperty onsdagtidProperty() {
        return onsdagtid;
    }

    public void setOnsdagtid(String onsdagtid) {
        this.onsdagtid.set(onsdagtid);
    }

    public String getTorsdagtid() {
        return torsdagtid.get();
    }

    public SimpleStringProperty torsdagtidProperty() {
        return torsdagtid;
    }

    public void setTorsdagtid(String torsdagtid) {
        this.torsdagtid.set(torsdagtid);
    }

    public String getFredagtid() {
        return fredagtid.get();
    }

    public SimpleStringProperty fredagtidProperty() {
        return fredagtid;
    }

    public void setFredagtid(String fredagtid) {
        this.fredagtid.set(fredagtid);
    }
}
