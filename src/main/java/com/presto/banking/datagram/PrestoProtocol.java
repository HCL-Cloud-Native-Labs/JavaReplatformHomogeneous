package com.presto.banking.datagram;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PrestoProtocol {

	private static final String GET_URL = null;

	private static void sendGET() throws IOException {

		URL obj = new URL(GET_URL);

		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		// con.setRequestProperty("User-Agent", USER_AGENT);
		int responseCode = con.getResponseCode();
		System.out.println("GET Response Code :: " + responseCode);
		if (responseCode == HttpURLConnection.HTTP_OK) { // success
			// BufferedReader in = new BufferedReader(new
			// InputStreamReader(con.getInputStream()));

			InputStream in = con.getInputStream();

			StringBuffer response = new StringBuffer();
			in.close();
			System.out.println(response.toString());
		} else {
			System.out.println("GET request not worked");
		}

	}

}
