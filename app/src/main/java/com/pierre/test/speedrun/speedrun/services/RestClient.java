package com.pierre.test.speedrun.speedrun.services;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RestClient {

    // Speedruns base url
    private final static String BASE_URL = "https://www.speedrun.com/api/v1/";

    private static OkHttpClient mClient;
    private static Retrofit mRetrofit;

    /**
     * Get a SpeedrunApi using client and retrofit
     *
     * return SpeedRunApi
     */
    public static SpeedRunApi getSpeedRunApi() {
        // Initialize Retrofit and client
        getRetrofit(getClient());

        SpeedRunApi api = mRetrofit.create(SpeedRunApi.class);
        return api;
    }

    /**
     * Get a OkHttpClient
     *
     * return OkHttpClient
     */
    private static OkHttpClient getClient() {
        if (mClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            mClient = builder.build();
        }
        return mClient;
    }

    /**
     * Get a Retrofit object
     *
     * return Retrofit
     */
    private static Retrofit getRetrofit(OkHttpClient client) {
        if (mRetrofit == null) {
            Retrofit.Builder builder = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(client);
            mRetrofit = builder.build();
        }

        return mRetrofit;
    }


}
