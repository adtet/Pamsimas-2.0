package com.example.pamsimas10;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface JSONPlaceHolder {
    @GET("{id}")
    Call<List<PostPelanggan>>getPostPelanggan(@Path("id")String getPath);
    @POST("postcater")
    Call<PostPelanggan>createupload(@Body PostPelanggan postPelanggan);
}
