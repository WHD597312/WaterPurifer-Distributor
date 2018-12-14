package ph.com.waterpurifer_distributor.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.List;
import ph.com.waterpurifer_distributor.R;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MyViewHolder> {

    private List<String> mData;
    private Context context;
    private OnItemClickListener onItemClickListener;
    public MainAdapter(Context context , List<String> list ) {
        this.context = context;
        this.mData = list;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.item_main,parent,false));
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {


              holder.itemView.setOnClickListener(new View.OnClickListener() {
                  @Override
                  public void onClick(View v) {
                      onItemClickListener.onItemClick(v, position);
                  }
              });
              holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                  @Override
                  public boolean onLongClick(View v) {

                      onItemClickListener.onLongClick(v, position);
                      return false;
                  }
              });

    }
    public void SetOnItemClick(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener ;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onLongClick(View view, int posotion);
    }


    @Override
    public int getItemCount() {
        return mData.size();
    }



    class MyViewHolder extends RecyclerView.ViewHolder {
//        ImageView iv_seqp_pic;
//        TextView tv_seqp_name;
//        RelativeLayout rl_sequitem;
        public MyViewHolder(View itemView) {
            super(itemView);
//            iv_seqp_pic = (ImageView) itemView.findViewById(R.id.iv_seqp_pic);
//            tv_seqp_name= (TextView)itemView.findViewById(R.id.tv_seqp_name);
//            rl_sequitem=(RelativeLayout) itemView.findViewById(R.id.rl_sequitem);
        }
    }


}
