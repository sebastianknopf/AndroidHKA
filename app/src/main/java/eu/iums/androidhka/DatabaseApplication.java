package eu.iums.androidhka;

import android.app.Application;

import androidx.room.Room;
import eu.iums.androidhka.data.CoordinatePointDatabase;

public class DatabaseApplication extends Application {

    private static CoordinatePointDatabase coordinatePointDatabase;

    public DatabaseApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        coordinatePointDatabase = Room.databaseBuilder(this, CoordinatePointDatabase.class, "CoordinatePoints.db3")
                .createFromAsset("CoordinatePoints.db3")
                .allowMainThreadQueries()
                .build();
    }

    public static CoordinatePointDatabase getCoordinatePointDatabase() {
        return coordinatePointDatabase;
    }
}
