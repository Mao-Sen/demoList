package wechatActivityAnimation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

import com.example.testone.MainActivity;
import com.example.testone.R;

public class wechatAnimationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wechat_animation);
        Application app=getApplication();
        int sdk=android.os.Build.VERSION.SDK_INT;
        Toast.makeText(this, sdk+"", Toast.LENGTH_LONG).show();
        if (sdk>14) {
            // app.setTheme(android.R.style.Theme_Black_NoTitleBar);
        }
        //ButtonClick.clickto(this,Two.class);
        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(wechatAnimationActivity.this,Two.class));
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}