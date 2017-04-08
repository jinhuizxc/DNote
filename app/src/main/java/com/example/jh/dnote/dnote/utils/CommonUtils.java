package com.example.jh.dnote.dnote.utils;



import com.example.jh.dnote.dnote.activity.MainActivity;
import com.example.jh.dnote.dnote.data.ConstantData;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;


public class CommonUtils {
	
	public static Stack stack = new Stack();
	
	public static void doFinish(MainActivity mainActivity)
	{
		if(stack.isEmpty())
		{
			mainActivity.finish();
		}
		else
		{
			switch ((Integer)stack.peek()) {
			case ConstantData.DELETE_DIALOG:
				mainActivity.hideDeleteDialog(null);
				break;
			case ConstantData.INFOR_DIALOG:
				mainActivity.hideInfoDialog(null);
				break;
			case ConstantData.SEND_DIALOG:
				mainActivity.hideSendDialog(null);
				break;
			case ConstantData.EDIT_STATE:
				mainActivity.backToList(null);
				break;
			default:
				break;
			}
		}
		
	}
	
	public static String getDate()
	{
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(date);
		
	}
}
