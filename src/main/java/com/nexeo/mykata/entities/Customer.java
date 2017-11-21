package com.nexeo.mykata.entities;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class Customer {

	private String name;
	private String lastName;
	private Integer age;
	private String address;

	private Customer(CustomerBuilder builder) {
		this.name = builder.name;
		this.lastName = builder.lastName;
		this.age = builder.age;
		this.address = builder.address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public static class CustomerBuilder {

		private String name;
		private String lastName;
		private Integer age;
		private String address;

		public CustomerBuilder() {
		}

		public CustomerBuilder withName(String name) {
			this.name = name;
			return this;
		}

		public CustomerBuilder withLastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public CustomerBuilder withAge(Integer age) {
			this.age = age;
			return this;
		}

		public CustomerBuilder withAddress(String address) {
			this.address = address;
			return this;
		}

		public Customer build() {
			return new Customer(this);
		}
	}

}
