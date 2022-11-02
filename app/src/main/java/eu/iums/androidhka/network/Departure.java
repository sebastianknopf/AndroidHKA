package eu.iums.androidhka.network;

import com.google.gson.annotations.SerializedName;

public class Departure {

    @SerializedName("servingLine")
    private ServingLine servingLine;

    public ServingLine getServingLine() {
        return this.servingLine;
    }

    public void setServingLine(ServingLine servingLine) {
        this.servingLine = servingLine;
    }

}
