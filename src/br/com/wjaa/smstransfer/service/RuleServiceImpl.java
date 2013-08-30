package br.com.wjaa.smstransfer.service;

import java.util.List;

import br.com.wjaa.smstransfer.model.ActionEntity;
import br.com.wjaa.smstransfer.model.FilterEntity;
import br.com.wjaa.smstransfer.model.RuleEntity;
import br.com.wjaa.smstransfer.model.RuleFunctionEntity;

import com.google.inject.Inject;

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
	public List<RuleEntity> listRules() {
		return dataService.getList(RuleEntity.class);
	}


	@Override
	public RuleEntity getRuleById(int idRule) {
		return dataService.getById(RuleEntity.class, idRule);
	}


	@Override
	public FilterEntity getFilterByIdRule(Integer idRule) {
		return dataService.findUniqueResult(FilterEntity.class, "id_rule=?", new String[]{String.valueOf(idRule)});
	}


	@Override
	public ActionEntity getActionByIdRule(Integer idRule) {
		return dataService.findUniqueResult(ActionEntity.class, "id_rule=?", new String[]{String.valueOf(idRule)});
	}
	
	@Override
	public RuleFunctionEntity getRuleFunctionByIdRule(Integer idRule) {
		return dataService.findUniqueResult(RuleFunctionEntity.class, "id_rule=?", new String[]{String.valueOf(idRule)});
	}


	@Override
	public RuleEntity saveRule(RuleEntity rule) {
		return this.dataService.insertOrUpdate(rule);
	}


	@Override
	public void saveAction(ActionEntity action) {
		this.dataService.insertOrUpdate(action);
	}


	@Override
	public void saveFilter(FilterEntity filter) {
		this.dataService.insertOrUpdate(filter);
		
	}


	@Override
	public void removeRule(RuleEntity rule) {
		//fazendo cascata.
		ActionEntity action = this.getActionByIdRule(rule.getId());
		
		if (action != null){
			this.dataService.deleteById(action);
		}
		
		FilterEntity filter = this.getFilterByIdRule(rule.getId());
		
		if (filter != null){
			this.dataService.deleteById(filter);
		}
		
		RuleFunctionEntity function = this.getRuleFunctionByIdRule(rule.getId());
		
		if (function != null){
			this.dataService.deleteById(function);
		}
		
		this.dataService.deleteById(rule);
		
	}

}
