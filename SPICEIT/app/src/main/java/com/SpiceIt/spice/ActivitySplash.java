package com.SpiceIt.spice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Window;
// SPLASH ACTIVITY
public class ActivitySplash extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		getWindow().requestFeature(Window.FEATURE_NO_TITLE);

		setContentView(R.layout.splash);


		new CountDownTimer(5000,1000) {

			//THIS IS OUR INTENT explicit
			@Override
			public void onFinish() {
				/** Creates an intent to start new activity */
				Intent intent = new Intent(ActivitySplash.this, MainActivity.class);

				startActivity(intent);

				finish();

			}

			/** This method will be invoked in every 1000 milli seconds until
			 * this timer is expired.Because we specified 1000 as tick time
			 * while creating this CountDownTimer
			 */
			@Override
			public void onTick(long millisUntilFinished) {

			}
		}.start();

	}
}