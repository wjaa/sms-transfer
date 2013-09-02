package br.com.wjaa.smstransfer.buffer;

import br.com.wjaa.smstransfer.model.AppConfig;

/**
 * 
 * @author root
 *
 */
public final class AppBuffer {
	
	private static AppConfig appConfig;
	
	
	public static AppConfig getAppConfig(){
		return AppBuffer.appConfig;
	}
	
	protected static void setAppConfig(AppConfig appConfig){
		AppBuffer.appConfig = appConfig;
	}

}
