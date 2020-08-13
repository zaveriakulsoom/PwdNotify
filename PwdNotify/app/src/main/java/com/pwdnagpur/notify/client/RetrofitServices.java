package com.pwdnagpur.notify.client;



import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by URTECH on 18-09-2018.
 */

public interface RetrofitServices {


   // @GET("questions")
  //  Call<List<QuestionModel>> getQuestions(@Query("user_id") String user_id);

    @POST("solution")
    Call<String> postToken(@Query("token") String token);

    //@GET("username")
    //Call<TeamModel> getCredential(@Query("team_id") String user_id, @Query("password") String password);





}
