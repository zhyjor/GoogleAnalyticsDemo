package cn.itest.ga;


import android.app.Activity;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.analytics.Tracker;

public class MainActivity extends Activity {
	private Button bn;
	private TextView tv;
	private Tracker mTracker;
	private AnalyticsApplication application;
	private Typeface boldFace, reguFace;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		bn = (Button) findViewById(R.id.any_bn);
		tv = (TextView) findViewById(R.id.hw_tv);
		
		
		
		
		application = (AnalyticsApplication) this.getApplication();
		mTracker = application.getDefaultTracker();
		
		 mTracker.setScreenName("Image~");
	        mTracker.send(new HitBuilders.ScreenViewBuilder().build());
		
		setTextFontImWay(tv);
		setTextFontImWay(bn);
		
		//获取代理
//		MyInvocationHandler handler = new MyInvocationHandler(bn);
//		
//		Button proxy = (Button) Proxy.newProxyInstance(bn.getClass()
//				.getClassLoader(), bn.getClass().getInterfaces(), handler);
		
		
		
//		Enhancer en = new Enhancer();
//	       en.setSuperclass(Button.class);
//
//	       en.setCallback(new MethodInterceptor() {
//
//	          
//			
//			@Override
//			public Object intercept(Object arg0, java.lang.reflect.Method arg1,
//					Object[] arg2, MethodProxy arg3) throws Throwable {
//				Object o = arg1.invoke(bn,arg2);
//
//	              System.err.println("After...");
//
//	              return o;
//			}
//
//	       });
//
//	       Button p = (Button) en.create();       
	      
		
		
		
		bn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// [START custom_event]
		        mTracker.send(new HitBuilders.EventBuilder()
		            .setCategory("Action")
		            .setAction("ButtonPress").setLabel("Edit")
		            .build());
		        // [END custom_event]
		        
		        setTextReguFontImWay(tv);
		        setTextReguFontImWay(bn);
			}
		});
		
	}
	
	/**
	 * 2016/3/1 设置字体的两个方法，对于不同的View采用了方法的重载
	 * 
	 * @param txt
	 */
	private void setTextFontImWay(TextView txt) {
		boldFace = application.getBoldTypeface();
		txt.setTypeface(boldFace);
	}
	private void setTextReguFontImWay(TextView txt) {
		reguFace = application.getReguTypeface();
		txt.setTypeface(reguFace);
	}
	/**
	 * 2016/3/1 设置字体的两个方法，对于不同的View采用了方法的重载
	 * 
	 * @param bn
	 */
	private void setTextFontImWay(Button bn) {
		boldFace = application.getBoldTypeface();
		bn.setTypeface(boldFace);
	}
	private void setTextReguFontImWay(Button bn) {
		reguFace = application.getReguTypeface();
		bn.setTypeface(reguFace);
	}

	
}
