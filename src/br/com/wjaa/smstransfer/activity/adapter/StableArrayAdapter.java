package br.com.wjaa.smstransfer.activity.adapter;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.activity.HomeActivity;
import br.com.wjaa.smstransfer.activity.RuleDetailActivity;
import br.com.wjaa.smstransfer.model.Rule;

public class StableArrayAdapter extends ArrayAdapter<Rule>{
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
        tv.setOnClickListener(new RuleListClickListener(this.context,r));
      return tv;
    }


	
  }
