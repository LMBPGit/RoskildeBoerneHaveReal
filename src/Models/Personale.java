package Models;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Personale {

    private SimpleStringProperty name;
    private SimpleIntegerProperty mobilnr;
    private SimpleStringProperty address;
    private SimpleIntegerProperty cprnr;
    private SimpleDoubleProperty mandagtid, tirsdagtid, onsdagtid, torsdagtid, fredagtid;
    private ArrayList<String> vagttider;



    public Personale(String name, int mobilnr, String address, int cprnr, double mantid,double tirstid,double onstid,double torstid,double fretid) {
        this.name = new SimpleStringProperty (name);
        this.mobilnr = new SimpleIntegerProperty(mobilnr);
        this.address = new SimpleStringProperty(address);
        this.cprnr = new SimpleIntegerProperty(cprnr);
        this.mandagtid = new SimpleDoubleProperty(mantid);
        this.tirsdagtid = new SimpleDoubleProperty(tirstid);
        this.onsdagtid = new SimpleDoubleProperty(onstid);
        this.torsdagtid = new SimpleDoubleProperty(torstid);
        this.fredagtid = new SimpleDoubleProperty(fretid);
    }

    public Personale() {
        this.name = new SimpleStringProperty("");
        this.mobilnr = new SimpleIntegerProperty(0);
        this.address = new SimpleStringProperty("");
        this.cprnr = new SimpleIntegerProperty(0);
        this.mandagtid = new SimpleDoubleProperty(0);
        this.tirsdagtid = new SimpleDoubleProperty(0);
        this.onsdagtid = new SimpleDoubleProperty(0);
        this.torsdagtid = new SimpleDoubleProperty(0);
        this.fredagtid = new SimpleDoubleProperty(0);
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

    public double getMandagtid() {
        return mandagtid.get();
    }

    public SimpleDoubleProperty mandagtidProperty() {
        return mandagtid;
    }

    public void setMandagtid(double mandagtid) {
        this.mandagtid.set(mandagtid);
    }

    public double getTirsdagtid() {
        return tirsdagtid.get();
    }

    public SimpleDoubleProperty tirsdagtidProperty() {
        return tirsdagtid;
    }

    public void setTirsdagtid(double tirsdagtid) {
        this.tirsdagtid.set(tirsdagtid);
    }

    public double getOnsdagtid() {
        return onsdagtid.get();
    }

    public SimpleDoubleProperty onsdagtidProperty() {
        return onsdagtid;
    }

    public void setOnsdagtid(double onsdagtid) {
        this.onsdagtid.set(onsdagtid);
    }

    public double getTorsdagtid() {
        return torsdagtid.get();
    }

    public SimpleDoubleProperty torsdagtidProperty() {
        return torsdagtid;
    }

    public void setTorsdagtid(double torsdagtid) {
        this.torsdagtid.set(torsdagtid);
    }

    public double getFredagtid() {
        return fredagtid.get();
    }

    public SimpleDoubleProperty fredagtidProperty() {
        return fredagtid;
    }

    public void setFredagtid(double fredagtid) {
        this.fredagtid.set(fredagtid);
    }
}
