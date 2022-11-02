package eu.iums.androidhka.network;

import com.google.gson.annotations.SerializedName;

public class ServingLine {

    @SerializedName("number")
    private String number;

    @SerializedName("name")
    private String name;

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
