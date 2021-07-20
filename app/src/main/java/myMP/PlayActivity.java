package myMP;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.testone.R;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PlayActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {

    private List<File> mypictureList=new ArrayList<File>();
    private GestureDetector detector;
    private ViewFlipper flipper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        detector = new GestureDetector(this);
        flipper = (ViewFlipper) this.findViewById(R.id.play_viewFlipper);

        mypictureList=PictureUtil.getFile(PictureUtil.sd_path+"/xue111jiao/img");
        for(int i=0;i<mypictureList.size();i++){
            File file=mypictureList.get(i);
            if (file.exists()) {
                ImageView imgview= new ImageView(getApplicationContext());
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
                imgview.setImageBitmap(bm);
                flipper.addView(imgview);
            }
        }
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.detector.onTouchEvent(event);
    }
    @Override
    public boolean onDown(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
                           float velocityY) {
        if (e1.getX() - e2.getX() > 120) {
            this.flipper.showNext();
            return true;
        } else if (e1.getX() - e2.getX() < -120) {
            this.flipper.showPrevious();
            return true;
        }

        return false;
    }
    @Override
    public void onLongPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onScroll(MotionEvent arg0, MotionEvent arg1, float arg2,
                            float arg3) {
        // TODO Auto-generated method stub
        return false;
    }
    @Override
    public void onShowPress(MotionEvent arg0) {
        // TODO Auto-generated method stub

    }
    @Override
    public boolean onSingleTapUp(MotionEvent arg0) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}