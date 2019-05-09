package rahul.com.retrotest;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DrugService extends Service {
    DrugsTable drugsTable;
    public static final String NOTIFICATION_CHANNEL_ID="Channel";
    public static final String NOTIFICATION_CHANNEL_Name="Channel_name";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CreateNotificationChannel();
        } else {
            startForeground(1, new Notification());
        }
    }
    private void CreateNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, NOTIFICATION_CHANNEL_Name, NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(notificationChannel);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Notification notification = new NotificationCompat.Builder(this, NOTIFICATION_CHANNEL_ID)
                    .setPriority(NotificationManager.IMPORTANCE_MIN)
                    .setCategory(Notification.CATEGORY_SERVICE)
                    .setContentTitle("RetroTest Service")
                    .setContentText("Service is running")
                    .setSmallIcon(R.mipmap.ic_launcher)
                    .build();
            startForeground(1, notification);
        }
        Toast.makeText(this, "Service started", Toast.LENGTH_SHORT).show();
        String Drug_Id=intent.getStringExtra("Drug_Id");
        ApiInterface apiInterface=RetrofitApiClass.getApiInterface();
        Call<Drug_table_Modal> call =apiInterface.login("5");
        drugsTable= new DrugsTable(getApplicationContext());
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
                    stopSelf();
                }else{
                    Toast.makeText(getApplicationContext(), "Drug list not found", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<Drug_table_Modal> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Not connected to internet", Toast.LENGTH_SHORT);
            }
        });
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
