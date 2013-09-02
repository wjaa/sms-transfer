package br.com.wjaa.smstransfer.buffer;

import br.com.wjaa.smstransfer.model.AppConfig;
import br.com.wjaa.smstransfer.service.ConfigService;

import com.google.inject.Inject;

/**
 * 
 * @author root
 *
 */
public class BufferBuilderImpl implements BufferBuilder{

	@Inject
	private ConfigService configService;
	
	public void load(){
		AppConfig appConfig = configService.getConfig();
		AppBuffer.setAppConfig(appConfig);
	}
	
	
}
