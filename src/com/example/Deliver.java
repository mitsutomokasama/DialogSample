package com.example;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.speech.RecognizerIntent;
import android.widget.Toast;

public class Deliver {
	private static final String[] largeItems = { "会員", "商品" };
	private static final String[] smallItems = { "アイテム１", "アイテム２" };
	private static final String[] smallItems2 = { "アイテム１", "アイテム２" };
	private static int largeItemIndex;
	private static int smallItemIndex;
	private static int smallItemIndex2;
	private static String largeItemName;
	private static String smallItemName;
	private static String smallItemName2;
	private static Activity mActivity;

	public static final int REQUEST_CODE = 1000;
	private static Deliver instance = new Deliver();

	private Deliver() {
	}

	public static Deliver getInstance() {
		return instance;
	}

	public static void setActivity(Activity activity) {
		mActivity = activity;
	}

	public static int getLargeItemIndex() {
		return largeItemIndex;
	}

	public static Dialog largeDialogCreate() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle("Pick a color");
		builder.setItems(largeItems, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				largeItemIndex = item;
				largeItemName = largeItems[item];
				switch (item) {
				case 0:
					mActivity.showDialog(2);
					break;
				case 1:
					mActivity.showDialog(3);
					break;
				}
			}
		});
		return builder.create();
	}

	public static Dialog createSmallDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle("Pick a color");
		builder.setItems(smallItems, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				smallItemIndex = item;
				smallItemName = smallItems[item];
				speechDialogCreate(mActivity, smallItems[item]);
			}
		});
		return builder.create();
	}

	public static Dialog createSmallDialog2() {
		AlertDialog.Builder builder = new AlertDialog.Builder(mActivity);
		builder.setTitle("Pick a color");
		builder.setItems(smallItems2, new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int item) {
				smallItemIndex2 = item;
				smallItemName2 = smallItems2[item];
				speechDialogCreate(mActivity, smallItems2[item]);

			}
		});
		return builder.create();
	}

	public static void speechDialogCreate(Activity activity, String extra) {
		// インテント作成
		Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH); // ACTION_WEB_SEARCH
		intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
				RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
		intent.putExtra(RecognizerIntent.EXTRA_PROMPT, extra); // お好きな文字に変更できます

		// インテント発行
		activity.startActivityForResult(intent, REQUEST_CODE);
	}

	public static String setSmallJs(String str) {
		String result = "";
		if (smallItems[0].equals(smallItemName)) {
			result = smallItemName + " : " + str;
		} else if (smallItems[1].equals(smallItemName)) {
			result = smallItemName + " : " + str;
		}
		return result;
	}

	public static String setSmall2Js(String str) {
		String result = "";
		if (smallItems2[0].equals(smallItemName2)) {
			result = smallItemName2 + " : " + str;
		} else if (smallItems2[1].equals(smallItemName2)) {
			result = smallItemName2 + " : " + str;
		}
		return result;
	}
}
