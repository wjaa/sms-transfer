package br.com.wjaa.smstransfer.js.service;

import android.app.Activity;
import br.com.wjaa.smstransfer.R;


/**
 * 
 * @author Wagner Araujo	
 *
 */
public class JsBuilder{

	/**
	 * Cria um executor de javascript utilizando a API do Rhino
	 * @param bodyMethod
	 * @return
	 */
	public JsExecutor createJsExecutorRinno(String bodyMethod, Activity a){
		//pegando a assinatura do metodo
		String assinatura = a.getResources().getString(R.string.assinaturaMethodJs);
		
		//adicionando o corpo
		String js = String.format(assinatura, bodyMethod);
		
		return new JsExecutorRhino(js);
	}
	
	
}
