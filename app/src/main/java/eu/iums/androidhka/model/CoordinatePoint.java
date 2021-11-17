package eu.iums.androidhka.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "coordinate_points")
public class CoordinatePoint {

    @PrimaryKey(autoGenerate = true)
    public int ID;

    @ColumnInfo(name = "lat")
    public double Latitude;

    @ColumnInfo(name = "lon")
    public double Longitude;

}
