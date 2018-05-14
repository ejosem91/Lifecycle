package com.example.jnramirez.lifecycle.Interface;

import com.example.jnramirez.lifecycle.Model.Coupon;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by jnramirez on 06/04/2018.
 */

public interface CouponApi {
    @GET("topCoupon/")
    Call<Coupon> getTopCoupon();
}
