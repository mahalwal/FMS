package me.manishmahalwal.android.fms2;



import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    public list_item[] data;

    public MyAdapter(list_item[] data) {
        this.data = data;
    }

    @Override
    public ViewHolder onCreateViewHolder( ViewGroup viewGroup, int i) {
        View v=LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        list_item title =data[i];

            viewHolder.id.setText(title.id);


            viewHolder.worker.setText(title.worker);


            viewHolder.type.setText(title.Type);


            viewHolder.pos.setText(title.Position);






    }

    @Override
    public int getItemCount() {
        return data.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView id;
        public TextView worker;
        public TextView type;
        public TextView pos;
        public ViewHolder(View itemView) {
            super(itemView);
            id=(TextView)itemView.findViewById(R.id.cid);
            worker=(TextView)itemView.findViewById(R.id.cworker);
            type=(TextView)itemView.findViewById(R.id.ctype);
            pos=(TextView)itemView.findViewById(R.id.cpos);


        }
    }

}