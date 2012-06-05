package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class LargeDialog {
	private Activity mActivity;
	private final CharSequence[] items = {"会員", "商品"};
	
	public LargeDialog(Activity activity) {
		mActivity = activity;
	}
	
	public Dialog create() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle("Pick a color");
		builder.setItems(items, new DialogInterface.OnClickListener() {
		    public void onClick(DialogInterface dialog, int item) {
		    	
		        Toast.makeText(mActivity.getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
		    }
		});
		return builder.create();
	}
}
