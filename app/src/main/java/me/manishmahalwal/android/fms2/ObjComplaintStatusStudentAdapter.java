package me.manishmahalwal.android.fms2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ObjComplaintStatusStudentAdapter extends RecyclerView.Adapter<ObjComplaintStatusStudentAdapter.ProductViewHolder> {


    //this context we will use to inflate the layout
    private Context mCtx;

    //we are storing all the products in a list
    private List<ObjComplaintStatusStudent> productList;

    //getting the context and product list with constructor
    public ObjComplaintStatusStudentAdapter(Context mCtx, List<ObjComplaintStatusStudent> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //inflating and returning our view holder
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.objcomplaintstatusstudent, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ProductViewHolder holder, int position) {
        //getting the product of the specified position
        ObjComplaintStatusStudent product = productList.get(position);

        //binding the data with the viewholder views
        holder.textViewTitle.setText(product.getNum());
        holder.textViewShortDesc.setText(product.getType());
        Log.e("AJ", (product.getPriority()==-1)+" "+ product.getPriority());
        if(product.getPriority()==-1) {

            holder.textViewRating.setText("Resolved");
        } else
            holder.textViewRating.setText(String.valueOf(product.getPriority()));
//        holder.textViewRating.setText(String.valueOf(product.getPriority()));
        holder.textViewPrice.setText(product.getLocation());

//        holder.imageView.setImageDrawable(mCtx.getResources().getDrawable(product.getImage()));

    }
    @Override
    public int getItemCount() {
        return productList.size();
    }


    class ProductViewHolder extends RecyclerView.ViewHolder {

        TextView textViewTitle, textViewShortDesc, textViewRating, textViewPrice;
//        ImageView imageView;

        public ProductViewHolder(View itemView) {
            super(itemView);

            textViewTitle = itemView.findViewById(R.id.textViewTitle);
            textViewShortDesc = itemView.findViewById(R.id.textViewShortDesc);
            textViewRating = itemView.findViewById(R.id.textViewRating);
            textViewPrice = itemView.findViewById(R.id.textViewPrice);
        }
    }
}
