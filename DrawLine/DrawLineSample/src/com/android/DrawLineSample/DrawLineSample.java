package com.android.DrawLineSample;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class DrawLineSample extends Activity {
    /** Called when the activity is first created. */
    protected Button exit;
    protected Spinner spinner1;
    protected Spinner spinner2;
    protected TextView t;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

        LinearLayout layout=(LinearLayout) findViewById(R.id.leaf2);
		final TestView view=new TestView(this);
        view.setMinimumHeight(500);
        view.setMinimumWidth(300);
        view.invalidate();  
        layout.addView(view);
        
        exit = (Button) findViewById(R.id.save);
		spinner1 = (Spinner) findViewById(R.id.spinner1);
		spinner2 = (Spinner) findViewById(R.id.spinner2);
		t = (TextView) findViewById(R.id.textView1);
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        		view.setPenColor((String) spinner1.getSelectedItem());
            }
            @Override  
            public void onNothingSelected(AdapterView<?> parent) {  
                // TODO Auto-generated method stub  
                  
            }  
        });
		
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View v, int pos, long id) {
        		view.setBackColor((String) spinner2.getSelectedItem());
            }
            @Override  
            public void onNothingSelected(AdapterView<?> parent) {  
                // TODO Auto-generated method stub  
                  
            }  
        });
		
		exit.setOnClickListener(new View.OnClickListener() {  
            @Override  
            public void onClick(View arg0) {
				System.exit(0);
            }  
        });  
    }
}