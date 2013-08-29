package br.com.wjaa.smstransfer.activity;

import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.R.layout;
import br.com.wjaa.smstransfer.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class RuleHistoryActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_history);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.rule_history, menu);
		return true;
	}

}
