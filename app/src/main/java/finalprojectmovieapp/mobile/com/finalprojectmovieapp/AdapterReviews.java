package finalprojectmovieapp.mobile.com.finalprojectmovieapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 9/3/2016.
 */
public class AdapterReviews extends BaseAdapter {

    private Context mContext;
    private static ArrayList<Reviews> reviewItems;


    /* Constructor*/
    public AdapterReviews(Context c, ArrayList<Reviews> reviewcontent) {

        mContext = c;
        this.reviewItems = reviewcontent;


    }

    public void add(Reviews reviews) {
        reviewItems.add(reviews);
    }

    @Override
    public int getCount() {
        return reviewItems.size();
    }

    @Override
    public Object getItem(int position) {
        return reviewItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public static class ViewHolder {
        public TextView authortext;
        public TextView contenttext;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;

        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.review_items, parent, false);
            holder = new ViewHolder();

            holder.authortext = (TextView) view.findViewById(R.id.author);
            holder.contenttext = (TextView) view.findViewById(R.id.content);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.contenttext.setText("Review  " + (position + 1));
        holder.authortext.setText(reviewItems.get(position).getAuthor());


        return view;
    }


}