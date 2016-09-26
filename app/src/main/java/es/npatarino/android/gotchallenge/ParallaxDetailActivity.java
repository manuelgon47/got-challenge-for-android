package es.npatarino.android.gotchallenge;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

/**
 * Created by Manuel González Villegas on 25/9/16.
 */
public class ParallaxDetailActivity extends DetailActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
        handleScrollEvents(scrollView);
    }

    @TargetApi(Build.VERSION_CODES.M)
    private void handleScrollEvents(final ScrollView scrollView) {
        scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                onScroll(scrollView, scrollY);
            }
        });
    }

    private void onScroll(ScrollView scrollView, int scrollY) {
        View firstChild = findViewById(R.id.iv_photo);
        firstChild.setY(scrollY * 0.5f);
    }
}
