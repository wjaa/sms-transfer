package br.com.wjaa.smstransfer.activity;

import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ListView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.activity.adapter.StableArrayAdapter;
import br.com.wjaa.smstransfer.model.RuleEntity;
import br.com.wjaa.smstransfer.service.RuleService;
import br.com.wjaa.smstransfer.utils.AndroidUtils;

import com.google.inject.Inject;

/**
 * 
 * @author wagneraraujo-sao
 *
 */
@ContentView(R.layout.activity_home)
public class HomeActivity extends RoboActivity implements OnClickListener{

	@Inject
	private RuleService ruleService;
	
	@InjectView(R.id.listViewRule)
	private ListView listView;
	
	@InjectView(R.id.btnAdd)
	private ImageButton btnAdd;
	@InjectView(R.id.btnHistory)
	private ImageButton btnHistory;
	@InjectView(R.id.btnPends)
	private ImageButton btnPend;
	@InjectView(R.id.btnConfig)
	private ImageButton btnConfig;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		listAllRules();
		this.createActionsMenu();
	}



	private void listAllRules() {
		List<RuleEntity> rules = ruleService.listRules();
		this.listView.setAdapter(new StableArrayAdapter(this, R.layout.activity_home, rules));
	}

	
	
	private void createActionsMenu() {
		btnAdd.setOnClickListener(this);
		btnHistory.setOnClickListener(this);
		btnPend.setOnClickListener(this);
		btnConfig.setOnClickListener(this);
	}



	@Override
	public void onClick(View v) {
		
		switch (v.getId()) {
		case R.id.btnAdd: AndroidUtils.openActivity(this, RuleFormActivity.class); 
			break;
		case R.id.btnHistory: AndroidUtils.openActivity(this, RuleHistoryActivity.class); 
			break;
		case R.id.btnPends: AndroidUtils.openActivity(this, RulePendsActivity.class); 
			break;
		case R.id.btnConfig: AndroidUtils.openActivity(this, ConfigActivity.class); 
			break;
		}
		
	}



	@Override
	protected void onRestart() {
		super.onRestart();
		this.listAllRules();
	}
	

}
