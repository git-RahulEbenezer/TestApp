package rahul.com.retrotest;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;
import android.util.Log;

public class MyJobIntentService extends JobIntentService {
    public static final String TAG_PACKAGE_NAME="rahul.com.retrotest";

    static void enquework(Context context, Intent work){
        enqueueWork(context,MyJobIntentService.class,123,work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG_PACKAGE_NAME,"onCreate");
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.i(TAG_PACKAGE_NAME,"On handle Work");

        String input=intent.getStringExtra("input");

        for (int i=0;i<10;i++){
            Log.i(TAG_PACKAGE_NAME,input+":"+i);
            if (isStopped()) return;
            SystemClock.sleep(1000);
        }

    }

    @Override
    public boolean onStopCurrentWork() {
        Log.i(TAG_PACKAGE_NAME,"onStopCurrentWork");
        return super.onStopCurrentWork();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG_PACKAGE_NAME,"onDestroy");
    }
}
