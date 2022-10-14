package com.presto.banking.datagram;

public class PrestoCaseTest {

	public static boolean checkLetter() {
		char ch1securityCode = 'A';
		char ch2securityDecoderAcronym = 'a';

		boolean b1 = Character.isUpperCase(ch1securityCode);
		boolean b2 = Character.isLowerCase(ch2securityDecoderAcronym);

		System.out.println(b1);
		System.out.println(b2);
		
		return b1 && b2;
		
	}

}
