package br.com.wjaa.smstransfer.service;

import br.com.wjaa.smstransfer.model.AppConfig;

/**
 * 
 * @author root
 *
 */
public interface ConfigService {

	
	/**
	 * Pega as configuracoes da aplicacao.
	 * @return
	 */
	AppConfig getConfig();
	
	
	/**
	 * Salva a config no banco.
	 * @param appConfig
	 */
	void saveConfig(AppConfig appConfig);
	
}
