package br.com.wjaa.smstransfer.activity;

import roboguice.inject.InjectView;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.model.Action;
import br.com.wjaa.smstransfer.model.Filter;
import br.com.wjaa.smstransfer.model.Rule;
import br.com.wjaa.smstransfer.service.RuleService;

import com.google.inject.Inject;

public class RuleFormActivity extends Activity implements OnClickListener{

	@Inject
	private RuleService ruleService;
	
	@InjectView(R.id.btnSalvar)
	private Button btnSalvar;
	
	@InjectView(R.id.edtNomeRegra)
	private EditText edtNomeRegra;
	
	@InjectView(R.id.edtRegex)
	private EditText edtRegex;
	
	@InjectView(R.id.edtContato)
	private EditText edtContato;
	
	@InjectView(R.id.edtEmail)
	private EditText edtEmail;
	
	@InjectView(R.id.chbEnabledContact)
	private CheckBox chbEnabledContact;
	
	@InjectView(R.id.chbEnabledRegex)
	private CheckBox chbEnabledRegex;
	
	@InjectView(R.id.chbEnabledEmail)
	private CheckBox chbEnabledEmail;
	
	private Rule rule;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_form);
		Integer idRule = savedInstanceState.getInt("idRule");
		
		if (idRule != null){
			this.populateView(idRule);
		}
		
		this.btnSalvar.setOnClickListener(this);
	}

	private void populateView(Integer idRule) {
		this.rule = this.ruleService.getRuleById(idRule);
		edtNomeRegra.setText(rule.getNome());
		
		Filter filter = this.ruleService.getFilterByIdRule(idRule);
		
		if (filter != null){
			chbEnabledContact.setChecked(filter.getEnabledFilterContact());
			chbEnabledRegex.setChecked(filter.getEnabledFilterRegex());
			edtRegex.setText(filter.getRegex());
			edtContato.setText(filter.getContactNumber());
		}
		
		Action action = this.ruleService.getActionByIdRule(idRule);
		
		if (action != null){
			chbEnabledEmail.setChecked(action.getEnabledEmail());
			edtEmail.setText(action.getEmail());
		}
	}

	@Override
	public void onClick(View v) {
		if ( validate() ){
			this.populateModelAndSave();
		}
		
		
	}

	private boolean validate() {
		if ( edtNomeRegra.getText() == null){
			AlertDialog alertDialog = new AlertDialog.Builder(this).create();
			alertDialog.setTitle("Campo obrigatorio");
			alertDialog.setMessage("Campo nome da regra é obrigatorio");
			alertDialog.show();
			return false;
		}
		return true;
	}

	private void populateModelAndSave() {
		if (rule == null){
			rule = new Rule();
		}
		rule.setNome(edtNomeRegra.getText().toString());
		
		rule = this.ruleService.saveRule(rule);
		
		Action action = this.ruleService.getActionByIdRule(rule.getId());
		if (action == null){
			action = new Action();
			action.setIdRule(rule.getId());
		}
		action.setEnabledEmail(chbEnabledEmail.isChecked());
		action.setEmail(edtEmail.getText().toString());
		
		this.ruleService.saveAction(action);
		
		Filter filter = this.ruleService.getFilterByIdRule(rule.getId());
		if (filter == null){
			filter = new Filter();
			filter.setIdRule(rule.getId());
		}
		filter.setContactNumber(edtContato.getText().toString());
		filter.setRegex(edtRegex.getText().toString());
		filter.setEnabledFilterContact(chbEnabledContact.isChecked());
		filter.setEnabledFilterRegex(chbEnabledRegex.isChecked());
		
		this.ruleService.saveFilter(filter);
	}
	
	
	

}
