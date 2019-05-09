package rahul.com.retrotest;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import androidx.work.Constraints;
import androidx.work.Data;
import androidx.work.ExistingPeriodicWorkPolicy;
import androidx.work.ExistingWorkPolicy;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkInfo;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    Sign_In_Respose respose;
    EditText editText;
    Button signUp,nextclass,ServiceActivity,jobintentservice,firebaseactivity;
    TextView tviewworkresult;
    DrugsTable drugsTable;
    public static final String TAG_KEY="TAG_INPUT_KEY";
    public static final String OUTPUT_KEY="TAG_OUTPUT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "Main "+Thread.currentThread().getId(), Toast.LENGTH_SHORT).show();
        Log.i("information of thread","MAin thread drug list "+Thread.currentThread().getId());

        drugsTable= new DrugsTable(this);
        tviewworkresult=findViewById(R.id.tviewworkresult);
        editText = (EditText) findViewById(R.id.email);
        signUp = (Button) findViewById(R.id.signUp);
        nextclass = (Button) findViewById(R.id.nextclass);
        firebaseactivity = (Button) findViewById(R.id.firebaseactivity);
        jobintentservice=findViewById(R.id.jobintentservice);
        ServiceActivity=findViewById(R.id.Serviceactivity);

        firebaseactivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),FireBaseActivity.class);
                startActivity(intent);
            }
        });
        jobintentservice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),JobActivity.class);
                startActivity(intent);
            }
        });
        nextclass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),nextActivity.class);
                startActivity(intent);
            }
        });
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validate the fields and call sign method to implement the api
                if (validate(editText)) {
                    CallWorker();
                }
            }
        });
        ServiceActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getApplicationContext(),ServiceActivity.class);
                startActivity(intent);
            }
        });
    }

    private void CallWorker() {
        Data data= new Data.Builder()
                .putString(TAG_KEY,editText.getText().toString().trim())
                .build();

        Constraints constraints= new Constraints.Builder()
                .build();
        final OneTimeWorkRequest request= new OneTimeWorkRequest.Builder(MyWorker.class)
                .setInputData(data)
                .setConstraints(constraints)
                .build();
        WorkManager.getInstance().enqueueUniqueWork("MyWork", ExistingWorkPolicy.KEEP,request);

        WorkManager.getInstance().getWorkInfoByIdLiveData(request.getId())
                .observe(this, new Observer<WorkInfo>() {
                    @Override
                    public void onChanged(@Nullable WorkInfo workInfo) {
                        String status=workInfo.getState().name();
                        if (workInfo.getState().isFinished()){
                            String result=workInfo.getOutputData().getString(OUTPUT_KEY);
                            tviewworkresult.append(status+"\n"+result);
                            Toast.makeText(MainActivity.this, "Work done", Toast.LENGTH_SHORT).show();
                        }else{
                            tviewworkresult.append(status+"\n");
                        }
                    }
                });
    }
    private boolean validate(EditText editText) {
        // check the lenght of the enter data in EditText and give error if its empty
        if (editText.getText().toString().trim().length() > 0) {
            return true; // returs true if field is not empty
        }
        editText.setError("Please Fill This");
        editText.requestFocus();
        return false;
    }
}



/*Call<Sign_In_Respose> call =apiInterface.login(email.getText().toString().trim());
        //finally get the call response
        call.enqueue(new Callback<Sign_In_Respose>() {
            @Override
            public void onResponse(Call<Sign_In_Respose> call, Response<Sign_In_Respose> response) {
                String error=response.body().getResponse();
                List<Array_list> message=response.body().getData();
                progressDialog.dismiss();
                String strStatus="6";

                for (int i=0;i<message.size();i++){
                    String Created_By=message.get(i).getCreated_By();
                    String Genric_name=message.get(i).getGenric_name();
                    String Unit_Id=message.get(i).getUnit_Id();
                    String Org_Id=message.get(i).getOrg_Id();
                    String Drug_Id=message.get(i).getDrug_Id();

                    drugsTable.open();
                    drugsTable.insertEntry(Drug_Id,Org_Id,Unit_Id,"",Genric_name,
                            "","","",strStatus,Created_By, "","",
                            "","","" );
                    drugsTable.close();
                }

                // Get the root JsonObject

            }

            @Override
            public void onFailure(Call<Sign_In_Respose> call, Throwable throwable) {
                progressDialog.dismiss();
                Toast.makeText(MainActivity.this, "error occured", Toast.LENGTH_SHORT).show();
            }
        });*/