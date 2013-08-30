package br.com.wjaa.smstransfer.model;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.wjaa.smstransfer.database.PersistenceBean;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class ConfigEntity extends PersistenceBean{

	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7443650836071061174L;
	
	
	private Integer id;
	private String configJson;
	
	public static final Integer ID_CONFIG = 1;
	
	public ConfigEntity() {
		super( "config", new String[] { "id", "config_json"} );
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	


	
	public ContentValues getContentValues() {
		ContentValues val = new ContentValues();
		val.put( "id", this.getId() );
		val.put( "config_json", this.getConfigJson());
		return val;
	}

	public void setBean(Cursor cr) {
		this.setId( cr.getInt( 0 ) );
		this.setConfigJson( cr.getString( 1 ) );
	}


	public String getConfigJson() {
		return configJson;
	}

	public void setConfigJson(String configJson) {
		this.configJson = configJson;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConfigEntity other = (ConfigEntity) obj;
		if (configJson == null) {
			if (other.configJson != null)
				return false;
		} else if (!configJson.equals(other.configJson))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
