package eu.iums.androidhka.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import eu.iums.androidhka.R;
import eu.iums.androidhka.model.CoordinatePoint;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        final ListView coordinatePointListView = root.findViewById(R.id.lstCoordinatePoints);

        dashboardViewModel.getCoordinatePoints().observe(getViewLifecycleOwner(), new Observer<List<CoordinatePoint>>() {
            @Override
            public void onChanged(List<CoordinatePoint> coordinatePoints) {
                String[] displayValues = new String[coordinatePoints.size()];
                for(int i = 0; i < coordinatePoints.size(); i++) {
                    CoordinatePoint cp = coordinatePoints.get(i);
                    displayValues[i] = String.format("%f, %f", cp.Latitude, cp.Longitude);
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<String>(requireContext(), android.R.layout.simple_list_item_1, android.R.id.text1, displayValues);
                coordinatePointListView.setAdapter(adapter);
            }
        });

        return root;
    }
}