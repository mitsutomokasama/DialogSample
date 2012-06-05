package com.example;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.widget.Toast;

public class DialogSampleActivity extends Activity {
	Deliver deliver;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		Deliver.setActivity(this);
		deliver = Deliver.getInstance();
		
		showDialog(1);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// 自分が投げたインテントであれば応答する
		if (requestCode == Deliver.REQUEST_CODE && resultCode == RESULT_OK) {
			String resultsString = "";

			// 結果文字列リスト
			ArrayList<String> results = data
					.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);

			// for (int i = 0; i< results.size(); i++) {
			// // ここでは、文字列が複数あった場合に結合しています
			// resultsString += results.get(i);
			// }

			switch (Deliver.getLargeItemIndex()) {
			case 0:
				resultsString = Deliver.setSmallJs(results.get(0));
				Toast.makeText(this, "会員: " + resultsString, Toast.LENGTH_LONG).show();
				break;
			case 1:
				resultsString = Deliver.setSmall2Js(results.get(0));
				Toast.makeText(this, "商品: " + resultsString, Toast.LENGTH_LONG).show();
				break;
			}
			
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	protected Dialog onCreateDialog(int id) {
		switch (id) {
		case 1:
			return Deliver.largeDialogCreate();
		case 2:
			return Deliver.createSmallDialog();
		case 3:
			return Deliver.createSmallDialog2();
		}
		return null;

		// AlertDialog.Builder builder = new AlertDialog.Builder(this);
		// builder.setMessage("Are you sure you want to exit?")
		// .setCancelable(false)
		// .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
		// public void onClick(DialogInterface dialog, int id) {
		// DialogSampleActivity.this.finish();
		// }
		// })
		// .setNegativeButton("No", new DialogInterface.OnClickListener() {
		// public void onClick(DialogInterface dialog, int id) {
		// dialog.cancel();
		// }
		// });
		// return builder.create();
	}
}