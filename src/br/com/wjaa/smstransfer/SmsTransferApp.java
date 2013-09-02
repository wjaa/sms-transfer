package br.com.wjaa.smstransfer;

import br.com.wjaa.smstransfer.buffer.BufferBuilder;
import br.com.wjaa.smstransfer.module.FindClassInjectableModule;
import roboguice.RoboGuice;
import android.app.Application;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class SmsTransferApp extends Application {

	@Override
	public void onCreate() {
		super.onCreate();
		RoboGuice.setBaseApplicationInjector(this, RoboGuice.DEFAULT_STAGE, 
	            RoboGuice.newDefaultRoboModule(this), new FindClassInjectableModule(this));
		
		BufferBuilder bufferBuilder = RoboGuice.getBaseApplicationInjector(this).getInstance(BufferBuilder.class);
		bufferBuilder.load();
	}

	
	
}
