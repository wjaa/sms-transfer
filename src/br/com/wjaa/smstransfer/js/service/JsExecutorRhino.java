package br.com.wjaa.smstransfer.js.service;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Function;
import org.mozilla.javascript.Scriptable;

import br.com.wjaa.smstransfer.model.JsResult;

/**
 * 
 * @author Wagner Jeronimo.
 *
 */
public class JsExecutorRhino implements JsExecutor{

	private static final String METHOD_NAME = "exec";
	private static final String SMS_PARAM = "Ta Eu quero ser muito rica Ou Eu adoraria socar meu namorado";
	private String js;
	private Context cx;
	private Scriptable scope;
	
	
	public JsExecutorRhino(String js){
		this.cx = Context.enter();
		this.cx.setOptimizationLevel(-1);
		this.scope = cx.initStandardObjects();
		this.js = js;
	}
	
	/**
	 * 
	 */
	@Override
	public JsResult compile(){
		return this.execute(new Object[]{SMS_PARAM});
		
	}

	@Override
	public JsResult execute(Object[] param){
		JsResult result = new JsResult();
		try{
			Function f = cx.compileFunction(scope, js, METHOD_NAME, 1, null);
			Object o = f.call(cx, scope, scope, param);
			result.setResult(o.toString());
		}catch (Exception ex){
			result.setErro(ex.getMessage());
		}
		return result;
	}
	
}
