package br.com.wjaa.smstransfer.service;

import java.util.List;

import com.google.inject.Inject;

import br.com.wjaa.smstransfer.model.Action;
import br.com.wjaa.smstransfer.model.Filter;
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
	public Rule getRuleById(int idRule) {
		return dataService.getById(Rule.class, idRule);
	}


	@Override
	public Filter getFilterByIdRule(Integer idRule) {
		return null;
	}


	@Override
	public Action getActionByIdRule(Integer idRule) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Rule saveRule(Rule rule) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void saveAction(Action action) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void saveFilter(Filter filter) {
		// TODO Auto-generated method stub
		
	}

}
