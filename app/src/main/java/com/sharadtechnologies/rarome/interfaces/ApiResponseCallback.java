package com.sharadtechnologies.rarome.interfaces;

import org.json.JSONObject;

public interface ApiResponseCallback
{
    void getResponse(Object response, String type);
    void getErrorMessage(Object errorMessage);
    void showNetworkToast(String message);
}
