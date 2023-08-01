<br/>
<p align="center">
  <a href="https://github.com/AtikulSoftware/quickadmob">
    <img src="https://avatars.githubusercontent.com/u/111883800?v=4" alt="Logo" width="80" height="80">
  </a>

  <h3 align="center">Quick Admob</h3>

  <p align="center">
    Easy And Best Practice with Admob Ad Implementation
    <br/>
    <br/>
    <a href="https://youtu.be/i9f_-exXbpw"><strong>Explore the video docs »</strong></a>
    <br/>
    <br/>
    <a href="https://github.com/AtikulSoftware/quickadmob">View Demo</a>
    .
    <a href="https://github.com/AtikulSoftware/quickadmob/issues">Report Bug</a>
    .
    <a href="https://github.com/AtikulSoftware/quickadmob/issues">Request Feature</a>
  </p>
</p>

![Downloads](https://img.shields.io/github/downloads/AtikulSoftware/quickadmob/total) ![Contributors](https://img.shields.io/github/contributors/AtikulSoftware/quickadmob?color=dark-green) ![Issues](https://img.shields.io/github/issues/AtikulSoftware/quickadmob) ![License](https://img.shields.io/github/license/AtikulSoftware/quickadmob) 



## Table Of Contents

* [About the Project](#about-the-project)
* [Getting Started](#getting-started)
* [Authors](#authors)

## About The Project

![Screen Shot](https://avatars.githubusercontent.com/u/111883800?v=4)

Best practice with admob ad implementation 

## Getting Started

> Step 1. Add the JitPack repository to your build file 
```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
```

> Step 2. Add the dependency
```
	dependencies {
	        implementation 'com.github.AtikulSoftware:quickadmob:1.0.0'
	}
```

Make Sure Add Internet Permissiton & Metadata in Manifests
```
 <!-- Internet Permission-->
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    
     <!-- Meta Data -->
        <meta-data
            android:name="com.google.android.gms.ads.APPLICATION_ID"
            android:value="ca-app-pub-3940256099942544~3347511713" />
    
```

> Setp 3. Load Banner Ads
```
  <!-- Admob Banner Ads-->
    <LinearLayout
        android:id="@+id/showBanner"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:orientation="vertical" />
```
Banner Ads Java Code
```
// Set Banner Ad Unit ID
 AdsUnit.BANNER = "ca-app-pub-3940256099942544/6300978111";

 // Set Banner Ads
        Admob.setBanner(findViewById(R.id.showBanner),MainActivity.this);
```

> Step 4. Interstitial Ads
```
// Set Interstitial Ads Unit ID
 AdsUnit.INTERSTITIAL = "ca-app-pub-3940256099942544/1033173712";
 
 // Load Interstitial Ads
 Admob.loadInterstitialAds(this);
 
 
 // Button Click Show Interstitial Ads
 // Show Ads
 new Admob(new onDismiss() {
                @Override
                public void onDismiss() {
                    // When Ads Close Take Action
                    // 1. Go to New Activity what you want Actually
                }
            }).ShowInterstitial(MainActivity.this,true);
 
 ```
 
 > Step 5. Reworded Ads
```
// Set Reworded Ads Unit ID
AdsUnit.REWARDED = "ca-app-pub-3940256099942544/5224354917";

 // Load Reworded Ads
 Admob.loadRewordedAds(this);

// Button Click Show Reworded Ads
 // Show Ads
  new Admob(new onDismiss() {
                @Override
                public void onDismiss() {
                    // When Ads Close Take Action
                    // 1. Give Some Reword

                }
            }).ShowRewarded(MainActivity.this,true);
```
## Authors

* **Atikul Islam** - *Android Software Developer* - [Atikul Islam](https://github.com/AtikulSoftware) - *Free Library*
