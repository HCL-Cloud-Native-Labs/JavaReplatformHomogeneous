package com.presto.banking.dateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DataFormatUtil {

	public String getDateFormatted(Calendar calendar, Date dateVal) {
		SimpleDateFormat format = new SimpleDateFormat("MMM-d yyyy hh:mm aaa");
		return format.format(dateVal);
	}
}
