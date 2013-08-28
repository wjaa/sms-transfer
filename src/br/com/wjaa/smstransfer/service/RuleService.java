package br.com.wjaa.smstransfer.service;

import java.util.List;

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
	
}
