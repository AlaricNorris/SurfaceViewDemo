package com.example.alaricnorris.bodymapdemo ;

import java.util.Random ;
import android.app.Activity ;
import android.app.Fragment ;
import android.graphics.BitmapFactory ;
import android.os.Bundle ;
import android.os.Handler ;
import android.os.Message ;
import android.util.Log ;
import android.view.LayoutInflater ;
import android.view.View ;
import android.view.View.OnClickListener ;
import android.view.ViewGroup ;
import android.widget.AdapterView ;
import android.widget.ArrayAdapter ;
import android.widget.Button ;
import android.widget.CompoundButton ;
import android.widget.Toast ;
import android.widget.CompoundButton.OnCheckedChangeListener ;
import android.widget.Spinner ;
import android.widget.Switch ;
import com.example.alaricnorris.bodymapdemo.BuildConfig ;
import com.example.alaricnorris.bodymapdemo.R ;
import com.example.alaricnorris.bodymapdemo.widget.BodyMap ;
import com.example.alaricnorris.bodymapdemo.widget.BodyParams ;
import com.example.alaricnorris.bodymapdemo.widget.Constants ;
import com.google.gson.Gson ;

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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment implements OnClickListener ,
			OnCheckedChangeListener {

		BodyMap mBodyMap ;

		Button mButton ;

		Button mButton_Random ;

		// 声明spinner对象  
		private Spinner spinner ;

		Handler mHandler = new Handler() {

			/**
			 * 	(non-Javadoc)
			 * 	@see android.os.Handler#handleMessage(android.os.Message)
			 */
			@ Override
			public void handleMessage(Message msg) {
				super.handleMessage(msg) ;
				if(BuildConfig.DEBUG) {
					Log.i("tag" + "handleMessage" , msg.toString()) ;
					Toast.makeText(getActivity() , msg.toString() , 0).show() ;
				}
				if(msg == null || msg.what == 0) {
					return ;
				}
				switch(msg.what) {
					case Constants.MSG_WHAT_PART1_HEAD :
						break ;
					case Constants.MSG_WHAT_PART2_NECK :
						break ;
					case Constants.MSG_WHAT_PART3_BEEAST :
						break ;
					case Constants.MSG_WHAT_PART4_ARMS_LEGS :
						break ;
					case Constants.MSG_WHAT_PART5_BELLY :
						break ;
					case Constants.MSG_WHAT_PART6_BACK :
						break ;
					case Constants.MSG_WHAT_PART7_UNDERPANTS :
						break ;
					case Constants.MSG_WHAT_PART8_HIP :
						break ;
					default :
						break ;
				}
			}
		} ;

		public PlaceholderFragment() {
		}

		@ Override
		public View onCreateView(LayoutInflater inflater , ViewGroup container ,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_bodymap , container , false) ;
			mBodyMap = (BodyMap) rootView.findViewById(R.id.a) ;
			mBodyMap.setHandler(mHandler) ;
			mButton = (Button) rootView.findViewById(R.id.btn) ;
			mButton_Random = (Button) rootView.findViewById(R.id.btn_random) ;
			mButton.setOnClickListener(this) ;
			mButton_Random.setOnClickListener(this) ;
			((Switch) rootView.findViewById(R.id.switch_show)).setOnCheckedChangeListener(this) ;
			spinner = (Spinner) rootView.findViewById(R.id.spinner) ;
			final String arr[] = new String[] { "body_map_female_front" , "body_map_female_back" ,
					"body_map_male_front" , "body_map_male_back" } ;
			ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity() ,
					android.R.layout.simple_spinner_item , arr) ;
			spinner.setAdapter(arrayAdapter) ;
			spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

				@ Override
				public void onItemSelected(AdapterView< ? > parent , View view , int position ,
						long id) {
					// String content = arr[position];  
					if(Constants.BodyParams_Female_Front.getImageName().equals(arr[position])) {
						mBodyMap.setBodyParams(Constants.BodyParams_Female_Front) ;
					}
					if(Constants.BodyParams_Female_Back.getImageName().equals(arr[position])) {
						mBodyMap.setBodyParams(Constants.BodyParams_Female_Back) ;
					}
					if(Constants.BodyParams_Male_Front.getImageName().equals(arr[position])) {
						mBodyMap.setBodyParams(Constants.BodyParams_Male_Front) ;
					}
					if(Constants.BodyParams_Male_Back.getImageName().equals(arr[position])) {
						mBodyMap.setBodyParams(Constants.BodyParams_Male_Back) ;
					}
				}

				@ Override
				public void onNothingSelected(AdapterView< ? > parent) {
				}
			}) ;
//			mBodyMap.setBodyParams(Constants.BodyParams_Female_Back) ;
			return rootView ;
		}

		/**
		 * 	(non-Javadoc)
		 * 	@see android.view.View.OnClickListener#onClick(android.view.View)
		 */
		@ Override
		public void onClick(View v) {
			switch(v.getId()) {
				case R.id.btn :
					Gson mGson = new Gson() ;
					BodyParams mBodyParams = mGson
							.fromJson(
									"{\"layerNames\":[\"female_front_1head\",\"female_front_2neck\"],\"regions\":{\"female_front_1head\":[{\"x\":135,\"y\":0},{\"x\":240,\"y\":0},{\"x\":232,\"y\":125},{\"x\":142,\"y\":125}],\"female_front_2neck\":[{\"x\":171,\"y\":120},{\"x\":165,\"y\":147},{\"x\":140,\"y\":158},{\"x\":188,\"y\":168},{\"x\":239,\"y\":161},{\"x\":210,\"y\":147},{\"x\":200,\"y\":123}]}}" ,
									BodyParams.class) ;
					Log.i("tag" , "mBodyParams" + mBodyParams) ;
					Log.i("tag" , "mBodyParams_Female_Front" + Constants.BodyParams_Female_Front) ;
					mBodyMap.setBodyParams(Constants.BodyParams_Female_Front) ;
					break ;
				case R.id.btn_random :
					int[] randomArr = new int[] { R.drawable.body_map_female_back ,
							R.drawable.body_map_female_front , R.drawable.body_map_male_back ,
							R.drawable.body_map_male_front } ;
					int index = new Random().nextInt(3) ;
					mBodyMap.setImage(BitmapFactory.decodeResource(getResources() ,
							randomArr[index])) ;
					break ;
				default :
					break ;
			}
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
