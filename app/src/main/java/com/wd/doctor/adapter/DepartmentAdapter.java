package com.wd.doctor.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.wd.doctor.R;
import com.wd.doctor.bean.DepartmentBean;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.adapter
 * @ClassName: DepartmentAdapter
 * @Author: YuYanHe
 * @CreateDate: 2020/2/25 13:46
 */
public class DepartmentAdapter extends RecyclerView.Adapter<DepartmentAdapter.Holder> {
    List<DepartmentBean.ResultBean> list = new ArrayList<>();
    Context context;

    public DepartmentAdapter(List<DepartmentBean.ResultBean> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.department_adapter, null);
        return new Holder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.department_text.setText(list.get(position).getDepartmentName());
        holder.linearees.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                departmentAdapters.callBack(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    departmentAdapter departmentAdapters;

    public void setDepartmentAdapter(departmentAdapter departmentAdapter) {
        this.departmentAdapters = departmentAdapter;
    }

    public interface departmentAdapter {
        void callBack(int i);
    }

    public class Holder extends RecyclerView.ViewHolder {
        TextView department_text;
        LinearLayout linearees;

        public Holder(@NonNull View itemView) {
            super(itemView);
            department_text = itemView.findViewById(R.id.department_text);
            linearees = itemView.findViewById(R.id.linearees);
        }
    }
}
