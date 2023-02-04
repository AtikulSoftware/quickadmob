package com.bdtopcoder.quickadmob;

import android.app.Activity;
import android.content.Context;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/*
 * Created By Atikul Software
 * Website : https://bdtopcoder.xyz
 * */

public class Admob {

    static onDismiss onDismiss;

    public Admob(com.bdtopcoder.quickadmob.onDismiss onDismiss) {
        this.onDismiss = onDismiss;
    }

    public Admob() {
    }

    public static void setBanner(LinearLayout banner, Context context) {

        if (AdsUnit.isAds) {
            MobileAds.initialize(context, initializationStatus -> {
            });
            AdView adView = new AdView(context);
            banner.addView(adView);
            adView.setAdUnitId(AdsUnit.BANNER);
            adView.setAdSize(AdSize.BANNER);
            AdRequest adRequest = new AdRequest.Builder().build();
            adView.loadAd(adRequest);
        }

    } // setBanner Close Here ========

    public static void loadInterstitialAds(Context context) {
        if (AdsUnit.isAds) {
            MobileAds.initialize(context, initializationStatus -> {
            });

            AdRequest adRequest = new AdRequest.Builder().build();
            InterstitialAd.load(context, AdsUnit.INTERSTITIAL, adRequest,
                    new InterstitialAdLoadCallback() {
                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {

                            AdsUnit.mInterstitialAd = interstitialAd;
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            AdsUnit.mInterstitialAd = null;
                        }
                    });
        }

    } // loadInterstitialAds Close here ======

    public void ShowInterstitial(Activity activity, boolean isReload) {

        if (AdsUnit.mInterstitialAd != null) {
            AdsUnit.mInterstitialAd.show(activity);

            AdsUnit.mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();

                    if (isReload) {
                        AdsUnit.mInterstitialAd = null;
                        Admob.loadInterstitialAds(activity);
                    }

                    onDismiss.onDismiss();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    onDismiss.onDismiss();
                }
            });

        } else {
            onDismiss.onDismiss();
        }

    } // ShowInterstitial Close Here ==============

    public static void loadRewordedAds(Context context) {
        if (AdsUnit.isAds) {
            MobileAds.initialize(context, initializationStatus -> {
            });

            AdRequest adRequest = new AdRequest.Builder().build();
            RewardedAd.load(context, AdsUnit.REWARDED,
                    adRequest, new RewardedAdLoadCallback() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error.

                            AdsUnit.mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            AdsUnit.mRewardedAd = rewardedAd;

                        }
                    });
        }

    } // loadRewordedAds Close Here =================

    public void ShowRewarded(Activity activity, boolean isReload) {

        if (AdsUnit.mRewardedAd != null) {
            AdsUnit.mRewardedAd.show(activity, rewardItem -> {
                Toast.makeText(activity, "Reward Collected", Toast.LENGTH_SHORT).show();
            });

            AdsUnit.mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdDismissedFullScreenContent() {
                    super.onAdDismissedFullScreenContent();

                    if (isReload) {
                        AdsUnit.mRewardedAd = null;
                        Admob.loadRewordedAds(activity);
                    }

                    onDismiss.onDismiss();
                }

                @Override
                public void onAdFailedToShowFullScreenContent(@NonNull AdError adError) {
                    super.onAdFailedToShowFullScreenContent(adError);
                    //onDismiss.onDismiss();
                    Toast.makeText(activity, "Please try again later...", Toast.LENGTH_SHORT).show();
                }
            });

        } else {
            //onDismiss.onDismiss();
            Toast.makeText(activity, "Please Wait Ads is loading...", Toast.LENGTH_SHORT).show();
        }


    } // ShowRewarded Close Here ==============


} // Admob Class Close Here ==================
