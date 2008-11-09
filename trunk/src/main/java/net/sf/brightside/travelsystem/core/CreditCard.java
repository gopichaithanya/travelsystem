package net.sf.brightside.travelsystem.core;

import net.sf.brightside.travelsystem.core.beans.CreditCardType;

public interface CreditCard {

	public abstract CreditCardType getCreditCardType();

	public abstract void setCreditCardType(CreditCardType creditCardType);

	public abstract String getCardNumber();

	public abstract void setCardNumber(String cardNumber);

	public abstract String getCardVerificationCode();

	public abstract void setCardVerificationCode(String cardVerificationCode);

	public abstract String getNameOnCard();

	public abstract void setNameOnCard(String nameOnCard);

}