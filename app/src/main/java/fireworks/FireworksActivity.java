package fireworks;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.testone.R;

public class FireworksActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fireworks);
        TextView tv = findViewById(R.id.text);
        Typeface typeface = Typeface.createFromAsset(getAssets(), "ZCOOLKuaiLe-Regular.ttf");
        tv.setTypeface(typeface);
    }
}