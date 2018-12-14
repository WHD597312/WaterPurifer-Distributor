package ph.com.waterpurifer_distributor.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import java.util.ArrayList;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.adapter.SearchAdapter;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.view.SpaceItemDecoration;

public class SearchActivity extends BaseActivity {
    @BindView(R.id.rv_search_data)
    RecyclerView rv_search_data;
    @Override
    public void initParms(Bundle parms) {

    }

    @Override
    public int bindLayout() {
        setSteepStatusBar(true);
        return R.layout.activity_search;
    }

    @Override
    public void initView(View view) {
        List<String> list = new ArrayList<>();
        for (int i=0;i<3;i++){
            list.add(i+"");
        }
        SearchAdapter searchAdapter = new SearchAdapter(this,list);
        rv_search_data.setLayoutManager(new LinearLayoutManager(this));
        rv_search_data.addItemDecoration(new SpaceItemDecoration(0,35));
        rv_search_data.setAdapter(searchAdapter);

    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }
    @OnClick({R.id.iv_serch_fh})
    public void onClick(View view){
        switch (view.getId()){
            case R.id.iv_serch_fh:
                finish();
                break;
        }
    }
}
