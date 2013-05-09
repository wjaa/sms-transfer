package br.com.wjaa.smstransfer.database;

import java.io.Serializable;

import android.content.ContentValues;
import android.database.Cursor;

public abstract class PersistenceBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String tabela = null;
	private String colunas[] = null;
	
	public PersistenceBean( String tabela, String[] colunas ) {
		this.tabela = tabela;
		this.colunas = colunas;
	}
	
	public final String getTabela() {
		return tabela;
	}

	public final String[] getColunas() {
		return colunas;
	}
	
	public abstract ContentValues getContentValues();
	
	public abstract void setBean( Cursor cr );
	
	public abstract void setId( Integer id );
	
	public abstract Integer getId();
	
	public abstract boolean equals(Object o);

}
