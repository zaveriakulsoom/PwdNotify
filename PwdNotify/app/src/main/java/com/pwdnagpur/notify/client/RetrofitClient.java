package com.pwdnagpur.notify.client;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by URTECH on 18-09-2018.
 */

public class RetrofitClient {


    static Retrofit retrofit;
   static String BASEURL = "http://synergy2018.us-east-1.elasticbeanstalk.com/webapi/18/";
   // static String BASEURL = "http://10.0.2.2:8080/coding/webapi/18/";

    //static String BASEURL = "http://192.168.42.108:8080/coding/webapi/18/";
    public static Retrofit getRetrofitClient()
    {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(100, TimeUnit.SECONDS)
                .readTimeout(100,TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        if(retrofit==null)
        {
            retrofit = new  Retrofit.Builder().baseUrl(BASEURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(client)
                    .build();

        }
        return retrofit;

    }
}
