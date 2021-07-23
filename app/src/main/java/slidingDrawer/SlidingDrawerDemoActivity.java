package slidingDrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.example.testone.R;

public class SlidingDrawerDemoActivity extends AppCompatActivity {

    private ImageView arrawImageView;
    private SlidingDrawer slidingDrawer;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_drawer_demo);
        init();
    }

    private void init() {
        arrawImageView = (ImageView) findViewById(R.id.arrowImage);
        textView = (TextView) findViewById(R.id.textView);
        textView.setText("上拉或点击打开");
        slidingDrawer = (SlidingDrawer) findViewById(R.id.myslidingDrawer);
        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {

            @Override
            public void onDrawerOpened() {
                // TODO Auto-generated method stub
                arrawImageView.setImageResource(R.drawable.down);
                Animation animation = AnimationUtils.loadAnimation(SlidingDrawerDemoActivity.this, R.anim.arrowrote);
                arrawImageView.setAnimation(animation);
                textView.setText("下滑或点击关闭");
            }
        });
        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() { // �رճ���

            @Override
            public void onDrawerClosed() {
                // TODO Auto-generated method stub
                arrawImageView.setImageResource(R.drawable.up);
                Animation animation = AnimationUtils.loadAnimation(SlidingDrawerDemoActivity.this, R.anim.arrowrote);
                arrawImageView.setAnimation(animation);
                textView.setText("上拉或点击打开");
            }
        });
    }
}