package myMP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.testone.MainActivity;
import com.example.testone.R;

public class HomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Button choiceImg=(Button)findViewById(R.id.main_choicepicture_button);
        choiceImg.setOnClickListener(new choiceImgOnClick());
        Button choiceMusic=(Button)findViewById(R.id.main_choicemusicbutton);
        choiceMusic.setOnClickListener(new choiceMusicOnClick());
        Button play=(Button)findViewById(R.id.main_play_button);
        play.setOnClickListener(new playOnClick());
    }

    class choiceImgOnClick implements View.OnClickListener {
        public void onClick(View v) {
            Intent goHaveImgActivity=new Intent();
            goHaveImgActivity.setClass(HomeActivity.this,HavePictureActivity.class);
            startActivity(goHaveImgActivity);
        }
    }

    class choiceMusicOnClick implements View.OnClickListener {
        public void onClick(View v) {
            Intent intent=new Intent();
            intent.setClass(HomeActivity.this, HaveMuiscActivity.class);
            startActivity(intent);
        }
    }

    class playOnClick implements View.OnClickListener {
        public void onClick(View v) {
            Intent goPlayActivity=new Intent();
            goPlayActivity.setClass(HomeActivity.this,PlayActivity.class);
            startActivity(goPlayActivity);
        }
    }
}