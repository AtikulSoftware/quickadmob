package com.bdtopcoder.quickadmob;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    Button showInterstitial, showReword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AdsUnit.BANNER = "ca-app-pub-3940256099942544/6300978111";
        AdsUnit.INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
        AdsUnit.REWARDED = "ca-app-pub-3940256099942544/5224354917";

        // SDK Initialize
        Admob.loadInterstitialAds(MainActivity.this);
        Admob.loadRewordedAds(MainActivity.this);

        showInterstitial = findViewById(R.id.showInterstitial);
        showReword = findViewById(R.id.showReword);

        // Show Banner
        Admob.setBanner(findViewById(R.id.showBanner),MainActivity.this);

        // Show Interstitial Ads
        showInterstitial.setOnClickListener(view -> {
            new Admob(new onDismiss() {
                @Override
                public void onDismiss() {
                    // When Ads Close Take Action

                }
            }).ShowInterstitial(MainActivity.this,true);
        });

        // Show Reworded Ads
        showReword.setOnClickListener(view -> {
            new Admob(new onDismiss() {
                @Override
                public void onDismiss() {
                    // when ads watch give some reworded
                }
            }).ShowRewarded(MainActivity.this,true);

        });

    } // OnCreate Method End Here ============


} // Public Class End Here ===================