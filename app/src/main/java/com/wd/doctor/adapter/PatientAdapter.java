package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.PatientBean;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.adapter
 * @ClassName: PatientAdapter
 * @Author: YuYanHe
 * @CreateDate: 2020/2/21 15:37
 */
public class PatientAdapter extends RecyclerView.Adapter<PatientAdapter.Holder> {
    List<PatientBean.ResultBean> list = new ArrayList<>();
    Context context;

    public PatientAdapter(List<PatientBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.patient_adapter, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.commentTitle.setText(list.get(position).getTitle());
        holder.commentAmount.setText(list.get(position).getAmount() + "");
        holder.commentDetail.setText(list.get(position).getDetail());
        //时间转换
        Date date = new Date(list.get(position).getReleaseTime());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        holder.commentReleaseTime.setText(format.format(date));
        holder.linears.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapter.callBack(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public patientAdapter adapter;

    public void setPatientAdapter(patientAdapter patientAdapter) {
        this.adapter = patientAdapter;
    }

    public interface patientAdapter {
        void callBack(int position);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView commentTitle;
        TextView commentAmount;
        TextView commentDetail;
        TextView commentReleaseTime;
        LinearLayout linears;

        public Holder(@NonNull View itemView) {
            super(itemView);
            commentTitle = itemView.findViewById(R.id.comment_title);
            commentAmount = itemView.findViewById(R.id.comment_amount);
            commentDetail = itemView.findViewById(R.id.comment_detail);
            commentReleaseTime = itemView.findViewById(R.id.comment_releaseTime);
            linears = itemView.findViewById(R.id.linears);
        }
    }
}
