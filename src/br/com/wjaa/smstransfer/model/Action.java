package br.com.wjaa.smstransfer.model;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.wjaa.smstransfer.database.PersistenceBean;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class Action extends PersistenceBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1835808368715210686L;
	private Integer id;
	private String email;
	private Boolean enabledEmail;
	
	
	public Action() {
		super( "action", new String[] { "id", "email", "enabled_email"} );
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getEnabledEmail() {
		return enabledEmail;
	}

	public void setEnabledEmail(Boolean enabledEmail) {
		this.enabledEmail = enabledEmail;
	}

	
	public ContentValues getContentValues() {
		ContentValues val = new ContentValues();
		val.put( "id", this.getId() );
		val.put( "email", this.getEmail());
		val.put( "enabled_email", this.getEnabledEmail() ? 1 : 0 );
		return val;
	}

	public void setBean(Cursor cr) {
		this.setId( cr.getInt( 0 ) );
		this.setEmail( cr.getString( 1 ) );
		this.setEnabledEmail(cr.getInt( 2 ) == 0 ? false : true );
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Action other = (Action) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (enabledEmail == null) {
			if (other.enabledEmail != null)
				return false;
		} else if (!enabledEmail.equals(other.enabledEmail))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
