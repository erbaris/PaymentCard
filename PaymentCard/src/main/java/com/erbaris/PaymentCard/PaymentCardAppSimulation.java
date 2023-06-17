package com.erbaris.PaymentCard;


import com.erbaris.PaymentCard.entity.Card;
import org.csystem.util.console.Console;
import org.csystem.util.numeric.NumberUtil;

public class PaymentCardAppSimulation {

	public static void main(String[] args) {
		run();
	}

	public static void run()
	{
		long cardNumber;
		do{
			cardNumber = Console.readLong("Please write Card Number (0 for exit):");

			if(NumberUtil.countDigits(cardNumber) != 16){
				Console.writeLine("This is not 16 digit");
				continue;
			}

			var card = new Card(cardNumber);
			System.out.printf("Card Number %d is %s\n", card.cardNumber, card.isValid() ? "Valid" : "Not Valid");
			System.out.printf("Bankid: %d, Card Type Code: %d, Serial Number: %d\n", card.bankId, card.cardTypeCode, card.cardSerialNumber);
		}while (cardNumber != 0);
	}

}
