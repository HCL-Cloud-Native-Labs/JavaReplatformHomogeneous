package com.presto.banking.datagram;

import java.util.Formatter;
import java.util.Locale;

public class PrestoDataUtil {

	public void formatterDoesNotFormatNumbers1() throws Exception {
		Formatter frm = new Formatter();
		String result = frm.format("%#s", null).toString();

		System.out.println(result);

	}

	public void formatterDoesNotFormatNumbers() throws Exception {
		Formatter frm = new Formatter();
		Locale l = new Locale("jjj");
		Object[] args = { "dsdsd", "edewe", "sdsdwsd" };
		String result = frm.format("%@s", "cat").toString();
		String ff = String.format("%#s", "apple").toString();
		System.out.println(ff);
		String f1 = String.format(l, "%#s", args);
		String f2 = frm.format(l, "%#s", args).toString();
		System.out.println(result);

		// String result = new Formatter().format("%1$#8s", 15).toString();
		// Assert.assertThat(result, is(" 15"));
	}

	public static void utilsFormat() throws Exception {
		PrestoDataUtil utils = new PrestoDataUtil();
		utils.formatterDoesNotFormatNumbers();
		// utils.formatterDoesNotFormatNumbers();
	}
}
