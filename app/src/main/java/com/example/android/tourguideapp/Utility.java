package com.example.android.tourguideapp;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Cansu on 11.04.2018.
 */

//This class is used to arrange column number according to different device screens or different orientations.
// For this block of code, credit goes to: https://stackoverflow.com/questions/33575731/gridlayoutmanager-how-to-auto-fit-columns/38472370
public class Utility {

    public static int calculateNoOfColumns(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        int noOfColumns = (int) (dpWidth / 180);
        return noOfColumns;
    }
}
