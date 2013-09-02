package br.com.wjaa.smstransfer.activity;

import com.google.inject.Inject;

import roboguice.activity.RoboActivity;
import roboguice.inject.ContentView;
import roboguice.inject.InjectView;
import br.com.wjaa.smstransfer.R;
import br.com.wjaa.smstransfer.buffer.AppBuffer;
import br.com.wjaa.smstransfer.model.AppConfig;
import br.com.wjaa.smstransfer.service.ConfigService;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ToggleButton;


/**
 * 
 * @author Wagner Jeronimo
 *
 */
@ContentView(R.layout.activity_config)
public class ConfigActivity extends RoboActivity {

	@Inject
	private ConfigService configService;
	
	@InjectView(R.id.btnActiveSystemOnStart)
	private ToggleButton btnActiveSystemOnStart;
	
	@InjectView(R.id.btnNotifyExecuteAction)
	private ToggleButton btnNotifyExecuteAction;
	
	@InjectView(R.id.btnNotifySmsAccept)
	private ToggleButton btnNotifySmsAccept;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
        
        AppConfig appConfig = AppBuffer.getAppConfig();
        btnActiveSystemOnStart.setChecked(appConfig.getActiveSystemOnStart());
        btnNotifyExecuteAction.setChecked(appConfig.getNotifyExecuteAction());
        btnNotifySmsAccept.setChecked(appConfig.getNotifySmsAccept());
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.config, menu);
        return true;
    }
    

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		AppConfig appConfig = AppBuffer.getAppConfig();
		appConfig.setActiveSystemOnStart(btnActiveSystemOnStart.isChecked());
		appConfig.setNotifyExecuteAction(btnNotifyExecuteAction.isChecked());
		appConfig.setNotifySmsAccept(btnNotifySmsAccept.isChecked());
		this.configService.saveConfig(appConfig);
	}
    
    
    
}
