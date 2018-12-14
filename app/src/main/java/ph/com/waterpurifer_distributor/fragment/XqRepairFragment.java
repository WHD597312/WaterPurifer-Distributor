package ph.com.waterpurifer_distributor.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.adapter.xqRepairAdapter;
import ph.com.waterpurifer_distributor.base.BaseActivity;
import ph.com.waterpurifer_distributor.base.BaseFragment;
import ph.com.waterpurifer_distributor.view.SpaceItemDecoration;

public class XqRepairFragment extends BaseFragment {
    @BindView(R.id.rv_xqrepair)
    RecyclerView rv_xqrepair;

    @Override
    public int bindLayout() {
        return R.layout.activity_xqrepair;
    }

    @Override
    public void initView(View view) {

        List<String> list = new ArrayList<>();
        for (int i=0;i<8;i++){
            list.add("item"+i);
        }
        xqRepairAdapter xqRepairAdapter = new xqRepairAdapter(getActivity(),list);
        rv_xqrepair.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_xqrepair.addItemDecoration(new SpaceItemDecoration(0,35));
        rv_xqrepair.setAdapter(xqRepairAdapter);
    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }

    @OnClick({})
    public void onClick(View view){
        switch (view.getId()){

        }
    }




}

