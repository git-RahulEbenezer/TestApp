package rahul.com.retrotest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyWorker extends Worker {
    DrugsTable drugsTable;
    public MyWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }

    @NonNull
    @Override
    public Result doWork() {
        drugsTable= new DrugsTable(getApplicationContext());
        Data data=getInputData();

        ApiInterface apiInterface=RetrofitApiClass.getApiInterface();
        Call<Drug_table_Modal> call =apiInterface.login(data.getString(MainActivity.TAG_KEY));

        call.enqueue(new Callback<Drug_table_Modal>() {
            @Override
            public void onResponse(Call<Drug_table_Modal> call, Response<Drug_table_Modal> response) {
                String res=response.body().getResponse();
                if (res.equals("true")){
                    List<Drug_table_Modal_Array> message=response.body().getData();
                    drugsTable.open();
                    drugsTable.deleteRows();

                    String strStatus = "6";
                    for (int i=0;i<message.size();i++){
                        drugsTable.insertEntry(message.get(i).getDrug_Id(),message.get(i).getOrg_Id(),message.get(i).getUnit_Id(),"",message.get(i).getGenric_name(),
                                "","","",strStatus,message.get(i).getCreated_By(), "","",
                                "","","" );
                    }

                    drugsTable.close();
                    Toast.makeText(getApplicationContext(), "fetched", Toast.LENGTH_SHORT).show();

                    int count =drugsTable.getRecordCount();
                    Toast.makeText(getApplicationContext(), ""+count, Toast.LENGTH_SHORT).show();
                    Log.i("information of thread","retrofit drug list "+Thread.currentThread().getId());

                }else{
                    Toast.makeText(getApplicationContext(), "Drug list not found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Drug_table_Modal> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Not connected to internet", Toast.LENGTH_SHORT);
            }
        });
        Data data1= new Data.Builder()
                .putString(MainActivity.OUTPUT_KEY,"Done Loading to database")
                .build();
        return Result.success(data1);
    }
}
