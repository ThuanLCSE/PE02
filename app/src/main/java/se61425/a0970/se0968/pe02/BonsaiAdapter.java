package se61425.a0970.se0968.pe02;

import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import android.support.v7.widget.RecyclerView;
import java.util.List;

/**
 * Created by Thuans on 4/7/2017.
 */

public class BonsaiAdapter extends RecyclerView.Adapter<BonsaiAdapter.BonsaiHolder> {
    private static final String TAG = "BonsaiAdapter";
    private List<Bonsai> listBons = new ArrayList<Bonsai>();
    private ItemClickListener listener;
    View view;
    private int focusedItem = 0;

    public BonsaiAdapter(List<Bonsai> listBons, ItemClickListener listener) {
        this.listBons = listBons;
        this.listener = listener;
        focusedItem = -1;
    }

    @Override
    public BonsaiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bonsai_item, parent, false);
        BonsaiHolder holder = new BonsaiHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final BonsaiHolder holder, final int position) {

        holder.name.setText(listBons.get(position).getName());
        holder.img.setImageResource(listBons.get(position).getPicture());
        holder.item = listBons.get(position);
        if (position == focusedItem){
            holder.view.setBackgroundColor(Color.GREEN);
        } else {
            holder.view.setBackgroundColor(Color.WHITE);
        }
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            listener.onClick(listBons.get(position));
                focusedItem = position;
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBons.size();
    }

    public long getItemId(int position) {
        return position;
    }

    public interface ItemClickListener{
        public void onClick(Bonsai area);
    }
    public class BonsaiHolder extends RecyclerView.ViewHolder{
        public TextView name;
        public View view;
        public ImageView img;
        public Bonsai item;

        public BonsaiHolder(View rowView) {
            super(rowView);
            view = rowView;
            name = (TextView) rowView.findViewById(R.id.txt_name);
            img = (ImageView) rowView.findViewById(R.id.img_bonsai);
        }
    }
}

