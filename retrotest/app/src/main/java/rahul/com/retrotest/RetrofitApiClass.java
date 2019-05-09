package rahul.com.retrotest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitApiClass {
    public static ApiInterface getApiInterface(){
        //for Gson
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setLenient();
        Gson gson= gsonBuilder.create();
        //for Http client
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS).build();
        //for asycnhronous calls
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
        //reftrofit object build
        Retrofit.Builder builder= new Retrofit.Builder()
                .baseUrl("http://41.79.78.69:81/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter);
        Retrofit retrofit= builder.build();

        ApiInterface apiInterface=retrofit.create(ApiInterface.class);
        return apiInterface;
    }
}
