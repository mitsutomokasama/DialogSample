package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.widget.Toast;

public class SmallDialog2 {
	private Activity mActivity;
	private final CharSequence[] items = {"Red", "Green", "Blue"};
	
	public SmallDialog2(Activity activity) {
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
