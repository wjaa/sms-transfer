package br.com.wjaa.smstransfer.activity;

import roboguice.activity.RoboActivity;
import roboguice.inject.InjectView;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.R.id;
import br.com.wjaa.smstransfer.R.layout;
import br.com.wjaa.smstransfer.R.menu;
import br.com.wjaa.smstransfer.js.service.JsBuilder;
import br.com.wjaa.smstransfer.js.service.JsExecutor;
import br.com.wjaa.smstransfer.model.JsResult;

public class RuleFunctionActivity extends RoboActivity implements OnClickListener{

	@InjectView(R.id.btnExecuteJs)
	private Button btnExecuteJs;
	
	@InjectView(R.id.edtBodyJs)
	private EditText edtBodyJs;
	
	@InjectView(R.id.txvResult)
	private TextView txvResult;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rule_function);
		btnExecuteJs.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.advanced_rule, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		JsBuilder builder = new JsBuilder();
		JsExecutor executor = builder.createJsExecutorRinno(edtBodyJs.getText().toString(), this);
		JsResult result = executor.compile();
		if (result.temErros()){
			txvResult.setText(result.getErro());
		}else{
			txvResult.setText(result.getResult());
		}
		
	}

}
