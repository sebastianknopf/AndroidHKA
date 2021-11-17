package eu.iums.androidhka.ui.dashboard;

import java.util.List;
import java.util.concurrent.Executors;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import eu.iums.androidhka.DatabaseApplication;
import eu.iums.androidhka.data.CoordinatePointDatabase;
import eu.iums.androidhka.model.CoordinatePoint;

public class DashboardViewModel extends ViewModel {

    private MutableLiveData<List<CoordinatePoint>> coordinatePoints;

    public DashboardViewModel() {
        this.coordinatePoints = new MutableLiveData<>();

        Executors.newSingleThreadExecutor().execute(() -> {
            CoordinatePointDatabase cpd = DatabaseApplication.getCoordinatePointDatabase();
            this.coordinatePoints.postValue(cpd.dataAccessObject().getAllCoordinatePoints());
        });
    }

    public LiveData<List<CoordinatePoint>> getCoordinatePoints() {
        return this.coordinatePoints;
    }
}