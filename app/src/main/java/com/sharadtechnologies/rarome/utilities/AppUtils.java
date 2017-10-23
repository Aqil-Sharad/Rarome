package com.sharadtechnologies.rarome.utilities;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by sirendra on 23-10-2017.
 */

public class AppUtils
{
    ProgressDialog progressDialog;
    private static AppUtils instance;
    private AppUtils()
    {
        instance = new AppUtils();
    }

    public static AppUtils getInstance()
    {
        if(instance==null)
        {
            return new AppUtils();
        }
        return  instance;
    }

    public void showProgress(Context context)
    {
        if(progressDialog == null)
        {
            progressDialog = new ProgressDialog(context);
        }
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    public void dismissProgress()
    {
        if(progressDialog.isShowing())
        {
            progressDialog.dismiss();
        }
    }

    public boolean isNetworkConnected(Context context)
    {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
}
