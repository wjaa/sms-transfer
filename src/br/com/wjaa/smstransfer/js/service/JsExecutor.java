package br.com.wjaa.smstransfer.js.service;

import br.com.wjaa.smstransfer.model.JsResult;



/**
 * 
 * @author wagner jeronimo	
 *
 */
public interface JsExecutor {

	
	/**
	 * 
	 * @throws JsException
	 */
	JsResult compile();
	
	/**
	 * 
	 * @param param
	 */
	JsResult execute(Object[] param);
	
}
