# PaymentCard
PaymentCard


Case:
Most payment card numbers are 16 digits long. The leftmost 6 digits represent a unique identification number for the bank who has issued the card. The next 2 digits determine the type of the card (e.g., debit, credit, gift). Digits 9 to 15 are the serial number of the card, and the last digit is used as a control digit to verify whether the card number is valid. Hence, if somebody enters the card number incorrectly, there is a high chance that a payment software can easily determine it. 

Algorithm:

1.Double every second digit from right to left. If this “doubling” results in a two-digit number, subtract 9 from it get a single digit.

2.Now add all single digit numbers from step 1.

3.Add all digits in the odd places from right to left in the credit card number.

4.Sum the results from steps 2 & 3.

5.If the result from step 4 is divisible by 10, the card number is valid; otherwise, it is invalid.


Test Inputs:

4556 7375 8689 9855

4024 0071 0902 2143

Your task is to read several card numbers from the input, and determine whether each one is a valid card number or not.
