package com.example.DSCU.myapplication.backend;

/** The object model for the data we are sending through endpoints */
class LocalBean {
    private  String local;
    private  String carrer;
    private String preu;
    private  int Icons;
    private int isFavorite;
    private String horari;
    private double lat;
    private double lon;
    private  String descripcio;
    private Long id;

    private String myData;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    public String getData() { return myData;   }

    public void setData(String data) {
        myData = data;
    }

    public String getLocal() { return local;  }

    public String getCarrer() {   return carrer;   }

    public String getPreu() {    return preu;   }

    public void setLocal(String data) {
        local = data;
    }

    public void setCarrer(String carrer) {   this.carrer = carrer;    }

    public void setPreu(String edatmin) {
        this.preu = edatmin;
    }

    public int getIcons() {
        return Icons;
    }

    public void setIcons(int icons) {
        Icons = icons;
    }

    public int getIsFavorite() {
        return isFavorite;
    }

    public String getHorari() {
        return horari;
    }

    public void setHorari(String horari) {
        this.horari = horari;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setIsFavorite(int isFavorite) {
        this.isFavorite = isFavorite;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }
}