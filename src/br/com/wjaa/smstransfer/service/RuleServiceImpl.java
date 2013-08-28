package br.com.wjaa.smstransfer.service;

import java.util.List;

import com.google.inject.Inject;

import br.com.wjaa.smstransfer.model.Rule;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public class RuleServiceImpl implements RuleService {

	@Inject
	private DataService dataService;
	
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Rule> listRules() {
		return dataService.getList(Rule.class);
	}

	@Override
	public String getAlgo() {
		
		return "algo na tela manooo";
	}

}
