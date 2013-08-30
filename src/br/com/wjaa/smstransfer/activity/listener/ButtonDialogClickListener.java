package br.com.wjaa.smstransfer.activity.listener;

import br.com.wjaa.smstransfer.callback.DialogCallback;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/**
 * 
 * @author root
 *
 */
public class ButtonDialogClickListener implements OnClickListener {

	private DialogCallback callback;
	
	public ButtonDialogClickListener(DialogCallback callback){
		this.callback = callback; 
	}
	
	@Override
	public void onClick(DialogInterface dialog, int which) {
		switch (which) {
		case DialogInterface.BUTTON1: 
			dialog.cancel();
			callback.confirm();
			break;
		case DialogInterface.BUTTON2: 
			dialog.cancel();
			callback.cancel();
			break;	
			
		default:
			break;
		}
		
	}

}
