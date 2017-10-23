package com.sharadtechnologies.rarome.controller;


import android.app.Activity;
import android.content.Context;
import android.util.Log;


import com.google.gson.Gson;
import com.sharadtechnologies.rarome.interfaces.ApiResponseCallback;
import com.sharadtechnologies.rarome.utilities.AppUtils;

import org.json.JSONObject;

import java.util.Arrays;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiConnection<T>
{
    ApiResponseCallback apiResponseCallback;
    private String linkedInToken = "";

    public ApiConnection(ApiResponseCallback apiResponseCallback)
    {
        this.apiResponseCallback = apiResponseCallback;
    }

    /**
     * Method to make Network Calls
     *
     * @param call    request
     * @param context Current Class Context
     * @param apiName Service Name
     */
    public void makeServiceConnection(Call<T> call, Context context, final String apiName)
    {
        if (AppUtils.getInstance().isNetworkConnected(context))
        {
            AppUtils.getInstance().showProgress(context);
            call.enqueue(new Callback<T>()
            {
                @Override
                public void onResponse(Call<T> call, Response<T> response)
                {
                    Object responseObject = response.body();
                    Log.w("responseObject ",new Gson().toJson(responseObject));
                    apiResponseCallback.getResponse(responseObject, apiName);
                    AppUtils.getInstance().dismissProgress();
                }

                @Override
                public void onFailure(Call<T> call, Throwable t)
                {
                    apiResponseCallback.getErrorMessage(t.getMessage());
                    AppUtils.getInstance().dismissProgress();
                }
            });
        }
        else
        {
            apiResponseCallback.showNetworkToast("Internet not working");
        }
    }


}
