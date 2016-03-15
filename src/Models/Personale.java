package Models;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;

public class Personale {

    private SimpleStringProperty name;
    private SimpleStringProperty mobilnr;
    private SimpleStringProperty address;
    private SimpleStringProperty cprnr;
    private SimpleStringProperty mandagtid, tirsdagtid, onsdagtid, torsdagtid, fredagtid;
    private ArrayList<String> vagttider;



    public Personale(String name, String mobilnr, String address, String cprnr) {
        this.name = new SimpleStringProperty (name);
        this.mobilnr = new SimpleStringProperty(mobilnr);
        this.address = new SimpleStringProperty(address);
        this.cprnr = new SimpleStringProperty(cprnr);
        this.mandagtid = new SimpleStringProperty("");
        this.tirsdagtid = new SimpleStringProperty("");
        this.onsdagtid = new SimpleStringProperty("");
        this.torsdagtid = new SimpleStringProperty("");
        this.fredagtid = new SimpleStringProperty("");
    }

    public Personale() {
        this.name = new SimpleStringProperty("");
        this.mobilnr = new SimpleStringProperty("");
        this.address = new SimpleStringProperty("");
        this.cprnr = new SimpleStringProperty("");
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

    public String getMobilnr() {
        return mobilnr.get();
    }

    public SimpleStringProperty mobilnrProperty() {
        return mobilnr;
    }

    public void setMobilnr(String mobilnr) {
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

    public String getCprnr() {
        return cprnr.get();
    }

    public SimpleStringProperty cprnrProperty() {
        return cprnr;
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


    public ArrayList<String> getVagttider() {
        return vagttider;
    }

    public void setVagttider(ArrayList<String> vagttider) {
        this.vagttider = vagttider;
    }

    public String enkelteVagttid(int dag){
        ArrayList<String> liste = getVagttider();
        return liste.get(dag);
    }


    @Override
    public String toString() {
        return name.get();
    }
}
