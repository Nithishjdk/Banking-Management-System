package com.jsp.bank_management_system.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int addressId;
	private int addressPlotNumber;
	private String addressArea;
	private String addressCity;
	private int addressPinCode;
	private String addressState;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}

	public int getAddressPlotNumber() {
		return addressPlotNumber;
	}

	public void setAddressPlotNumber(int addressPlotNumber) {
		this.addressPlotNumber = addressPlotNumber;
	}

	public String getAddressArea() {
		return addressArea;
	}

	public void setAddressArea(String addressArea) {
		this.addressArea = addressArea;
	}

	public String getAddressCity() {
		return addressCity;
	}

	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	public int getAddressPinCode() {
		return addressPinCode;
	}

	public void setAddressPinCode(int addressPinCode) {
		this.addressPinCode = addressPinCode;
	}

	public String getAddressState() {
		return addressState;
	}

	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

}
