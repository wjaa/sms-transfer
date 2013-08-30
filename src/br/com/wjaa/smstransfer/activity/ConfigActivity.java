package br.com.wjaa.smstransfer.activity;

import roboguice.inject.ContentView;
import br.com.wjaa.smstransfer.R;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;


/**
 * 
 * @author Wagner Jeronimo
 *
 */
@ContentView(R.layout.activity_home)
public class ConfigActivity extends Activity {

	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.config, menu);
        return true;
    }
    
}
