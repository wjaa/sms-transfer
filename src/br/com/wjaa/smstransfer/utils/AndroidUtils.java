package br.com.wjaa.smstransfer.utils;

import br.com.wjaa.smstransfer.activity.listener.ButtonDialogClickListener;
import br.com.wjaa.smstransfer.callback.DialogCallback;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
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
	
	
	public static void showMessageDlg(String title, String msg, Context context){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		alertDialog.setButton(AlertDialog.BUTTON1, "OK", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				dialog.cancel();
			}
		});
		alertDialog.show();
	}
	
	public static void showConfirmDlg(String title, String msg, Context context, DialogCallback callback ){
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		alertDialog.setTitle(title);
		alertDialog.setMessage(msg);
		OnClickListener listener = new ButtonDialogClickListener(callback);
		alertDialog.setButton(AlertDialog.BUTTON1, "Sim",listener);
		alertDialog.setButton(AlertDialog.BUTTON2, "Não", listener);
		alertDialog.show();
	}
	

}
