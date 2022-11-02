package eu.iums.androidhka.network;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("departureList")
    private List<Departure> departureList;

    public List<Departure> getDepartureList() {
        return this.departureList;
    }

    public void setDepartureList(List<Departure> departureList) {
        this.departureList = departureList;
    }
}
