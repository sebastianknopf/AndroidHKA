package eu.iums.androidhka.data;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import eu.iums.androidhka.model.CoordinatePoint;

@Database(entities = {CoordinatePoint.class}, version = 1)
public abstract class CoordinatePointDatabase extends RoomDatabase {

    public abstract CoordinatePointDataAccessObject dataAccessObject();

}
