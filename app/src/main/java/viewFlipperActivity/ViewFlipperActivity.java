package viewFlipperActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.testone.R;

public class ViewFlipperActivity extends AppCompatActivity implements GestureDetector.OnGestureListener {
    /**
     * Called when the activity is first created.
     */
    private int[] imageID = {R.mipmap.a, R.mipmap.b, R.mipmap.c,
            R.mipmap.d, R.mipmap.e, R.mipmap.f, R.mipmap.g,
            R.mipmap.h};
    private ViewFlipper viewFlipper = null;
    private GestureDetector gestureDetector = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        viewFlipper = (ViewFlipper) findViewById(R.id.viewflipper);
        // 生成GestureDetector对象，用于检测手势事件
        gestureDetector = new GestureDetector( this);
        // 添加用于切换的图片
        for (int i = 0; i < imageID.length; i++) {
            // 定义一个ImageView对象
            ImageView image = new ImageView(this);
            image.setImageResource(imageID[i]);
            // 充满父控件
            image.setScaleType(ImageView.ScaleType.FIT_XY);
            // 添加到viewFlipper中
            viewFlipper.addView(image, new ActionBar.LayoutParams(
                    ActionBar.LayoutParams.FILL_PARENT, ActionBar.LayoutParams.FILL_PARENT));
        }
    }

    public boolean onDown(MotionEvent arg0) {
        return false;
    }

    public boolean onFling(MotionEvent arg0, MotionEvent arg1, float arg2, float arg3) {
        //对手指滑动的距离进行了计算，如果滑动距离大于120像素，就做切换动作，否则不做任何切换动作。
        // 从左向右滑动
        if (arg0.getX() - arg1.getX() > 120) {
            // 添加动画
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_left_out));
            this.viewFlipper.showNext();
            return true;
        }// 从右向左滑动
        else if (arg0.getX() - arg1.getX() < -120) {
            this.viewFlipper.setInAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_right_in));
            this.viewFlipper.setOutAnimation(AnimationUtils.loadAnimation(this,
                    R.anim.push_right_out));
            this.viewFlipper.showPrevious();
            return true;
        }
        return true;
    }

    public void onLongPress(MotionEvent e) {
    }

    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX,
                            float distanceY) {
        return false;
    }

    public void onShowPress(MotionEvent e) {
    }

    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return this.gestureDetector.onTouchEvent(event);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}