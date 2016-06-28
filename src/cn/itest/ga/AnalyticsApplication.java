package cn.itest.ga;

import android.app.Application;
import android.graphics.Typeface;

import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.Tracker;


public class AnalyticsApplication extends Application {
	private Tracker mTracker;
	private Typeface boldFace, reguFace;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		
		
		
	}

	  /**
	   * Gets the default {@link Tracker} for this {@link Application}.
	   * @return tracker
	   */
	synchronized public Tracker getDefaultTracker() {
        if (mTracker == null) {
            GoogleAnalytics analytics = GoogleAnalytics.getInstance(this);
            // To enable debug logging use: adb shell setprop log.tag.GAv4 DEBUG
            mTracker = analytics.newTracker(R.xml.analytics);
        }
        return mTracker;
    }
	
	/**
	 * 2016/3/1 设置字体的两个方法，对于不同的View采用了方法的重载
	 * 
	 * @param txt
	 */
	synchronized public Typeface getBoldTypeface() {
		if(boldFace == null){
			boldFace = Typeface.createFromAsset(getAssets(),
				"fonts/TradeGothicLTStd-Bd2.otf");
		}
		return boldFace;
	}
	synchronized public Typeface getReguTypeface() {
		if(reguFace == null){
			reguFace = Typeface.createFromAsset(getAssets(),
					"fonts/TradeGothicLTStd.otf");
		}
		return reguFace;
	}

}
