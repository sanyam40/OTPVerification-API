package com.boot.controller;

import java.io.IOException;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot.entity.User;
import com.boot.service.EmailService;
import com.boot.service.SmsService;
import com.boot.service.UserService;

@Controller
public class MainController {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private SmsService smsService;

	public static String Email;

	Random random = new Random();
	int otp_temp;

	@RequestMapping("/")
	public String login() {
		return "login-page";
	}

	@RequestMapping("/formData")
	public String otpPage(@RequestParam("email") String email, @RequestParam("Password") String password) {
		User test = new User();
		Email = email;
		test.setUsername(email);
		test.setPassword(password);

		if (test.getUsername().equals(userService.user.getUsername())
				&& test.getPassword().equals(userService.user.getPassword())) {
			System.out.println("matched");
			return "otp-page";
		} else {
			return "login-page";
		}
	}

	@RequestMapping("/otp-verify")
	public String otpVerify() throws IOException {

		int otp = random.nextInt(9999);
		otp_temp = otp;

		smsService.sendSMS("Otp For Verification Is " + otp, "9017794903");
		Boolean a = emailService.sendEmail("OTP FOR VERIFICATION", "Otp For Verification Is " + otp, Email);
		if (a) {
			System.out.println("otp sent ");
		}

		return "otp-verify";
	}

	@RequestMapping("/otp-match")
	@ResponseBody
	public String otpMatcher(@RequestParam("OTP") int otp_filled) {
		System.out.println(otp_filled);
		System.out.println(otp_temp);

		if (otp_filled == otp_temp) {
			userService.user.setVerification("VERIFIED");
			return "verified";
		} else {
			return "not verified";
		}
	}
}
