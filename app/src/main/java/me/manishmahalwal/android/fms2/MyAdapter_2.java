package me.manishmahalwal.android.fms2;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter_2 extends RecyclerView.Adapter<MyAdapter_2.ViewHolder> {
    public list_item_2[] data;


    public MyAdapter_2(list_item_2[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_2,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        list_item_2 title =data[i];

            viewHolder.id.setText(title.id);


            viewHolder.worker.setText(title.worker);


            viewHolder.type.setText(title.Type);


            viewHolder.status.setText(title.Status);






    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView id;
        public TextView worker;
        public TextView type;
        public TextView status;
        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.cid2);
            worker=(TextView)itemView.findViewById(R.id.cworker2);
            type=(TextView)itemView.findViewById(R.id.ctype2);
            status=(TextView)itemView.findViewById(R.id.cstatus);


        }
    }

}