package rahul.com.retrotest;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("/services/drug_list.php")
    Call<Drug_table_Modal> login(@Field("Org_Id")String Org_id);

    @GET("/services/fetch_patients_basic_info.php")
    Call<Basic_Response> Getdata(@Query("PatientId") String Patient_Id);
}
