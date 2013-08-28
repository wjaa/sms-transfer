package br.com.wjaa.smstransfer.activity;

import java.util.HashMap;
import java.util.List;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectFragment;
import roboguice.inject.InjectView;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.model.Rule;
import br.com.wjaa.smstransfer.service.RuleService;

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
	
	@InjectView(R.id.btnModoAvancado)
	private Button btnModoAvancado;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		//TextView t = (TextView) findViewById(R.id.texthome);
		
		List<Rule> rules = ruleService.listRules();
		this.listView.setAdapter(new StableArrayAdapter(this, R.layout.activity_home, rules));
		
		btnModoAvancado.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.home, menu);
		return true;
	}

	
	private class StableArrayAdapter extends ArrayAdapter<Rule> implements OnClickListener {
		int selectedRule = 0;
	    HashMap<Integer, Rule> mIdMap = new HashMap<Integer, Rule>();
	    Activity context;
	    public StableArrayAdapter(Context context, int textViewResourceId,
	        List<Rule> rules) {
	      super(context, textViewResourceId, rules);
	      for (int i = 0; i < rules.size(); ++i) {
	        mIdMap.put(i,rules.get(i));
	      }
	      this.context = (Activity) context;
	    }

	    @Override
	    public View getView(int position, View convertView, ViewGroup parent) {
	    	LayoutInflater inflater = context.getLayoutInflater();
	    	View v = inflater.inflate(R.layout.list_item, parent, false);  
	        TextView tv = (TextView)v.findViewById(R.id.listItemBase);
	      
	        Rule r = this.mIdMap.get(position);
	        tv.setText(r.getNome());
	        tv.setOnClickListener(StableArrayAdapter.this);
	        
	      return tv;
	    }

		@Override
		public void onClick(View v) {
			Intent i = new Intent(HomeActivity.this, RuleDetailActivity.class);
			i.putExtra("idRule", selectedRule);
			startActivityForResult(i, 1);
			
		}
	  }


	@Override
	public void onClick(View v) {
		Intent i = new Intent(this, RuleFunctionActivity.class);
		startActivityForResult(i, 1);
	}

	

}
