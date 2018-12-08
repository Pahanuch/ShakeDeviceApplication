package com.tikhonov.paul.shakedeviceapplication.ui.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tikhonov.paul.shakedeviceapplication.R;
import com.tikhonov.paul.shakedeviceapplication.persistence.Energy;

import java.util.List;

public class StatisticsAdapter extends RecyclerView.Adapter<StatisticsAdapter.StatisticViewHolder>{

    private List<Energy> energyList;

    public StatisticsAdapter(List<Energy> energyList){
        this.energyList = energyList;
    }

    @NonNull
    @Override
    public StatisticViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_statistic, viewGroup, false);
        return new StatisticViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull StatisticViewHolder statiscticViewHolder, int i) {
        if (energyList.get(i).spending) {
            statiscticViewHolder.tvSpendedEnergy.setText("Spended energy");
        } else statiscticViewHolder.tvSpendedEnergy.setText("NOT spended energy");
    }

    @Override
    public int getItemCount() {
        return energyList.size();
    }

    static class StatisticViewHolder extends RecyclerView.ViewHolder {

        TextView tvSpendedEnergy;

        StatisticViewHolder(View itemView) {
            super(itemView);
            tvSpendedEnergy = (TextView)itemView.findViewById(R.id.tv_spended_energy);
        }
    }
}
