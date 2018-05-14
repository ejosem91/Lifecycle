package com.example.jnramirez.lifecycle.Activity;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.jnramirez.lifecycle.Model.Coupon;
import com.example.jnramirez.lifecycle.R;
import com.example.jnramirez.lifecycle.Utils.CouponViewModel;

public class MainActivity extends AppCompatActivity {

    private CouponViewModel couponViewModel;
    private TextView tvTextCoupon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTextCoupon=(TextView)findViewById(R.id.models);
        couponViewModel = ViewModelProviders.of(this).get(CouponViewModel.class);
        couponViewModel.getCoupon();
    }

    public void getTopCoupon( View v){
        String coupon = couponViewModel.getCoupon().getStore() + " "+ couponViewModel.getCoupon().getCouponCode() +" " + couponViewModel.getCoupon().getCoupon();
        tvTextCoupon.setText(coupon);
    }
}
