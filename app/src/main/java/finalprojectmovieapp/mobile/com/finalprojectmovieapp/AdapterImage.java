package finalprojectmovieapp.mobile.com.finalprojectmovieapp;

/**
 * Created by user on 8/29/2016.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.squareup.picasso.Picasso;
import java.util.ArrayList;

public class AdapterImage extends BaseAdapter {

    private Context mContext;
    public static ArrayList<String> array;
    private int width;
    public static String BASE_URL_IMAGE_THUMB = "http://image.tmdb.org/t/p/w185/";
    private  static ArrayList<Movies> MovieItems;

    // path is image path and Width is width
    public AdapterImage(Context c, ArrayList<Movies> MoviePosterPath, int Width)
    {
        mContext = c;
        this.MovieItems = MoviePosterPath;
        width = Width;
    }

    public void add(Movies s){
        MovieItems.add(s);
    }
    @Override
    public int getCount() {
        return MovieItems.size();
    }

    @Override
    public String getItem(int position) {
        return MovieItems.get(position).getPosterPath();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView ( int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null)
        {
            imageView = new ImageView(mContext);
            Drawable d =resizeDrawable(mContext.getResources().getDrawable(R.drawable.background));

        }
        else{
            imageView = (ImageView) convertView;
        }
// placeholder appear instead of movie poster
        Drawable d =resizeDrawable(mContext.getResources().getDrawable(R.drawable.background));
        Picasso.with(mContext).load(BASE_URL_IMAGE_THUMB + MovieItems.get(position).getPosterPath()).resize(width, (int)(width*1.5)).placeholder(d).into(imageView);
        return imageView;

    }
    //resize IMAGES
    private Drawable resizeDrawable(Drawable image)
    {
        Bitmap b = ((BitmapDrawable)image).getBitmap();
        Bitmap bitmapResized = Bitmap.createScaledBitmap(b,width, (int)(width*1.5),false);
        return new BitmapDrawable(mContext.getResources(),bitmapResized);
    }
}