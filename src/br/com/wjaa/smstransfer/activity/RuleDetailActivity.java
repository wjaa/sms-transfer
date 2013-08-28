package br.com.wjaa.smstransfer.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.model.Rule;
import br.com.wjaa.smstransfer.service.RuleService;

import com.google.inject.Inject;

public class RuleDetailActivity extends RoboActivity implements OnClickListener {
	
	@Inject
	private RuleService ruleService;
	private Rule rule;
	
	@InjectView(R.id.txvNomeRule)
	private TextView txvNomeRule;
	
	@InjectView(R.id.btnModoAvancado)
	private Button btnModoAvancado;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_detail);
		Intent myIntent= getIntent(); // gets the previously created intent
		int idRule = myIntent.getIntExtra("idRule",0);
		rule = this.ruleService.getRuleById(idRule);
		txvNomeRule.setText(rule.getNome());
		btnModoAvancado.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_rule, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, RuleFunctionActivity.class);
		startActivityForResult(i, 1);
	}

}
