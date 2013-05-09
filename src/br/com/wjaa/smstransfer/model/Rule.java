package br.com.wjaa.smstransfer.model;

import android.content.ContentValues;
import android.database.Cursor;
import br.com.wjaa.smstransfer.database.PersistenceBean;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class Rule extends PersistenceBean{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1835808368715210686L;
	private Integer id;
	private String nome;
	
	
	public Rule() {
		super( "rule", new String[] { "id", "nome"} );
		
	}


	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public ContentValues getContentValues() {
		ContentValues val = new ContentValues();
		val.put( "id", this.getId() );
		val.put( "nome", this.getNome() );
		return val;
	}

	public void setBean(Cursor cr) {
		this.setId( cr.getInt( 0 ) );
		this.setNome( cr.getString( 1 ) );
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rule other = (Rule) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
}
