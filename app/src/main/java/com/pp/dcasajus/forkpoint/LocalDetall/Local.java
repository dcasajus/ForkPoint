package com.pp.dcasajus.forkpoint.LocalDetall;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by denisplata on 18/02/2016.
 */
public class Local implements Parcelable {
    long id;
    String local;
    String carrer;
    String preu;
    int Icons;
    int isFavorite;
    String horari;
    double lat;
    double lon;
    String descripcio;
    List<String> comentaris;



    public Local(long id,String local, String carrer, String preu, int icons, int isFavorite, String horari, double lat, double lon,String descripcio, List<String> comentaris) {
        this.id =id;
        this.local = local;
        this.carrer = carrer;
        this.preu = preu;
        Icons = icons;
        this.isFavorite = isFavorite;
        this.horari = horari;
        this.lat = lat;
        this.lon = lon;
        this.descripcio = descripcio;
        this.comentaris = comentaris;
    }

    protected Local(Parcel in) {
        id = in.readLong();
        local = in.readString();
        carrer = in.readString();
        preu = in.readString();
        Icons = in.readInt();
        isFavorite = in.readByte();
        horari = in.readString();
        lat = in.readDouble();
        lon = in.readDouble();
        descripcio = in.readString();
        comentaris = in.createStringArrayList();

    }

    public static final Creator<Local> CREATOR = new Creator<Local>() {
        @Override
        public Local createFromParcel(Parcel in) {
            return new Local(in);
        }

        @Override
        public Local[] newArray(int size) {
            return new Local[size];
        }
    };

    public long getId() {  return id;  }

    public void setId(long id) {    this.id = id;   }

    public String getLocal() { return local;  }

    public String getCarrer() {   return carrer;   }

    public String getPreu() {    return preu;   }

    public void setLocal(String local) {
        this.local = local;
    }

    public void setCarrer(String carrer) {
        this.carrer = carrer;
    }

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

    public  List<String> getComentaris() {  return comentaris;    }

    public void setComentaris(List<String> comentaris) {   this.comentaris = comentaris;    }

    @Override
    public String toString() {
        return "Local{" +
                "id=" + id +
                ", local='" + local + '\'' +
                ", carrer='" + carrer + '\'' +
                ", preu='" + preu + '\'' +
                ", Icons=" + Icons +
                ", isFavorite=" + isFavorite +
                ", horari='" + horari + '\'' +
                ", lat=" + lat +
                ", lon=" + lon +
                ", descripcio='" + descripcio + '\'' +
                ", comentaris='" + comentaris + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(id);
        dest.writeString(local);
        dest.writeString(carrer);
        dest.writeString(preu);
        dest.writeInt(Icons);
        dest.writeInt(isFavorite);
        dest.writeString(horari);
        dest.writeDouble(lat);
        dest.writeDouble(lon);
        dest.writeString(descripcio);
        dest.writeStringList(comentaris);


    }
}
