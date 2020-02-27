package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.InquireSickBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.adapter
 * @ClassName: SearchAdpter
 * @Author: YuYanHe
 * @CreateDate: 2020/2/26 13:55
 */
public class SearchAdpter extends RecyclerView.Adapter<SearchAdpter.Holder> {
    List<InquireSickBean.ResultBean> list = new ArrayList<>();
    Context context;


    public SearchAdpter(List<InquireSickBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.search_adapter, null);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.searchBinghzeng.setText(list.get(position).getTitle());
        holder.searchDetail.setText(list.get(position).getDetail());
        Date date = new Date(list.get(position).getReleaseTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        holder.searchTime.setText(format.format(date));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView searchBinghzeng, searchDetail;
        TextView searchTime;

        public Holder(@NonNull View itemView) {
            super(itemView);
            searchBinghzeng = itemView.findViewById(R.id.search_binghzeng);
            searchDetail = itemView.findViewById(R.id.search_detail);
            searchTime = itemView.findViewById(R.id.search_time);
        }
    }
}
