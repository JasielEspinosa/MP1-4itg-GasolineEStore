package bank.luhn;

import java.io.IOException;
import bank.exceptions.InvalidCreditCardNumberException;
import gasul.model.*;

public class ProcessLuhn implements InvalidCreditCardNumberException {

	public static boolean cardValid;

	public static UserBean getInstance(String cardNumber) {

		UserBean userBean = new UserBean();

		try {
			double cardNumConvert = Double.parseDouble(cardNumber);
			if (cardNumConvert == 0) {
				cardNumber = ZERO_INPUT_MESSAGE;
			} else if (cardNumConvert < 0) {
				cardNumber = NEGATIVE_INPUT_MESSAGE;
			}
			boolean result = isCreditCardValid(cardNumber);
			printMessage(result);
			if (cardValid == true) {
				cardNumber = maskNumber(cardNumber, "##**********####");
				userBean.setCardNumber(cardNumber);
			} else if (cardValid == false) {
				cardNumber = INVALID_CARD;
				userBean.setCardNumber(cardNumber);
			}
		} catch (StringIndexOutOfBoundsException sioobe) {
		} catch (NumberFormatException nfe) {
		} catch (InterruptedException e) {
		} catch (IOException e) {
		}

		return userBean;

	}

	public static boolean isCreditCardValid(String creditCard) throws InterruptedException, IOException {

		//double cardNumConvert = Double.parseDouble(creditCard);

		int extraChars = creditCard.length() - 16;

/*		if (extraChars < 0) {
			//input is less than 16
			//INSUFFICIENT_INPUT_MESSAGE
		} else if (extraChars > 0) {
			//input is more than 16
			//EXCEEDING_INPUT_MESSAGE
		}*/

		creditCard = creditCard.substring(extraChars, 16 + extraChars);
		int sum = 0;
		for (int i = 0; i < creditCard.length(); i++) {
			char tmp = creditCard.charAt(i);
			int num = tmp - '0';
			int product;
			if (i % 2 != 0) {
				product = num * 1;
			} else {
				product = num * 2;
			}
			if (product > 9)
				product -= 9;
			sum += product;
		}
		return (sum % 10 == 0);
	}

	private static void printMessage(boolean valid) {
		if (valid) {
			cardValid = true;
		} else {
			cardValid = false;
		}
	}

	public static String maskNumber(String number, String mask) {

		int index = 0;
		StringBuilder masked = new StringBuilder();
		for (int i = 0; i < mask.length(); i++) {
			char c = mask.charAt(i);
			if (c == '#') {
				masked.append(number.charAt(index));
				index++;
			} else if (c == '*') {
				masked.append(c);
				index++;
			} else {
				masked.append(c);
			}
		}
		return masked.toString();
	}

}
