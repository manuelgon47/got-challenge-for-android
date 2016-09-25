package es.npatarino.android.gotchallenge;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import es.npatarino.android.gotchallenge.webservice.services.GotCharacterImageService;

public class DetailActivity extends AppCompatActivity {


    private static final String TAG = "DetailActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        final ImageView ivp = (ImageView) findViewById(R.id.iv_photo);
        final TextView tvn = (TextView) findViewById(R.id.tv_name);
        final TextView tvd = (TextView) findViewById(R.id.tv_description);

        final String d = getIntent().getStringExtra("description");
        final String n = getIntent().getStringExtra("name");
        final String i = getIntent().getStringExtra("imageUrl");

        Toolbar toolbar = (Toolbar) findViewById(R.id.t);
        toolbar.setTitle(n);
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        new GotCharacterImageService(this).getCharacterImage(i, new GotCharacterImageService.GotCharacterImageServiceListener() {
            @Override
            public void onImageRetrieved(final Bitmap bitmap) {
                DetailActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ivp.setImageBitmap(bitmap);
                        tvn.setText(n);
                        tvd.setText(d);
                    }
                });
            }

            @Override
            public void onError() {

            }
        });
    }
    
    // ******************************
    // *        Action Bar          *
    // ******************************
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            super.onBackPressed();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
