package myMP;

import android.annotation.SuppressLint;
import android.content.Context;
import android.widget.Toast;

import java.text.SimpleDateFormat;

public class MyUtil {

	@SuppressLint("ShowToast")
	public static void Alert(Context context,String text){
		Toast toast=Toast.makeText(context, text, Toast.LENGTH_LONG);
		toast.show();
	}

	@SuppressLint("SimpleDateFormat")
	public static String getNowData(){
		SimpleDateFormat   sDateFormat   =   new   SimpleDateFormat("yyyy-MM-dd-hh-mm-ss");     
		String   date   =   sDateFormat.format(new   java.util.Date());  
		return date;
	}
}
