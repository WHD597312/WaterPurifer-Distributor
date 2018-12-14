package ph.com.waterpurifer_distributor.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.List;
import ph.com.waterpurifer_distributor.R;

public class xqRepairAdapter extends RecyclerView.Adapter<xqRepairAdapter.MyViewHolder> {

    private List<String> mData;
    private Context context;

    public xqRepairAdapter(Context context , List<String> list ) {

        this.context = context;
        this.mData = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_xqrepair,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_xqre_type1,tv_xqre_jdzt1,tv_xqre_yytime1,tv_xqre_phone1;
        Button bt_xqre_td;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_xqre_type1= (TextView)itemView.findViewById(R.id.tv_xqre_type1);
            tv_xqre_jdzt1= (TextView)itemView.findViewById(R.id.tv_xqre_jdzt1);
            tv_xqre_yytime1= (TextView)itemView.findViewById(R.id.tv_xqre_yytime1);
            tv_xqre_phone1= (TextView)itemView.findViewById(R.id.tv_xqre_phone1);
            bt_xqre_td=(Button) itemView.findViewById(R.id.bt_xqre_td);

        }
    }


}
