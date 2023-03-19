/**
 * Project: COMP2613 - 03 - Lab 03
 * File: Customer.java
 * Date: May 3, 2019
 * Time: 5:22:30 p.m.
 */

package a00820997.data;

import java.time.LocalDate;

import a00820997.data.util.Validator;

/**
 * @author Matthew Simpson / A00820997
 * @date Spring / Summer 2019
 *
 */
public class Customer {

	private long id;
	private String firstName;
	private String lastName;
	private String streetName;
	private String city;
	private String postalCode;
	private String phoneNumber;
	private String emailAddress;
	private LocalDate joinDate;

	public static class Builder {

		private final long id;
		private String firstName;
		private String lastName;
		private String streetName;
		private String city;
		private String postalCode;
		private String phoneNumber;
		private String emailAddress;
		private LocalDate joinDate;

		/**
		 * The builder constructor. requires ID and Phone NUmber to be set.
		 * 
		 * @param id
		 *            - a long
		 *            - the ID to set
		 * @param phoneNumber
		 *            - a string
		 *            - the phone number to set
		 */
		public Builder(long id, String phoneNumber) {
			this.id = id;
			this.phoneNumber = phoneNumber;

		}

		public Builder firstName(String var) {
			if (!var.isEmpty() && var != null) {
				firstName = var;
			}
			return this;
		}

		public Builder lastName(String var) {
			if (!var.isEmpty() && var != null) {
				lastName = var;
			}
			return this;
		}

		public Builder streetName(String var) {
			if (!var.isEmpty() && var != null) {
				streetName = var;
			}
			return this;
		}

		public Builder city(String var) {
			if (!var.isEmpty() && var != null) {
				city = var;
			}
			return this;
		}

		public Builder postalCode(String var) {
			if (!var.isEmpty() && var != null) {
				postalCode = var;
			}
			return this;
		}

		public Builder emailAddress(String var) {
			if (!var.isEmpty() && var != null) {
				emailAddress = var;
			}
			return this;
		}

		public Builder joinDate(LocalDate var) {

			joinDate = var;

			return this;
		}

		public Customer build() {
			return new Customer(this);
		}

	} // builder end ------------------------------------

	/**
	 * Customer Constructor. Use data passed to it from the inner Builder class.
	 * 
	 * @param builder
	 *            - the builder class data
	 */
	private Customer(Builder builder) {
		id = builder.id;
		firstName = builder.firstName;
		lastName = builder.lastName;
		streetName = builder.streetName;
		city = builder.city;
		postalCode = builder.postalCode;
		phoneNumber = builder.phoneNumber;
		emailAddress = builder.emailAddress;
		joinDate = builder.joinDate;

	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", streetName=" + streetName + ", city=" + city
				+ ", postalCode=" + postalCode + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", joinDate=" + joinDate + "]";
	}

	// getters ------------------------------------

	/**
	 * @return the id as a string
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return the firstName as a string
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName as a string
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the streetName as a string
	 */
	public String getStreetName() {
		return streetName;
	}

	/**
	 * @return the city as a string
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the postalCode as a string
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * @return the phoneNumber as a string
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the emailAddress as a string
	 */
	public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * @return the joinDate as a string
	 */
	public LocalDate getJoinDate() {
		return joinDate;
	}

	// getters ------------------------------------

	/**
	 * @param id
	 *            - a string
	 *            - the id to set
	 */
	public void setId(long id) {
		this.id = id;

	}

	/**
	 * @param firstName
	 *            - a string
	 *            - the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (!firstName.isEmpty() && firstName != null) {
			this.firstName = firstName;
		}
	}

	/**
	 * @param lastName
	 *            - a string
	 *            - the lastName to set
	 */
	public void setLastName(String lastName) {
		if (!lastName.isEmpty() && lastName != null) {
			this.lastName = lastName;
		}
	}

	/**
	 * @param streetName
	 *            - a string
	 *            - the streetName to set
	 */
	public void setStreetName(String streetName) {
		if (!streetName.isEmpty() && streetName != null) {
			this.streetName = streetName;
		}
	}

	/**
	 * @param city
	 *            - a string
	 *            - the city to set
	 */
	public void setCity(String city) {
		if (!city.isEmpty() && city != null) {
			this.city = city;
		}
	}

	/**
	 * @param postalCode
	 *            - a string
	 *            - the postalCode to set
	 */
	public void setPostalCode(String postalCode) {
		if (!postalCode.isEmpty() && postalCode != null) {
			this.postalCode = postalCode;
		}
	}

	/**
	 * @param phoneNumber
	 *            - a string
	 *            - the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		if (!phoneNumber.isEmpty() && phoneNumber != null) {
			this.phoneNumber = phoneNumber;
		}
	}

	/**
	 * @param emailAddress
	 *            - a string
	 *            - the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		if (!emailAddress.isEmpty() && emailAddress != null && Validator.checkEmail(emailAddress) == true) {

		}
	}

	/**
	 * @param joinDate
	 *            - a string
	 *            - * the joinDate to set
	 */
	public void setJoinDate(LocalDate joinDate) {
		this.joinDate = joinDate;
	}
}
