package ph.com.waterpurifer_distributor.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.annotation.NonNull;
import android.support.v7.view.menu.MenuAdapter;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.scwang.smartrefresh.header.MaterialHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import butterknife.BindView;
import butterknife.OnClick;
import ph.com.waterpurifer_distributor.R;
import ph.com.waterpurifer_distributor.activity.ManageActivity;
import ph.com.waterpurifer_distributor.activity.PassWordActivity;
import ph.com.waterpurifer_distributor.activity.SearchActivity;
import ph.com.waterpurifer_distributor.activity.UserdetailsActivity;
import ph.com.waterpurifer_distributor.adapter.MainAdapter;
import ph.com.waterpurifer_distributor.adapter.MemuAdapter;
import ph.com.waterpurifer_distributor.base.BaseFragment;
import ph.com.waterpurifer_distributor.view.SpaceItemDecoration;

import static android.content.Context.MODE_PRIVATE;

public class MainFragment extends BaseFragment {
    @BindView(R.id.rv_main)
    RecyclerView rv_main;
    @BindView(R.id.rv_main_top)
    RecyclerView rv_main_top;
    SharedPreferences preferences;
    String pass;
    String [] title = {"全部","最近添加","剩余天数","在线设备","离线设备","激活设备","未激活设备","租赁设备","非租赁设备"};
    @Override
    public int bindLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void initView(View view) {
        preferences = getActivity().getSharedPreferences("my", MODE_PRIVATE);
        pass = preferences.getString("pass","");
        List<String> list = new ArrayList<>();
        for (int i = 0;i<14;i++){
            list.add("item"+i);
        }
        List<String> list1 = new ArrayList<>(Arrays.asList(title));
        MainAdapter mainAdapter = new MainAdapter(getActivity(),list);
        rv_main.setLayoutManager(new LinearLayoutManager(getActivity()));
        rv_main.addItemDecoration(new SpaceItemDecoration(0,32));
        rv_main.setAdapter(mainAdapter);
        mainAdapter.SetOnItemClick(new MainAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                if (pass.length()>0){
                    Intent intent = new Intent(getActivity(), PassWordActivity.class);
                    intent.putExtra("type",1);
                    startActivity(intent);
                }else {
                    startActivity(new Intent(getActivity(),UserdetailsActivity.class));
                }

            }

            @Override
            public void onLongClick(View view, int posotion) {

            }
        });
        final MemuAdapter menuAdapter = new MemuAdapter(getActivity(),list1);
        LinearLayoutManager  layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv_main_top.setLayoutManager(layoutManager);
        rv_main_top.setAdapter(menuAdapter);
        menuAdapter.SetOnItemClick(new MemuAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                int myposition = position;
                //传到适配器  （适配器调用方法）
                menuAdapter.getIndex(myposition);
                //刷新适配器
                menuAdapter.notifyDataSetChanged();

            }

            @Override
            public void onLongClick(View view, int posotion) {

            }
        });

        final RefreshLayout refreshLayout =view. findViewById(R.id.refreshLayout);

            refreshLayout.setOnRefreshListener(new OnRefreshListener() {
                @Override
                public void onRefresh(@NonNull RefreshLayout refreshLayout) {

                    refreshLayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

                }
            });




    }

    @Override
    public void doBusiness(Context mContext) {

    }

    @Override
    public void widgetClick(View v) {

    }
    @OnClick({R.id.et_main_search
    })
    public void onClick(View view){
        switch (view.getId()){
            case R.id.et_main_search:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;

        }
    }
}
