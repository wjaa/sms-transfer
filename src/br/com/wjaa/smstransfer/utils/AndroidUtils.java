package br.com.wjaa.smstransfer.utils;

import android.app.Activity;
import android.content.Intent;


/**
 * 
 * @author Wagner jeronimo
 *
 */
public class AndroidUtils {
	
	public static Intent openActivity(Activity context, Class<?> activity ){
		Intent i = new Intent(context, activity);
		context.startActivityForResult(i, 1);
		return i;
	}
	

}
