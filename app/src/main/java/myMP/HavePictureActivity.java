package myMP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.testone.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HavePictureActivity extends AppCompatActivity {

    private LinearLayout haveimg=null;
    private int CHOICE_PICTURE=0;
    private int SCALE=2;
    private List<File> mypictureList=new ArrayList<File>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_have_picture);
        haveimg=(LinearLayout)findViewById(R.id.have_img_LinearLayout);
        Button choiceImgBut=(Button)findViewById(R.id.haveimg_choiceimg_button);
        mypictureList=PictureUtil.getFile(PictureUtil.sd_path+"/xue111jiao/img");
        for(int i=0;i<mypictureList.size();i++){
            File file=mypictureList.get(i);
            if (file.exists()) {
                Bitmap bm = BitmapFactory.decodeFile(file.getAbsolutePath());
                addImgToLinelayerout(bm);
            }
        }
        choiceImgBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImgData();
            }
        });

    }
    private void openImgData(){
        Intent openImg = new Intent(Intent.ACTION_GET_CONTENT);
        openImg.setType("image/*");
        startActivityForResult(openImg, CHOICE_PICTURE);
    }
    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){

            switch (requestCode) {
                case 0:
                    ContentResolver resolver = getContentResolver();
                    Uri originalUri = data.getData();

                    String[] proj = { MediaStore.Images.Media.DATA };

                    Cursor actualimagecursor = managedQuery(originalUri,proj,null,null,null);

                    int actual_image_column_index = actualimagecursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);

                    actualimagecursor.moveToFirst();

                    String img_path = actualimagecursor.getString(actual_image_column_index);
                    String imgname=img_path.substring(img_path.lastIndexOf('/')+1);
                    try {
                        Bitmap photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
                        if (photo != null) {
                            Bitmap smallBitmap = PictureUtil.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
                            photo.recycle();
                            addImgToLinelayerout(smallBitmap);
                            PictureUtil.saveMyBitmap(getApplicationContext(),imgname,smallBitmap);
                        }

                    } catch (FileNotFoundException e) {

                        e.printStackTrace();

                    } catch (IOException e) {

                        e.printStackTrace();

                    }

                    break;

                default:
                    break;
            }
        }

    }

    public void addImgToLinelayerout(Bitmap bitmap){
        ImageView imgview=new ImageView(this.getApplicationContext());
        imgview.setImageBitmap(bitmap);
        haveimg.addView(imgview);
    }
}