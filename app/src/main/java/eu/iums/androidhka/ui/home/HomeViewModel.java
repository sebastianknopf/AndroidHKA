package eu.iums.androidhka.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import eu.iums.androidhka.DatabaseApplication;
import eu.iums.androidhka.data.CoordinatePointDatabase;
import eu.iums.androidhka.model.CoordinatePoint;

public class HomeViewModel extends ViewModel {

    public HomeViewModel() {
    }

    public void addCoordinatePoint(double lat, double lon) {
        CoordinatePoint cp = new CoordinatePoint();
        cp.Latitude = lat;
        cp.Longitude = lon;

        CoordinatePointDatabase cpd = DatabaseApplication.getCoordinatePointDatabase();
        cpd.dataAccessObject().insertCoordinatePoints(cp);
    }
}