package tomerbu.edu.quizprep;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import tomerbu.edu.quizprep.gmail.models.GmailModel;

/**
 * Created by TomerBu on 21/01/2018.
 */

public class GmailAdapter extends RecyclerView.Adapter<GmailAdapter.GmailVH> {
    //properties:
    private Context context;
    private ArrayList<GmailModel> data;

    public GmailAdapter(Context context, ArrayList<GmailModel> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public GmailVH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.gmail_item, parent, false);
        return new GmailVH(v);
    }

    @Override
    public void onBindViewHolder(GmailVH h, int position) {
        GmailModel gmail = data.get(position);
        h.tvMessage.setText(gmail.getMessage());
        Picasso.with(context).load(gmail.getPictureUrl()).into(h.ivSender);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    //findViewsAndHold the views as fields
    public class GmailVH extends RecyclerView.ViewHolder {
        TextView tvMessage;
        ImageView ivSender;

        public GmailVH(View v) {
            super(v);
            tvMessage = v.findViewById(R.id.tvMessage);
            ivSender = v.findViewById(R.id.ivSender);
        }
    }
}
