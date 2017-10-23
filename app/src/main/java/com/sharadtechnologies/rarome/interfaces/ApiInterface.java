package com.sharadtechnologies.rarome.interfaces;



import com.sharadtechnologies.rarome.models.SignUpModel;
import com.sharadtechnologies.rarome.utilities.AppConstants;

import java.util.HashMap;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


public interface ApiInterface {

    @FormUrlEncoded
    @POST(AppConstants.SIGN_UP_URL)
    Call<SignUpModel> SignUp(@FieldMap HashMap<String, String> signUpParams);



    /*@Multipart
    @POST(AppConstants.CREATE_PROFILE_URL)
    Call<CreateProfileEmployeeModel> CreateProfile(@Part("user_id") RequestBody user_id,
                                                   @Part("profile_type") RequestBody profile_type,
                                                   @Part("first_name") RequestBody first_name,
                                                   @Part("last_name") RequestBody last_name,
                                                   @Part("company_name") RequestBody company_name,
                                                   @Part("contact_person") RequestBody contact_person,
                                                   @Part("phone_number") RequestBody phone_number,
                                                   @Part("address") RequestBody address,
                                                   @Part("dob") RequestBody dob,
                                                   @Part MultipartBody.Part file);*/


}
