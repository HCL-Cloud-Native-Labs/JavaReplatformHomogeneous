package com.presto.banking.dateUtil;

import java.util.GregorianCalendar;

import javax.xml.datatype.XMLGregorianCalendar;

public class PrestoDateModifier {

	public static void changeDateFormat() throws Exception {
		GregorianCalendar gcal = new GregorianCalendar();
		XMLGregorianCalendar xgcal = /*
										 * DatatypeFactory.newInstance() .newXMLGregorianCalendar(gcal);
										 */ null;

		try {
			xgcal.equals(gcal);
			
		} catch (NullPointerException e) {
			
		}
	}

}