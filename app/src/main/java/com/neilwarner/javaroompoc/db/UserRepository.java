package com.neilwarner.javaroompoc.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.util.Log;

import com.neilwarner.javaroompoc.model.User;
import com.neilwarner.javaroompoc.network.ServiceGenerator;
import com.neilwarner.javaroompoc.network.WebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//TODO: Make this a singleton... service locator pattern possibly..
public class UserRepository {
    private static final String TAG = UserRepository.class.getSimpleName();
    private WebService webService = ServiceGenerator.createService(WebService.class);
    // ...
    public LiveData<User> getUser(String userId) {
        // This isn't an optimal implementation. We'll fix it later.
        final MutableLiveData<User> data = new MutableLiveData<>();
        webService.getUser(userId).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                Log.e(TAG, "onFailure() called with: call = [" + call + "], t = [" + t + "]");
            }

            // Error case is left out for brevity.
        });
        return data;
    }
}
