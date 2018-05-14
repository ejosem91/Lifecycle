package com.example.jnramirez.lifecycle.Utils;

import android.arch.lifecycle.ViewModel;

import com.example.jnramirez.lifecycle.BaseUrl.BaseURL;
import com.example.jnramirez.lifecycle.Model.Coupon;

/**
 * Created by jnramirez on 06/04/2018.
 */

public class CouponViewModel extends ViewModel{
    private Coupon coupon;
    private BaseURL baseURL = new BaseURL();

    public Coupon getCoupon(){
        if(coupon == null){
            coupon = baseURL.getTopCoupon();
        }
        return coupon;
    }



}
