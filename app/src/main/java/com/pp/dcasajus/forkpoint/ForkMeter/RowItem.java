package com.pp.dcasajus.forkpoint.ForkMeter;

/**
 * Created by denisplata on 17/02/2016.
 */
public class RowItem {

    private String title;
    private int icon;
    private String carrer;
    private String preu;
    private Double lat;
    private Double lon;

    public RowItem(String title, int icon, String carrer, String preu, Double lat,Double lon) {
        this.lat = lat;
        this.icon = icon;
        this.carrer = carrer;
        this.preu = preu;
        this.title = title;
        this.lon = lon;
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

    public Double getLat() { return lat;  }

    public void setLat(Double lat) {   this.lat = lat; }

    public Double getLon() {   return lon;  }

    public void setLon(Double lon) {    this.lon = lon;   }
}

