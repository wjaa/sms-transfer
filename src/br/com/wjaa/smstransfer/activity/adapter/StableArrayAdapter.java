package br.com.wjaa.smstransfer.activity.adapter;

import java.util.HashMap;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.activity.listener.RuleListClickListener;
import br.com.wjaa.smstransfer.model.RuleEntity;

public class StableArrayAdapter extends ArrayAdapter<RuleEntity>{
	int selectedRule = 0;
    HashMap<Integer, RuleEntity> mIdMap = new HashMap<Integer, RuleEntity>();
    Activity context;
    public StableArrayAdapter(Context context, int textViewResourceId,
        List<RuleEntity> rules) {
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
      
        RuleEntity r = this.mIdMap.get(position);
        
        tv.setText(r.getNome());
        tv.setOnClickListener(new RuleListClickListener(this.context,r));
      return tv;
    }


	
  }
