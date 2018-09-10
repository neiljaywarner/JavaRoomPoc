package com.neilwarner.javaroompoc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.neilwarner.javaroompoc.ui.UserProfileFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // some cleanup here as needed.
        getSupportFragmentManager().beginTransaction().replace(R.id.content, new UserProfileFragment()).commit();
    }
    // see https://developer.android.com/jetpack/docs/guide
    // and missing sample etc.
    // and https://codelabs.developers.google.com/codelabs/android-persistence/#7
}
