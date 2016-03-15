package Models;

import java.io.Serializable;

public class Boern implements Serializable{

    private String name;
    private int alder;

    public Boern(String name, int alder) {
        this.name = name;
        this.alder = alder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAlder() {
        return alder;
    }

    public void setAlder(int alder) {
        this.alder = alder;
    }

    @Override
    public String toString() {
        return "Boern{" +
                "name='" + name + '\'' +
                ", alder=" + alder +
                '}';
    }
}
