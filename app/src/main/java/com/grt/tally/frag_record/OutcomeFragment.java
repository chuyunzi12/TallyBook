package com.grt.tally.frag_record;
import androidx.fragment.app.Fragment;
import com.grt.tally.R;
import com.grt.tally.db.DBManager;
import com.grt.tally.db.TypeBean;
import java.util.List;
/**
 * A simple {@link Fragment} subclass.
 */
public class OutcomeFragment extends BaseRecordFragment {


    // 重写
    @Override
    public void loadDataToGV() {
        super.loadDataToGV();
        //获取数据库当中的数据源
        List<TypeBean> outlist = DBManager.getTypeList(0);
        typeList.addAll(outlist);
        adapter.notifyDataSetChanged();
        typeTv.setText("还款");
        typeIv.setImageResource(R.mipmap.sort_huankuan);
        typeIv.setColorFilter(getResources().getColor(R.color.theme_color));
        setType(0);
    }

    @Override
    public void saveAccountToDB() {
        accountBean.setKind(0);
        DBManager.insertItemToAccounttb(accountBean);
    }
}
