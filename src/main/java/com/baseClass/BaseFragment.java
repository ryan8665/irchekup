package com.baseClass;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;

public class BaseFragment extends Fragment {
    protected boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    protected boolean isUserLogin() {
        try {
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
            return preferences.getBoolean("login", false);
        } catch (Exception e) {
            return false;
        }
    }

    protected void setUSer(String firstname, String lastname, String id, String token, boolean isLog) {
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(getContext());
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("firstname", firstname);
        editor.putString("lastname", lastname);
        editor.putString("id", id);
        editor.putString("token", token);
        editor.putBoolean("login", isLog);


        editor.apply();
    }

    protected String getUserFullName() {
        final String[] ret = new String[1];
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    ret[0] = preferences.getString("firstname", null) + " " + preferences.getString("lastname", null);
                } catch (Exception e) {
                    ret[0] = "";
                }
            }
        };
        runnable.run();
        return ret[0];
    }

    protected String getToken() {
        final String[] ret = new String[1];
        Runnable runnable = new Runnable() {
            public void run() {
                try {
                    SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
                    ret[0] = preferences.getString("token", null);
                } catch (Exception e) {
                    ret[0] = "";
                }
            }
        };
        runnable.run();
        return ret[0];
    }

    protected Typeface persianFontNormal() {
        return Typeface.createFromAsset(getActivity().getAssets(), "fonts/vazir.ttf");
    }

    protected Typeface persianFontBold() {
        return Typeface.createFromAsset(getActivity().getAssets(), "fonts/vazirbold.ttf");
    }
}
