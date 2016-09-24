package finalprojectmovieapp.mobile.com.finalprojectmovieapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.FrameLayout;

public class MainActivity extends ActionBarActivity implements MovieListener {
    public static boolean TABLET = false;
    MainFragment mainActivityFragment;
    public boolean mtwopane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TABLET = ConnectionHandler.isTablet(getApplicationContext());
        FrameLayout f2 = (FrameLayout) findViewById(R.id.Panal);
        if (null == f2) {
            mtwopane = false;
        } else {
            mtwopane = true;
        }
        mainActivityFragment = new MainFragment();
        if (savedInstanceState == null) {
            mainActivityFragment.SetMovieListener(this);

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.frag, mainActivityFragment)
                    .commit();
        }

    }

    @Override
    public void Moviesupdate(Movies movies) {
        if (TABLET) {
            DetailFragment detailFragment = new DetailFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.Panal, detailFragment).remove(detailFragment);
            Bundle extras = new Bundle();
            extras.putString("title", movies.title);
            extras.putString("id", movies.id);
            extras.putString("PosterPath", movies.posterPath);
            extras.putString("vote_average", movies.voteAverage);
            extras.putString("release_date", movies.releaseDate);
            extras.putString("overview", movies.overview);
            detailFragment.setArguments(extras);
            getSupportFragmentManager().beginTransaction().add(R.id.Panal, detailFragment).commit();

        } else {

            Intent intent = new Intent(this, DetailActivity.class).
                    putExtra("title", movies.title).
                    putExtra("id", movies.id).
                    putExtra("PosterPath", movies.posterPath).
                    putExtra("vote_average", movies.voteAverage).
                    putExtra("release_date", movies.releaseDate).
                    putExtra("overview", movies.overview);


            startActivity(intent);


        }
    }
}