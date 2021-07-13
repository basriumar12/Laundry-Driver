package com.samyotech.laundrydriver.ui.activity.welcome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.samyotech.laundrydriver.R;
import com.samyotech.laundrydriver.databinding.ActivityWelcomeScreensBinding;
import com.samyotech.laundrydriver.interfaces.Consts;
import com.samyotech.laundrydriver.model.WelcomeDTO;
import com.samyotech.laundrydriver.preferences.SharedPrefrence;
import com.samyotech.laundrydriver.ui.activity.login.Login;
import com.samyotech.laundrydriver.ui.adapter.WelcomeImageAdapter;

import java.util.ArrayList;
import java.util.Timer;

public class WelcomeScreens extends AppCompatActivity {
    final long DELAY_MS = 500;
    final long PERIOD_MS = 3000;
    ActivityWelcomeScreensBinding binding;
    ArrayList<WelcomeDTO> imageDTOArrayList;
    int currentPage = 0;
    Timer timer;
    Context kContext;
    private WelcomeImageAdapter imageAdapter;
    private SharedPrefrence prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        kContext = WelcomeScreens.this;
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome_screens);

        prefs = SharedPrefrence.getInstance(WelcomeScreens.this);

        setUpViewpager();

//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == imageDTOArrayList.size()) {
//                    currentPage = 0;
//                }
//                binding.viewpager.setCurrentItem(currentPage++, true);
//
//
//            }
//        };
//
//        timer = new Timer(); // This will create a new Thread
//        timer.schedule(new TimerTask() { // task to be scheduled
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        }, DELAY_MS, PERIOD_MS);

    }

    private void setUpViewpager() {
        imageDTOArrayList = new ArrayList<>();
        imageDTOArrayList.add(new WelcomeDTO(R.drawable.wsatu, getResources().getString(R.string.Choose), getResources().getString(R.string.dummuydata)));
        imageDTOArrayList.add(new WelcomeDTO(R.drawable.wdua, getResources().getString(R.string.wash), getResources().getString(R.string.dummuydata2)));
        imageDTOArrayList.add(new WelcomeDTO(R.drawable.wtiga, getResources().getString(R.string.delivery), getResources().getString(R.string.dummuydata3)));

        imageAdapter = new WelcomeImageAdapter(imageDTOArrayList, kContext, new WelcomeImageAdapter.ClickListener() {
            @Override
            public void onClick() {
                prefs.setBooleanValue(Consts.IS_NOT_FIRST_TIME, true);
                startActivity(new Intent(getApplicationContext(), Login.class));
                finish();
            }
        });
        binding.viewpager.setAdapter(imageAdapter);
        binding.tabDots.setViewPager(binding.viewpager);
    }
}
