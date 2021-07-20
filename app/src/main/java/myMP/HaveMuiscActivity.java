package myMP;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.testone.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HaveMuiscActivity extends AppCompatActivity {

    private Handler handler;
    private Thread searchMp3Thread;
    private ProgressDialog progressDialog;
    private LinearLayout musicLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_muisc);
        Button choiceMusic = (Button) findViewById(R.id.havemusic_choicemusic_button);
        choiceMusic.setOnClickListener(new choiceMusicOnClick());
        musicLayout = (LinearLayout) findViewById(R.id.have_muisc_LinearLayout);

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                switch (msg.what) {
                    case 0:
                        progressDialog.dismiss();
                        List<Map> mylist = (List<Map>) msg.obj;
                        for (int i = 0; i < mylist.size(); i++) {
                            Map map = mylist.get(i);
                            String url = map.get("src").toString();
                            String name = map.get("name").toString();
                            Button but = new Button(getApplicationContext());
                            but.setText("���ţ�" + name);
                            but.setOnClickListener(new playMusic(url));
                            musicLayout.addView(but);
                        }
                        break;

                    default:
                        break;
                }

            }
        };
    }

    class playMusic implements View.OnClickListener {
        private String filepath = "";

        public void onClick(View v) {
            if (!filepath.equals("")) {
                Intent i = new Intent(Intent.ACTION_VIEW);
                Uri uri = Uri.parse("file://" + filepath);
                i.setDataAndType(uri, "audio/*");
                startActivity(i);
            }
        }

        public playMusic(String filepath) {
            this.filepath = filepath;
        }
    }

    class choiceMusicOnClick implements View.OnClickListener {
        public void onClick(View v) {
            progressDialog = ProgressDialog.show(HaveMuiscActivity.this, "���Ե�...", "������...", true);
            if (searchMp3Thread != null) {
                searchMp3Thread.interrupt();
                searchMp3Thread = null;
            }
            searchMp3Thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    ScannerMusic();
                }
            };
            searchMp3Thread.start();
        }
    }

    public void ScannerMusic() {
        List<Map> resultlist = new ArrayList<Map>();
        Cursor cursor = HaveMuiscActivity.this.getContentResolver().query(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, null, null, null,
                MediaStore.Audio.Media.DEFAULT_SORT_ORDER);
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media._ID));
                int trackId = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM_ID));
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE));
                String album = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ALBUM));
                String artist = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST));
                String url = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DATA));
                int duration = cursor.getInt(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION));
                Long size = cursor.getLong(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.SIZE));
                String disName = cursor.getString(cursor.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME));
                Log.e("music disName=", disName);//��ӡ����������
                Map map = new HashMap();
                map.put("src", url);
                map.put("name", disName);
                resultlist.add(map);
                cursor.moveToNext();
            }
            cursor.close();
        }
        Message msg = new Message();
        msg.what = 0;
        msg.obj = resultlist;
        handler.sendMessage(msg);
    }

}