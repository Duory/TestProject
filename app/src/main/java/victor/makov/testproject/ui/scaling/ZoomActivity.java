package victor.makov.testproject.ui.scaling;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.io.IOException;

import victor.makov.testproject.R;

public class ZoomActivity extends AppCompatActivity {

    private CustomImageView mImageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom);

        Intent intent = getIntent();
        Uri pickedImage = intent.getParcelableExtra("Image");
        try {
            Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), pickedImage);
            Drawable drawable = new BitmapDrawable(getResources(), bitmap);
            mImageView = new CustomImageView(this, drawable);
            ViewGroup view = findViewById(R.id.zoom_layout);
            view.addView(mImageView);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
