package myMP;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Environment;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class PictureUtil {

	public static String sd_path=Environment.getExternalStorageDirectory().getPath();
    public static Bitmap zoomBitmap(Bitmap bitmap, int width, int height) {

        int w = bitmap.getWidth();

        int h = bitmap.getHeight();

        Matrix matrix = new Matrix();

        float scaleWidth = ((float) width / w);

        float scaleHeight = ((float) height / h);

        matrix.postScale(scaleWidth, scaleHeight);

        Bitmap newbmp = Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);

        return newbmp;

    }

    public static void saveMyBitmap(Context context,String bitName,Bitmap mBitmap){
    		
    	if (Environment.getExternalStorageState().equals(

    			Environment.MEDIA_MOUNTED)){
    		 
    		File file_folder=new File(sd_path+"/xue111jiao");
    		if(!file_folder.exists()){
   	    	 file_folder.mkdir();
   	     	}
    		File file_img=new File(sd_path+"/xue111jiao/img");
    		if(!file_img.exists()){
    			file_img.mkdir();
   	     	}
    		StringBuffer headFilePath=new StringBuffer();
    		headFilePath.append(sd_path)
    		.append("/xue111jiao/img/")
    		.append(bitName)
    		.append(".png");
    		File headFile = new File(headFilePath.toString());
    		if(mBitmap==null){
    			MyUtil.Alert(context, "ͼƬΪ��");
    			return ;
    		}
    		if(headFile.exists()){
    			return;
//    			headFile.delete();
    		}
    		OutputStream outputStream=null;
    		try {
    			headFile.createNewFile();
    			outputStream = new FileOutputStream(headFile);
    			byte[] buffer = new byte[1024];
    			int temp = 0;
    			InputStream is=Bitmap2InputStream(mBitmap);
    			while ((temp = is.read(buffer)) != -1) {
    				outputStream.write(buffer, 0, temp);
    			}
    			outputStream.flush();
    		} catch (Exception e) {
    			e.printStackTrace();
    		} finally {
    			try {
    				if(outputStream!=null){
    				outputStream.close();
    				}
    			} catch (IOException e) {
    				e.printStackTrace();
    			}
    		}
	    		
	    }else{
	    	MyUtil.Alert(context, "û��SD����APP����˳��Ӧ�ã�����");
	    }
    	
    	 
    }

    public static InputStream Bitmap2InputStream(Bitmap bm) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();  
        bm.compress(Bitmap.CompressFormat.JPEG, 100, baos);  
        InputStream is = new ByteArrayInputStream(baos.toByteArray());  
        return is;  
    }

    public static List<File> getFile(String path){
    	File file = new File(path);
    	List<File> mFileList=new ArrayList<File>();
    	File[] fileArray =file.listFiles();
		for (File f : fileArray) {
			if(f.isFile()){
				mFileList.add(f);
			}else{
				getFile(path);
			}
		}
		return mFileList;
	}
}
