package com.android.binaryconverter;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class BinaryConverter extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Button btconvert = (Button) findViewById(R.button.ButtonConvert);
        
        btconvert.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				RadioGroup options = (RadioGroup) findViewById(R.radiogroup.ConvertOptions);
				
				int selectedOption = options.getCheckedRadioButtonId();
				int base = 10, temp;
				Integer rest = 1;
				String valueToShow = "";
				try
				{
					EditText valueTyped = (EditText) findViewById(R.field.number);
					EditText result = (EditText) findViewById(R.field.Result);
					
					if(valueTyped.getText().toString().length() > 10)
						throw new IllegalArgumentException();
					
					temp = Integer.parseInt(valueTyped.getText().toString());
					
					switch(selectedOption)
					{
						case R.option.RadioButtonBinary:
							base = 2;
						break;
						
						case R.option.RadioButtonHex:
							base = 16;
						break;
						
						case R.option.RadioButtonOct:
							base = 8;
						break;
					}				
					
					while(temp != 0)
					{
						rest = temp % base;
						temp  = (int) (temp/base);
						
						if(base == 2)
						{
							valueToShow += Integer.toBinaryString(rest);
						}
						else if(base == 16)
						{
							valueToShow += Integer.toHexString(rest);
						}
						else if(base == 8)
						{
							valueToShow += Integer.toOctalString(rest);
						}
						
					}
					char charValue[] = valueToShow.toCharArray();
					String tmp = "";
		
					for(int i = valueToShow.length()-1; i >=0 ;i--)
					{
						tmp += (String.valueOf(charValue[i]));
					}
					
					result.setText(String.valueOf(tmp));
				}
				catch(IllegalArgumentException e)
				{
					e.getMessage();
				}
				
			}
		});
    }
    
    
    
}