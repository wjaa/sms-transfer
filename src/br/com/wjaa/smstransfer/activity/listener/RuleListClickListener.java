package br.com.wjaa.smstransfer.activity.listener;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import br.com.wjaa.smstransfer.activity.RuleFormActivity;
import br.com.wjaa.smstransfer.model.RuleEntity;

public class RuleListClickListener implements OnClickListener {

	private Activity context;
	private RuleEntity rule;
	
	public RuleListClickListener(Activity context, RuleEntity rule){
		this.context = context;
		this.rule = rule;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(context, RuleFormActivity.class);
		i.putExtra("idRule", rule.getId());
		context.startActivityForResult(i, 1);
		
	}

}
