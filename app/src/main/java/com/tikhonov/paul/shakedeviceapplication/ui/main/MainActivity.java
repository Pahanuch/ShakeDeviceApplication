package com.tikhonov.paul.shakedeviceapplication.ui.main;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tikhonov.paul.shakedeviceapplication.R;
import com.tikhonov.paul.shakedeviceapplication.ui.statistics.StatisticsActivity;

public class MainActivity extends MainBarActivity implements MainView {

    // The following are used for the shake detection
    private SensorManager mSensorManager;
    private Sensor mAccelerometer;
    private ShakeDetector mShakeDetector;

    private TextView tvMessageInfo;

    @InjectPresenter
    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMessageInfo = findViewById(R.id.message_info);

        // ShakeDetector initialization
        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager != null ? mSensorManager
                .getDefaultSensor(Sensor.TYPE_ACCELEROMETER) : null;
        mShakeDetector = new ShakeDetector();
        /*
         * The following method, "handleShakeEvent(count):" is a stub //
         * method you would use to setup whatever you want done once the
         * device has been shook.
         */
        mShakeDetector.setOnShakeListener(this::handleShakeEvent);
    }

    @Override
    public void onResume() {
        super.onResume();
        // Add the following line to register the Session Manager Listener onResume
        mSensorManager.registerListener(mShakeDetector, mAccelerometer,	SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    public void onPause() {
        // Add the following line to unregister the Sensor Manager onPause
        mSensorManager.unregisterListener(mShakeDetector);
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.stats:
                Intent intent = new Intent(this, StatisticsActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void handleShakeEvent(long shakeTimestamp) {
        presenter.startTimer(shakeTimestamp);
    }

    @Override
    public void showMessage(String message) {
        tvMessageInfo.setText(message);
    }
}
