package br.com.wjaa.smstransfer.service;

import java.util.List;

import br.com.wjaa.smstransfer.model.Action;
import br.com.wjaa.smstransfer.model.Filter;
import br.com.wjaa.smstransfer.model.Rule;

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
	List<Rule> listRules();

	/**
	 * Busca um Rule pelo seu id.
	 * @param idRule
	 * @return
	 */
	Rule getRuleById(int idRule);

	
	/**
	 * Busca um Filter pelo id da rule.
	 * @param idRule
	 * @return
	 */
	Filter getFilterByIdRule(Integer idRule);

	/**
	 * Busca uma Action pelo id da rule
	 * @param idRule
	 * @return
	 */
	Action getActionByIdRule(Integer idRule);

	/**
	 * Salva um rule
	 * @param rule
	 * @return 
	 */
	Rule saveRule(Rule rule);

	
	/**
	 * 
	 * @param action
	 */
	void saveAction(Action action);

	
	/**
	 * 
	 * @param filter
	 */
	void saveFilter(Filter filter);
	
}
