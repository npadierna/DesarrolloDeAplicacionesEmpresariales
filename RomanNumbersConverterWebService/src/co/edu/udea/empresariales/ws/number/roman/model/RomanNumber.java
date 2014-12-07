package co.edu.udea.empresariales.ws.number.roman.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(value = XmlAccessType.PROPERTY)
public class RomanNumber implements Serializable {

	private static final long serialVersionUID = 1890600408074571488L;

	private Integer decimalNumber;
	private String romanNumber;

	public RomanNumber() {
		this(null, null);
	}

	public RomanNumber(Integer decimalNumber, String romanNumber) {
		this.setDecimalNumber(decimalNumber);
		this.setRomanNumber(romanNumber);
	}

	public Integer getDecimalNumber() {

		return (this.decimalNumber);
	}

	public void setDecimalNumber(Integer decimalNumber) {
		this.decimalNumber = decimalNumber;
	}

	public String getRomanNumber() {

		return (this.romanNumber);
	}

	public void setRomanNumber(String romanNumber) {
		this.romanNumber = romanNumber;
	}

	@Override()
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime
				* result
				+ ((this.getDecimalNumber() == null) ? 0 : this
						.getDecimalNumber().hashCode());
		result = prime
				* result
				+ ((this.getRomanNumber() == null) ? 0 : this.getRomanNumber()
						.hashCode());

		return (result);
	}

	@Override()
	public boolean equals(Object obj) {
		if (this == obj) {

			return (true);
		}

		if (obj == null) {

			return (false);
		}

		if (getClass() != obj.getClass()) {

			return (false);
		}

		RomanNumber other = (RomanNumber) obj;
		if (this.getDecimalNumber() == null) {
			if (other.getDecimalNumber() != null) {

				return (false);
			}
		} else if (!this.getDecimalNumber().equals(other.getDecimalNumber())) {

			return false;
		}

		if (this.getRomanNumber() == null) {
			if (other.getRomanNumber() != null) {

				return false;
			}
		} else if (!this.getRomanNumber().equals(other.getRomanNumber())) {

			return (false);
		}

		return (true);
	}

	@Override()
	public String toString() {

		return ("RomanNumber [decimalNumber=" + this.getDecimalNumber()
				+ ", romanNumber=" + this.getRomanNumber() + "]");
	}
}