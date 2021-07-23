package wechatActivityAnimation;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

import com.example.testone.R;

/**
 * @package��com.example.activityanimationdemo
 * @author��Allen
 * @email��jaylong1302@163.com
 * @data��2012-8-30 ����9:59:56
 * @description��The class is for...
 */
public class ButtonClick {
	
	     public static void clickto(final Activity context,final Class des){
	    		context.findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
	    			@Override
	    			public void onClick(View v) {
	    		            context.startActivity(new Intent(context,des));
	    			}
	    		});
	     }
	
           public static void click(final Activity context){
        	   context.findViewById(R.id.btn_exit).setOnClickListener(new View.OnClickListener() {
       			@Override
       			public void onClick(View v) {
       				// TODO Auto-generated method stub
       				context.finish();
       			}
       		});
           }  
}
