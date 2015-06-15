package com.example.alaricnorris.bodemapdemo ;

import com.example.alaricnorris.bodemapdemo.widget.BodyMap ;
import com.example.alaricnorris.bodemapdemo.widget.BodyParams ;
import com.example.alaricnorris.bodemapdemo.widget.Constants ;
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
import android.view.View.OnClickListener ;
import android.view.ViewGroup ;
import android.widget.CompoundButton ;
import android.widget.CompoundButton.OnCheckedChangeListener ;
import android.widget.Switch ;
import android.widget.TextView ;
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
	public static class PlaceholderFragment extends Fragment implements OnClickListener ,
			OnCheckedChangeListener {

		BodyMap mBodyMap ;

		TextView mTextView ;

		public PlaceholderFragment() {
		}

		@ Override
		public View onCreateView(LayoutInflater inflater , ViewGroup container ,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_bodymap , container , false) ;
			mBodyMap = (BodyMap) rootView.findViewById(R.id.a) ;
			mTextView = (TextView) rootView.findViewById(R.id.text) ;
			mTextView.setOnClickListener(this) ;
			((Switch) rootView.findViewById(R.id.switch_show)).setOnCheckedChangeListener(this) ;
			return rootView ;
		}

		/**
		 * 	(non-Javadoc)
		 * 	@see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@ Override
		public void onClick(View v) {
			Gson mGson = new Gson() ;
			BodyParams mBodyParams = mGson
					.fromJson(
							"{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}" ,
							BodyParams.class) ;
			Log.i("tag" , "mBodyParams" + mBodyParams) ;
			Log.i("tag" , "mBodyParams_Female_Front" + Constants.mBodyParams_Female_Front) ;
			mBodyMap.setBodyParams(Constants.mBodyParams_Female_Front) ;
		}

		/**
		 * 	(non-Javadoc)
		 * 	@see android.widget.CompoundButton.OnCheckedChangeListener#onCheckedChanged(android.widget.CompoundButton, boolean)
		 */
		@ Override
		public void onCheckedChanged(CompoundButton arg0 , boolean arg1) {
			mBodyMap.setShowDetectRegion(arg1) ;
		}
	}
}
