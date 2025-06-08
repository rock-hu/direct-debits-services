package com.openbanking.direct.debits.model;

/**
 * Specifies the status of the direct debit in code form.
 */
public enum OBExternalDirectDebitStatus1Code {
	ACTIVE("Active"), INACTIVE("Inactive");

	private String value;

	OBExternalDirectDebitStatus1Code(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	public static OBExternalDirectDebitStatus1Code fromValue(String text) {
		for (OBExternalDirectDebitStatus1Code b : OBExternalDirectDebitStatus1Code.values()) {
			if (String.valueOf(b.value).equals(text)) {
				return b;
			}
		}
		return null;
	}
}
