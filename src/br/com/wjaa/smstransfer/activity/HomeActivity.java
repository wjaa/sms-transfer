package br.com.wjaa.smstransfer.activity;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.activity.adapter.StableArrayAdapter;
import br.com.wjaa.smstransfer.model.Rule;
import br.com.wjaa.smstransfer.service.RuleService;

import com.google.inject.Inject;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
@ContentView(R.layout.activity_home)
public class HomeActivity extends RoboActivity{

	@Inject
	private RuleService ruleService;
	
	@InjectView(R.id.listViewRule)
	private ListView listView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//TextView t = (TextView) findViewById(R.id.texthome);
		
		List<Rule> rules = ruleService.listRules();
		this.listView.setAdapter(new StableArrayAdapter(this, R.layout.activity_home, rules));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

}
