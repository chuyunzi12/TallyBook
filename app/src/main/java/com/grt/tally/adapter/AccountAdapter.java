package com.grt.tally.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.grt.tally.R;
import com.grt.tally.db.AccountBean;

import java.util.Calendar;
import java.util.List;

public class AccountAdapter extends BaseAdapter {
    Context context;
    List<AccountBean>mDatas;
    LayoutInflater inflater;
    int year,month,day;
    public AccountAdapter(Context context, List<AccountBean> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        inflater = LayoutInflater.from(context);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH)+1;
        day = calendar.get(Calendar.DAY_OF_MONTH);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public Object getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.item_mainlv,parent,false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }
        AccountBean bean = mDatas.get(position);
        holder.typeIv.setImageResource(bean.getsImageId());
        if(bean.getKind() == 0){
            holder.typeIv.setColorFilter(context.getResources().getColor(R.color.theme_color));
        }else {
            holder.typeIv.setColorFilter(context.getResources().getColor(R.color.theme_blue));
        }
        holder.typeTv.setText(bean.getTypename());
        if(TextUtils.isEmpty(bean.getBeizhu())){
            holder.beizhuTv.setText("");
            holder.beizhuTv.setVisibility(View.GONE);
        }else {
            holder.beizhuTv.setText(bean.getBeizhu());
            holder.beizhuTv.setVisibility(View.VISIBLE);
        }

        holder.moneyTv.setText("￥ "+bean.getMoney());
        if (bean.getYear()==year&&bean.getMonth()==month&&bean.getDay()==day) {
            String time = bean.getTime().split(" ")[1];
            holder.timeTv.setText("今天 "+time);
        }else {
            holder.timeTv.setText(bean.getTime());
        }
        return convertView;
    }

    class ViewHolder{
        ImageView typeIv;
        TextView typeTv,beizhuTv,timeTv,moneyTv;
        public ViewHolder(View view){
            typeIv = view.findViewById(R.id.item_mainlv_iv);
            typeTv = view.findViewById(R.id.item_mainlv_tv_title);
            timeTv = view.findViewById(R.id.item_mainlv_tv_time);
            beizhuTv = view.findViewById(R.id.item_mainlv_tv_beizhu);
            moneyTv = view.findViewById(R.id.item_mainlv_tv_money);

        }
    }
}
