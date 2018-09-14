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
        if (mClient == null) {
            mClient = createClient();
        }
        if (mRetrofit == null) {
            mRetrofit = createRetrofit(mClient);
        }
        SpeedRunApi api = mRetrofit.create(SpeedRunApi.class);

        return api;
    }

    /**
     * Get a OkHttpClient
     *
     * return OkHttpClient
     */
    private static OkHttpClient createClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        OkHttpClient client = builder.build();

        return client;
    }

    /**
     * Get a Retrofit object
     *
     * return Retrofit
     */
    private static Retrofit createRetrofit(OkHttpClient client) {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client);

        return builder.build();
    }


}
