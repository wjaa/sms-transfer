package br.com.wjaa.smstransfer.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.callback.DialogCallback;
import br.com.wjaa.smstransfer.model.ActionEntity;
import br.com.wjaa.smstransfer.model.FilterEntity;
import br.com.wjaa.smstransfer.model.RuleEntity;
import br.com.wjaa.smstransfer.service.RuleService;
import br.com.wjaa.smstransfer.utils.AndroidUtils;

import com.google.inject.Inject;

@ContentView(R.layout.activity_rule_form)
public class RuleFormActivity extends RoboActivity implements OnClickListener, DialogCallback{

	@Inject
	private RuleService ruleService;
	
	@InjectView(R.id.btnSalvar)
	private Button btnSalvar;
	
	@InjectView(R.id.btnModoAvancado)
	private Button btnModoAdvanced;
	
	@InjectView(R.id.btnApagar)
	private Button btnApagar;
	
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
	
	private RuleEntity rule;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_form);
		Intent myIntent= getIntent(); // gets the previously created intent
		Integer idRule = myIntent.getIntExtra("idRule",0);
		
		if (idRule != null && idRule > 0){
			this.populateView(idRule);
		}
		
		this.btnSalvar.setOnClickListener(this);
		this.btnModoAdvanced.setOnClickListener(this);
		this.btnApagar.setOnClickListener(this);
	}

	private void populateView(Integer idRule) {
		this.rule = this.ruleService.getRuleById(idRule);
		edtNomeRegra.setText(rule.getNome());
		
		FilterEntity filter = this.ruleService.getFilterByIdRule(idRule);
		
		if (filter != null){
			chbEnabledContact.setChecked(filter.getEnabledFilterContact());
			chbEnabledRegex.setChecked(filter.getEnabledFilterRegex());
			edtRegex.setText(filter.getRegex());
			edtContato.setText(filter.getContactNumber());
		}
		
		ActionEntity action = this.ruleService.getActionByIdRule(idRule);
		
		if (action != null){
			chbEnabledEmail.setChecked(action.getEnabledEmail());
			edtEmail.setText(action.getEmail());
		}
	}

	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnSalvar:
			
			if ( validate() ){
				this.populateModelAndSave();
				AndroidUtils.showMessageDlg("Info",
						"Regra salva com sucesso!", this);
			}
			
			break;
		case R.id.btnModoAvancado:
			AndroidUtils.openActivity(this, RuleFunctionActivity.class);
			break;
			
		case R.id.btnApagar:
			AndroidUtils.showConfirmDlg("Duvida?", "Deseja realmente apagar essa regra?", 
					this, this);
			break;	

		default:
			break;
		}
		
		
		
	}

	private boolean validate() {
		if ( edtNomeRegra.getText().length() == 0){
			AndroidUtils.showMessageDlg("Campo Obrigatorio",
					"Campo nome da regra é obrigatorio", this);
			edtNomeRegra.requestFocus();
			return false;
		}
		return true;
	}

	private void populateModelAndSave() {
		if (rule == null){
			rule = new RuleEntity();
		}
		rule.setNome(edtNomeRegra.getText().toString());
		
		rule = this.ruleService.saveRule(rule);
		
		ActionEntity action = this.ruleService.getActionByIdRule(rule.getId());
		if (action == null){
			action = new ActionEntity();
			action.setIdRule(rule.getId());
		}
		action.setEnabledEmail(chbEnabledEmail.isChecked());
		action.setEmail(edtEmail.getText().toString());
		
		this.ruleService.saveAction(action);
		
		FilterEntity filter = this.ruleService.getFilterByIdRule(rule.getId());
		if (filter == null){
			filter = new FilterEntity();
			filter.setIdRule(rule.getId());
		}
		filter.setContactNumber(edtContato.getText().toString());
		filter.setRegex(edtRegex.getText().toString());
		filter.setEnabledFilterContact(chbEnabledContact.isChecked());
		filter.setEnabledFilterRegex(chbEnabledRegex.isChecked());
		
		this.ruleService.saveFilter(filter);
	}

	@Override
	public void confirm() {
		this.ruleService.removeRule(this.rule);
		this.finish();
	}

	@Override
	public void cancel() {
		
	}

}
