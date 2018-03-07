package bank.exceptions;

public interface InvalidCreditCardNumberException {

	String VALID_CARD = "Your credit card submitted is VALID.";
	String INVALID_CARD = "Unauthorized use! Your input of card number is INVALID. "
			+ "<br/>For an invalid card reading, your order will not be calculated nor purchased, datas will not be injected to the database.";

	String NON_DIGIT_INPUT = "   Input invalid. Please enter digits only. ";

	String ZERO_INPUT_MESSAGE = "   Zero input is invalid! ";
	String NEGATIVE_INPUT_MESSAGE = "   Negative input is invalid! ";

	String INSUFFICIENT_INPUT_MESSAGE = "   You typed less than 16 digits, this credit card may be ILLEGAL! ";
	String EXCEEDING_INPUT_MESSAGE = "   You typed more than 16 digits, this credit card may be ILLEGAL! ";

	String WARNING_INPUT_MESSAGE_1 = "   Too much input may lead to an invalid card number. ";
	String WARNING_INPUT_MESSAGE_2 = "	  Too much input may lead to a card number error. ";

	String RESWIPE_MESSAGE = "   You may have to swipe your card again to verify properly. ";
	String RESET_CARD_NUMBER_MESSAGE = "   You may have to reset your transaction in order to verify your card properly. ";
	String FORCE_RESET_CARD_NUMBER_MESSAGE = "   We will reset the transaction in order to verify your card properly. ";
	
	String NO_PRICE_MSG_1 = "---";
	String NO_PRICE_MSG_2 = "walang halaga";

}
