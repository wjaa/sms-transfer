package br.com.wjaa.smstransfer.module;

import android.content.Context;
import br.com.wjaa.smstransfer.service.DataService;
import br.com.wjaa.smstransfer.service.RuleService;
import br.com.wjaa.smstransfer.service.impl.DataServiceImpl;
import br.com.wjaa.smstransfer.service.impl.RuleServiceImpl;

import com.google.inject.Binder;
import com.google.inject.Module;

/**
 * 
 * Classe reponsavel por registrar as implementacoes das interfaces.
 * 
 * 
 * @author wagneraraujo-sao
 *
 */
public class FindClassInjectableModule implements Module {

	private Context context;
	
	public FindClassInjectableModule(Context context){
		this.context = context;
	}
	
	
	@Override
	public void configure(Binder binder) {
		binder.bind(RuleService.class).to(RuleServiceImpl.class);
		binder.bind(DataService.class).toInstance(new DataServiceImpl(this.context));
	}
	
}
