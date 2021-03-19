package com.example.coetest.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class Phones {

	private final String number;
	private final String cityCode;
	private final String countryCode;
	
	@JsonCreator
	public Phones(@JsonProperty("number") 
	final String number, 
	@JsonProperty("cityCode") 
	final String cityCode, 
	@JsonProperty("countryCode") 
	final String countryCode) {
		this.number = number;
		this.cityCode = cityCode;
		this.countryCode = countryCode;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cityCode == null) ? 0 : cityCode.hashCode());
		result = prime * result + ((countryCode == null) ? 0 : countryCode.hashCode());
		result = prime * result + ((number == null) ? 0 : number.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Phones other = (Phones) obj;
		if (cityCode == null) {
			if (other.cityCode != null)
				return false;
		} else if (!cityCode.equals(other.cityCode))
			return false;
		if (countryCode == null) {
			if (other.countryCode != null)
				return false;
		} else if (!countryCode.equals(other.countryCode))
			return false;
		if (number == null) {
			if (other.number != null)
				return false;
		} else if (!number.equals(other.number))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Phones [number=" + number + ", cityCode=" + cityCode + ", countryCode=" + countryCode + "]";
	}
	
	
	
}
