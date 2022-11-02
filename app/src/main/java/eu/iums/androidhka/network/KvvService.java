package eu.iums.androidhka.network;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KvvService {

    @GET("sl3-alone/XSLT_DM_REQUEST?outputFormat=JSON&coordOutputFormat=WGS84[dd.ddddd]&depType=stopEvents&locationServerActive=1&mode=direct&name_dm=7001001&type_dm=stop&useOnlyStops=1&useRealtime=1")
    Call<Result> listDepartures();

}
