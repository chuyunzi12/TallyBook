package com.grt.tally.frag_record;
import com.grt.tally.R;
import com.grt.tally.db.DBManager;
import com.grt.tally.db.TypeBean;
import java.util.List;
/**
 * 收入记录页面
 */
public class IncomeFragment extends BaseRecordFragment {


    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
        List<TypeBean> inlist = DBManager.getTypeList(1);
        typeList.addAll(inlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("工资");
        typeIv.setImageResource(R.mipmap.sort_lijin);
        typeIv.setColorFilter(getResources().getColor(R.color.theme_blue));
        setType(1);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(1);
        DBManager.insertItemToAccounttb(accountBean);
    }
}
