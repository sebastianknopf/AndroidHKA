package eu.iums.androidhka.data;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import eu.iums.androidhka.model.CoordinatePoint;

@Dao
public interface CoordinatePointDataAccessObject {

    @Query("SELECT * FROM coordinate_points")
    List<CoordinatePoint> getAllCoordinatePoints();

    @Insert
    void insertCoordinatePoints(CoordinatePoint... cps);

}
