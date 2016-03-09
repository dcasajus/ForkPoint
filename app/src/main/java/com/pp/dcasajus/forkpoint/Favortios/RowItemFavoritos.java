package com.pp.dcasajus.forkpoint.Favortios;

/**
 * Created by denisplata on 02/03/2016.
 */
public class RowItemFavoritos {

    private String title;
    private int icon;
    private String carrer;
    private String preu;

    public RowItemFavoritos(String title, int icon, String carrer, String preu) {
        this.title = title;
        this.icon = icon;
        this.carrer=carrer;
        this.preu = preu;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getCarrer() { return carrer;  }

    public void setCarrer(String carrer) { this.carrer = carrer;  }

    public String getPreu() { return preu; }

    public void setPreu(String preu) {  this.preu = preu;  }
}