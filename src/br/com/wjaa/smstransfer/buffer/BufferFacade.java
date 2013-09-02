package br.com.wjaa.smstransfer.buffer;

import br.com.wjaa.smstransfer.model.AppConfig;

/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class BufferFacade {

	/**
	 * 
	 * @param appConfig
	 */
	public static void updateAppConfig(AppConfig appConfig){
		AppBuffer.setAppConfig(appConfig);
	}
	
}
