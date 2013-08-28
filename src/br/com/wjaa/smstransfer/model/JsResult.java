package br.com.wjaa.smstransfer.model;


/**
 * 
 * @author Wagner Jeronimo
 *
 */
public class JsResult {

	
	public String result;
	public String erro;
	
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getErro() {
		return erro;
	}
	public void setErro(String erro) {
		this.erro = erro;
	}
	
	public boolean temErros(){
		return this.erro != null && !"".equals(this.erro); 
	}
}
