package br.com.wjaa.smstransfer.service;

import com.google.gson.GsonBuilder;
import com.google.inject.Inject;

import br.com.wjaa.smstransfer.model.AppConfig;
import br.com.wjaa.smstransfer.model.ConfigEntity;


/**
 * 
 * @author root
 *
 */
public class ConfigServiceImpl implements ConfigService {

	@Inject
	private DataService dataService;
	private GsonBuilder g = new GsonBuilder();
	
	
	@Override
	public AppConfig getConfig() {
		ConfigEntity c = this.dataService.getById(ConfigEntity.class, ConfigEntity.ID_CONFIG);
		
		if (c == null){
			AppConfig ac = new AppConfig();
			ac.setActiveSystemOnStart(true);
			ac.setNotifyExecuteAction(true);
			ac.setNotifySmsAccept(true);
			this.saveConfig(ac);
		}
		
		return this.jsonToObject(c.getConfigJson());
	}

	private String objectToJson(AppConfig ac) {
		return g.create().toJson(ac);
	}

	private AppConfig jsonToObject(String json) {
		return g.create().fromJson(json, AppConfig.class);
	}

	@Override
	public void saveConfig(AppConfig appConfig) {
		ConfigEntity c = this.dataService.getById(ConfigEntity.class, ConfigEntity.ID_CONFIG);
		if (c == null){
			c = new ConfigEntity();
			c.setId(ConfigEntity.ID_CONFIG);
		}
		c.setConfigJson(this.objectToJson(appConfig));
		this.dataService.insertOrUpdate(c);
	}

}
