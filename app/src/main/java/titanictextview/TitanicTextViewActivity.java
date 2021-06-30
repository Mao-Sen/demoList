package titanictextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testone.R;

/**
 *上下波浪textview
 */
public class TitanicTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_titanic_text_view);
        TitanicTextView tv = (TitanicTextView) findViewById(R.id.my_text_view);
        // set fancy typeface
        tv.setTypeface(Typefaces.get(this, "Satisfy-Regular.ttf"));

        // start animation
        new Titanic().start(tv);
    }
}