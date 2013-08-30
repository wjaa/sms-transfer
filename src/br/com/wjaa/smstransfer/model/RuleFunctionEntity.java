package br.com.wjaa.smstransfer.model;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.wjaa.smstransfer.database.PersistenceBean;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class RuleFunctionEntity extends PersistenceBean{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -4674556804519839667L;
	
	private Integer id;
	private Integer idRule;
	private String bodyFunction;
	

	public RuleFunctionEntity() {
		super( "rule_function", new String[] { "id", "id_rule", "body_function"} );
		
	}
	
	public Integer getIdRule() {
		return idRule;
	}

	public void setIdRule(Integer idRule) {
		this.idRule = idRule;
	}

	public String getBodyFunction() {
		return bodyFunction;
	}

	public void setBodyFunction(String bodyFunction) {
		this.bodyFunction = bodyFunction;
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
		val.put( "id_rule", this.getIdRule());
		val.put( "body_function", this.getBodyFunction());
		return val;
	}

	public void setBean(Cursor cr) {
		this.setId( cr.getInt( 0 ) );
		this.setIdRule( cr.getInt( 1 ) );
		this.setBodyFunction(cr.getString( 2 ) );
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((bodyFunction == null) ? 0 : bodyFunction.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((idRule == null) ? 0 : idRule.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RuleFunctionEntity other = (RuleFunctionEntity) obj;
		if (bodyFunction == null) {
			if (other.bodyFunction != null)
				return false;
		} else if (!bodyFunction.equals(other.bodyFunction))
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
		return true;
	}

	
		
}
