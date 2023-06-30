package com.boot.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.stereotype.Service;

@Service
public class SmsService {

	public void sendSMS(String message, String no) throws IOException {

		try {
			String apikey = "i2er7sSZCHVyUJchdlkX6nfDMpuo5bIaOx3Q8Ew4PWBtNY9FGKvm7w2CLuqKxnlrREI8hTi6MVe3WtYN";
			String sendId = "FSTSMS";
			String language = "english";
			String route = "p";

			// String
			// url="https://www.fast2sms.com/dev/bulkV2?authorization="+apikey+"&variables_values=5599&route=otp&numbers=9999999999,8888888888,7777777777\"";
			String myUrl = "https://www.fast2sms.com/dev/bulk?authorization=" + apikey + "&sender_id=" + sendId
					+ "&message=" + message + "&language=" + language + "&route=" + route + "&numbers=" + no;

			URL url = new URL(myUrl);
			HttpsURLConnection con = (HttpsURLConnection) url.openConnection();

			con.setRequestMethod("GET");
			con.setRequestProperty("cache-control", "no-cache");
			System.out.println("Wait..............");

			int code = con.getResponseCode();

			System.out.println("Response code : " + code);

			StringBuffer response = new StringBuffer();

			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream()));

			while (true) {
				String line = br.readLine();
				if (line == null) {
					break;
				}
				response.append(line);
			}

			System.out.println(response);

			message = URLEncoder.encode(message, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
