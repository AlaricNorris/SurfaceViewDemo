package com.example.alaricnorris.bodemapdemo ;

import com.google.gson.Gson ;
import android.app.Activity ;
import android.app.ActionBar ;
import android.app.Fragment ;
import android.os.Bundle ;
import android.util.Log ;
import android.view.LayoutInflater ;
import android.view.Menu ;
import android.view.MenuItem ;
import android.view.View ;
import android.view.ViewGroup ;
import android.os.Build ;

public class MainActivity extends Activity {

	@ Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState) ;
		setContentView(R.layout.activity_main) ;
		if(savedInstanceState == null) {
			getFragmentManager().beginTransaction().add(R.id.container , new PlaceholderFragment())
					.commit() ;
		}
	}

	@ Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main , menu) ;
		return true ;
	}

	@ Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId() ;
		if(id == R.id.action_settings) {
			return true ;
		}
		return super.onOptionsItemSelected(item) ;
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@ Override
		public View onCreateView(LayoutInflater inflater , ViewGroup container ,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_bodymap , container , false) ;
			BodyMap mBodyMap = (BodyMap) rootView.findViewById(R.id.a) ;
			Gson mGson = new Gson() ;
			BodyParams mBodyParams = mGson
					.fromJson(
							"{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\",\"female_front_3breast\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}" ,
							BodyParams.class) ;
			Log.i("tag" , "mBodyParams" + mBodyParams) ;
//			mBodyMap.setBodyParams(mBodyParams) ;
			return rootView ;
		}
	}
}
