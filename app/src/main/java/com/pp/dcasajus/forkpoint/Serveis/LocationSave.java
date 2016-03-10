package com.pp.dcasajus.forkpoint.Serveis;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by DSCU on 10/03/2016.
 */
public class LocationSave implements Parcelable {

    double lat;
    double lon;

    public LocationSave(double lat, double lon) {
        this.lat = lat;
        this.lon = lon;
    }

    protected LocationSave(Parcel in) {
        lat = in.readDouble();
        lon = in.readDouble();
    }

    public double getLat() {  return lat; }

    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }

    public void setLon(double lon) {  this.lon = lon;   }

    public static final Creator<LocationSave> CREATOR = new Creator<LocationSave>() {
        @Override
        public LocationSave createFromParcel(Parcel in) {
            return new LocationSave(in);
        }

        @Override
        public LocationSave[] newArray(int size) {
            return new LocationSave[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(lat);
        parcel.writeDouble(lon);
    }
}