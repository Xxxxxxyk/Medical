package com.dream.medical.services;


import android.text.TextUtils;

import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.SPUtils;
import com.dream.medical.BuildConfig;
import com.dream.medical.utils.Contacts;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class RetrofitSingleton {

    private static RetrofitSingleton instance = null;

    private RetrofitSingleton() {
    }

    public static RetrofitSingleton getInstance() {
        if (instance == null) {
            synchronized (RetrofitSingleton.class) {
                if (instance == null) {
                    instance = new RetrofitSingleton();
                }
            }
        }
        return instance;
    }

    //创建Retrofit实例
    public Retrofit create() {

        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        //设置超时时间
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.writeTimeout(10, TimeUnit.SECONDS);

        //设置错误重连
        builder.retryOnConnectionFailure(true);

        builder.addInterceptor(new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request originalRequest = chain.request();
                if (TextUtils.isEmpty(SPUtils.getInstance(Contacts.SP_NAME).getString(Contacts.TOKEN))) {
                    return chain.proceed(originalRequest);
                } else {
                    Request authorised = originalRequest.newBuilder()
                            .header("token", SPUtils.getInstance(Contacts.SP_NAME).getString(Contacts.TOKEN))
                            .build();
                    return chain.proceed(authorised);
                }
            }
        });

        //Debug模式下Log打印输出
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            //设置打印等级,共有4个等级NONE、BASIC、HEADER、BODY
            //NONE  不打印
            //BASIC 请求/响应行
            //HEADER 请求/响应行 + 头
            //请求/响应行 + 头 + 体
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }

        return new Retrofit.Builder()
                .baseUrl(Contacts.BASE_URL)
                .client(builder.build())
                .addConverterFactory(ScalarsConverterFactory.create())
                //添加Gson转换器
                .addConverterFactory(GsonConverterFactory.create())
                //与Rxjava2配合
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
