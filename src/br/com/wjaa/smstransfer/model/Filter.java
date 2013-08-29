package br.com.wjaa.smstransfer.model;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.wjaa.smstransfer.database.PersistenceBean;

/**
 * 
 * @author root
 *
 */
public class Filter extends PersistenceBean{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9137307555546386475L;
	

	public Filter(String tabela, String[] colunas) {
		super( "filter", new String[] { "id", "regex", "regex_type", "contact_number", "enabled_filter_contact", "enabled_filter_regex", "id_rule"} );
	}
	
	public enum RegexType{
		EQUALS(1, "Igual"),
		CONTAINS(2, "Contém"),
		PATTERN(3,"Tenha o padrão"),
		NOT_CONTAINS(4, "Não contém"),
		NOT_EQUALS(5, "Não igual"),
		NOT_PATTERN(6, "Não tenha o padrão");
		
		
		private RegexType(Integer id, String label){
			this.id = id;
		}
		
		private Integer id;
		private String label;

		
		public static RegexType getRegexTypeById(Integer id){
			for (RegexType r : RegexType.values()) {
				if ( r.id.equals(id) ){
					return r;
				}
			}
			return null;
		}

		public Integer getId() {
			return id;
		}
		public String getLabel() {
			return label;
		}
	}
	
	
	
	private Integer id;
	private Integer idRule;
	private String regex;
	private RegexType regexType;
	private String contactNumber;
	private Boolean enabledFilterRegex;
	private Boolean enabledFilterContact;
	
	
	
	public Integer getIdRule() {
		return idRule;
	}

	public void setIdRule(Integer idRule) {
		this.idRule = idRule;
	}



	public String getRegex() {
		return regex;
	}



	public void setRegex(String regex) {
		this.regex = regex;
	}



	public RegexType getRegexType() {
		return regexType;
	}



	public void setRegexType(RegexType regexType) {
		this.regexType = regexType;
	}



	public String getContactNumber() {
		return contactNumber;
	}



	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}



	public Boolean getEnabledFilterRegex() {
		return enabledFilterRegex;
	}



	public void setEnabledFilterRegex(Boolean enabledFilterRegex) {
		this.enabledFilterRegex = enabledFilterRegex;
	}



	public Boolean getEnabledFilterContact() {
		return enabledFilterContact;
	}



	public void setEnabledFilterContact(Boolean enabledFilterContact) {
		this.enabledFilterContact = enabledFilterContact;
	}


	@Override
	public void setId(Integer id) {
		this.id = id;
		
	}

	@Override
	public Integer getId() {
		return this.id;
	}

	public ContentValues getContentValues() {
		ContentValues val = new ContentValues();
		val.put( "id", this.getId() );
		val.put( "regex", this.getRegex() );
		val.put( "regex_type", this.getRegexType().getId() );
		val.put( "contact_number", this.getContactNumber() );
		val.put( "enabled_filter_contact", this.getEnabledFilterContact() ? 1 : 0 );
		val.put( "enabled_filter_regex", this.getEnabledFilterRegex() ? 1 : 0 );
		val.put( "id_rule", this.getIdRule() );
		return val;
	}

	public void setBean(Cursor cr) {
		this.setId(cr.getInt( 0 ));
		this.setRegex(cr.getString( 1 ));
		this.setRegexType(RegexType.getRegexTypeById((Integer)cr.getInt( 2 )));
		this.setContactNumber(cr.getString( 3 ));
		this.setEnabledFilterContact( cr.getInt( 4 ) == 0 ? false : true);
		this.setEnabledFilterRegex( cr.getInt( 5 ) == 0 ? false : true);
		this.setIdRule( cr.getInt(6) );
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Filter other = (Filter) obj;
		if (contactNumber == null) {
			if (other.contactNumber != null)
				return false;
		} else if (!contactNumber.equals(other.contactNumber))
			return false;
		if (enabledFilterContact == null) {
			if (other.enabledFilterContact != null)
				return false;
		} else if (!enabledFilterContact.equals(other.enabledFilterContact))
			return false;
		if (enabledFilterRegex == null) {
			if (other.enabledFilterRegex != null)
				return false;
		} else if (!enabledFilterRegex.equals(other.enabledFilterRegex))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (idRule == null) {
			if (other.idRule != null)
				return false;
		} else if (!idRule.equals(other.idRule))
			return false;
		if (regex == null) {
			if (other.regex != null)
				return false;
		} else if (!regex.equals(other.regex))
			return false;
		if (regexType != other.regexType)
			return false;
		return true;
	}

}
