package com.google.linkedinapi.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends Activity {
	private boolean authenticated;
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	super.onCreateOptionsMenu(menu);
    	MenuInflater inflator = getMenuInflater();
    	inflator.inflate(R.menu.main_menu, menu);
    	return true;
    }
    
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
    	super.onPrepareOptionsMenu(menu);
    	MenuItem login = menu.findItem(R.id.login);
		login.setTitle(((authenticated) ? R.string.logoff_menu : R.string.login_menu));
		MenuItem profile = menu.findItem(R.id.profile);
		profile.setEnabled(authenticated);
		MenuItem connections = menu.findItem(R.id.connections);
		connections.setEnabled(authenticated);
		MenuItem updates = menu.findItem(R.id.updates);
		updates.setEnabled(authenticated);
		MenuItem search = menu.findItem(R.id.search);
		search.setEnabled(authenticated);
    	
    	return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    	super.onOptionsItemSelected(item);
    	
    	switch (item.getItemId()) {
		case R.id.login:
			Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show();
			authenticated = !authenticated;
			break;

		case R.id.profile:
			Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
			break;

		case R.id.connections:
			Toast.makeText(this, "Connections", Toast.LENGTH_SHORT).show();
			break;
		
		case R.id.updates:
			Toast.makeText(this, "Updates", Toast.LENGTH_SHORT).show();
			break;
			
		case R.id.search:
			Toast.makeText(this, "Search", Toast.LENGTH_SHORT).show();
			break;
			
		default:
			break;
		}
    	
    	return true;
    }
}