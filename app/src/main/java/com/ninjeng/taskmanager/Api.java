package com.ninjeng.taskmanager;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Api {
    @POST ("users/signup")
    Call<Void> addEmployee (@Body User user );
}
