package net.sf.brightside.travelsystem.core.beans;

import net.sf.brightside.travelsystem.core.CreditCard;

public class CreditCardBean implements CreditCard {

	private CreditCardType creditCardType;

	private String cardNumber;

	private String cardVerificationCode;

	private String nameOnCard;

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#getCreditCardType()
	 */
	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#setCreditCardType(net.sf.brightside.travelsystem.core.beans.CreditCardType)
	 */
	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#getCardNumber()
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#setCardNumber(java.lang.String)
	 */
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#getCardVerificationCode()
	 */
	public String getCardVerificationCode() {
		return cardVerificationCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#setCardVerificationCode(java.lang.String)
	 */
	public void setCardVerificationCode(String cardVerificationCode) {
		this.cardVerificationCode = cardVerificationCode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#getNameOnCard()
	 */
	public String getNameOnCard() {
		return nameOnCard;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see net.sf.brightside.travelsystem.core.beans.CreditCard#setNameOnCard(java.lang.String)
	 */
	public void setNameOnCard(String nameOnCard) {
		this.nameOnCard = nameOnCard;
	}

}
