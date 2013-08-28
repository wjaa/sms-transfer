package br.com.wjaa.smstransfer.activity;

import roboguice.activity.RoboActivity;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.R.layout;
import br.com.wjaa.smstransfer.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RuleDetailActivity extends RoboActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_detail);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.detail_rule, menu);
		return true;
	}

}
