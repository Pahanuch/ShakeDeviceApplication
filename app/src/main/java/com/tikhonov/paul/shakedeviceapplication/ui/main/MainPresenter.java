package com.tikhonov.paul.shakedeviceapplication.ui.main;

import com.arellomobile.mvp.InjectViewState;
import com.tikhonov.paul.shakedeviceapplication.App;
import com.tikhonov.paul.shakedeviceapplication.persistence.AppDatabase;
import com.tikhonov.paul.shakedeviceapplication.persistence.Energy;
import com.tikhonov.paul.shakedeviceapplication.persistence.EnergyDao;
import com.tikhonov.paul.shakedeviceapplication.ui.base.BasePresenter;

@InjectViewState
public class MainPresenter extends BasePresenter<MainView> {

    private Long delay = 0L;

    private AppDatabase db = App.getInstance().getDatabase();
    private EnergyDao energyDao = db.energyDao();

    // TODO
    void startTimer(long shakeTimestamp) {

        if (delay == 0L)
            delay = System.currentTimeMillis();

        if (shakeTimestamp - 2000L > delay && shakeTimestamp - 3000L < delay) {
            getViewState().showMessage("Please spend some energy");
        } else if (shakeTimestamp - 3000L > delay && shakeTimestamp - 10000L < delay) {
            getViewState().showMessage("You are spending energy");
        } else if (shakeTimestamp - 10000L > delay) {
            getViewState().showMessage("Energy spent");
            saveToDb(true);
            delay = 0L;
        }
    }

    private void saveToDb(boolean energySpended){
        Energy energy = new Energy();
        energy.spending = energySpended;
        energy.time = 1L;

        energyDao.insert(energy);
    }

}
