package br.com.wjaa.smstransfer.activity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import br.com.wjaa.smstransfer.activity.RuleDetailActivity;
import br.com.wjaa.smstransfer.model.Rule;

public class RuleListClickListener implements OnClickListener {

	private Activity context;
	private Rule rule;
	
	public RuleListClickListener(Activity context, Rule rule){
		this.context = context;
		this.rule = rule;
	}
	
	@Override
	public void onClick(View v) {
		Intent i = new Intent(context, RuleDetailActivity.class);
		i.putExtra("idRule", rule.getId());
		context.startActivityForResult(i, 1);
		
	}

}
