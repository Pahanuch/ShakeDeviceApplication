package com.tikhonov.paul.shakedeviceapplication.ui.statistics;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.tikhonov.paul.shakedeviceapplication.R;
import com.tikhonov.paul.shakedeviceapplication.persistence.Energy;
import com.tikhonov.paul.shakedeviceapplication.ui.adapters.StatisticsAdapter;
import com.tikhonov.paul.shakedeviceapplication.ui.base.BaseActivity;

import java.util.List;

public class StatisticsActivity extends BaseActivity implements StatisticsView {

    private RecyclerView recyclerView;

    @InjectPresenter
    StatisticsPresenter presenter;

    private StatisticsAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statistics);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(llm);

        List<Energy> energyList = presenter.getData();
        adapter = new StatisticsAdapter(energyList);
        recyclerView.setAdapter(adapter);

    }
}
