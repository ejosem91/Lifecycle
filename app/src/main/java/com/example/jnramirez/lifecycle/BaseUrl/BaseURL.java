package com.example.jnramirez.lifecycle.BaseUrl;

import android.util.Log;

import com.example.jnramirez.lifecycle.Interface.CouponApi;
import com.example.jnramirez.lifecycle.Model.Coupon;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jnramirez on 06/04/2018.
 */

public class BaseURL{

    public static final String BASE_URL = "http://www.zoftino.com/api/";
    private static Retrofit retrofit = null;

    public static Retrofit getRetrofitClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public Coupon getTopCoupon() {
        final Coupon coupon = new Coupon();
        getRetrofitClient().create(CouponApi.class).getTopCoupon().enqueue(new Callback<Coupon>() {
            @Override
            public void onResponse(Call<Coupon> call, Response<Coupon> response) {
                Coupon cpn = response.body();

                coupon.setStore(cpn.getStore());
                coupon.setCoupon(cpn.getCoupon());
                coupon.setCouponCode(cpn.getCouponCode());
            }

            @Override
            public void onFailure(Call<Coupon> call, Throwable t) {
                Log.e("", "Error Getting TOP COUPON Data Retrofit");
            }
        });
        return coupon;
    }

}
