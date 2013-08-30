package br.com.wjaa.smstransfer.service;

import java.util.List;

import br.com.wjaa.smstransfer.model.ActionEntity;
import br.com.wjaa.smstransfer.model.FilterEntity;
import br.com.wjaa.smstransfer.model.RuleEntity;
import br.com.wjaa.smstransfer.model.RuleFunctionEntity;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
public interface RuleService {

	/**
	 * Lista todas as regras criadas pelo usu�rio.
	 * @return Lista de regras
	 */
	List<RuleEntity> listRules();

	/**
	 * Busca um Rule pelo seu id.
	 * @param idRule
	 * @return
	 */
	RuleEntity getRuleById(int idRule);

	
	/**
	 * Busca um Filter pelo id da rule.
	 * @param idRule
	 * @return
	 */
	FilterEntity getFilterByIdRule(Integer idRule);

	/**
	 * Busca uma Action pelo id da rule
	 * @param idRule
	 * @return
	 */
	ActionEntity getActionByIdRule(Integer idRule);
	
	
	/**
	 * Busca uma RuleFunction pelo id da rule.
	 * @param idRule
	 * @return
	 */
	RuleFunctionEntity getRuleFunctionByIdRule(Integer idRule);

	/**
	 * Salva um rule
	 * @param rule
	 * @return 
	 */
	RuleEntity saveRule(RuleEntity rule);

	
	/**
	 * 
	 * @param action
	 */
	void saveAction(ActionEntity action);

	
	/**
	 * 
	 * @param filter
	 */
	void saveFilter(FilterEntity filter);

	
	/**
	 * 
	 * @param rule
	 */
	void removeRule(RuleEntity rule);
	
}
