package com.tikhonov.paul.shakedeviceapplication.ui.statistics;

import com.arellomobile.mvp.InjectViewState;
import com.tikhonov.paul.shakedeviceapplication.App;
import com.tikhonov.paul.shakedeviceapplication.persistence.AppDatabase;
import com.tikhonov.paul.shakedeviceapplication.persistence.Energy;
import com.tikhonov.paul.shakedeviceapplication.persistence.EnergyDao;
import com.tikhonov.paul.shakedeviceapplication.ui.base.BasePresenter;

import java.util.List;

@InjectViewState
public class StatisticsPresenter extends BasePresenter<StatisticsView> {

    private AppDatabase db = App.getInstance().getDatabase();
    private EnergyDao energyDao = db.energyDao();

    List<Energy> getData(){
        return energyDao.getAll();
    }

}
