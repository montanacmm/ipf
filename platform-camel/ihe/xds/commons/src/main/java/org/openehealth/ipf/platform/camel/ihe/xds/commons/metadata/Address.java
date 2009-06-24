/*
 * Copyright 2009 the original author or authors.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *     
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.openehealth.ipf.platform.camel.ihe.xds.commons.metadata;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Represents the address of a patient.
 * <p>
 * This class contains a subset of the fields from the HL7v2.5 XAD data type.
 * @author Jens Riemschneider
 */
public class Address {
    private String streetAddress;               // XAD.1  
    private String otherDesignation;            // XAD.2  
    private String city;                        // XAD.3  
    private String stateOrProvince;             // XAD.4  
    private String zipOrPostalCode;             // XAD.5  
    private String country;                     // XAD.6  
    private String countyParishCode;            // XAD.9  
    
    public String getStreetAddress() {
        return streetAddress;
    }
    
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }
    
    public String getOtherDesignation() {
        return otherDesignation;
    }
    
    public void setOtherDesignation(String otherDesignation) {
        this.otherDesignation = otherDesignation;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getStateOrProvince() {
        return stateOrProvince;
    }
    
    public void setStateOrProvince(String stateOrProvince) {
        this.stateOrProvince = stateOrProvince;
    }
    
    public String getZipOrPostalCode() {
        return zipOrPostalCode;
    }
    
    public void setZipOrPostalCode(String zipOrPostalCode) {
        this.zipOrPostalCode = zipOrPostalCode;
    }
    
    public String getCountry() {
        return country;
    }
    
    public void setCountry(String country) {
        this.country = country;
    }
    
    public String getCountyParishCode() {
        return countyParishCode;
    }

    public void setCountyParishCode(String countyParishCode) {
        this.countyParishCode = countyParishCode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((city == null) ? 0 : city.hashCode());
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((countyParishCode == null) ? 0 : countyParishCode.hashCode());
        result = prime * result + ((otherDesignation == null) ? 0 : otherDesignation.hashCode());
        result = prime * result + ((stateOrProvince == null) ? 0 : stateOrProvince.hashCode());
        result = prime * result + ((streetAddress == null) ? 0 : streetAddress.hashCode());
        result = prime * result + ((zipOrPostalCode == null) ? 0 : zipOrPostalCode.hashCode());
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
        Address other = (Address) obj;
        if (city == null) {
            if (other.city != null)
                return false;
        } else if (!city.equals(other.city))
            return false;
        if (country == null) {
            if (other.country != null)
                return false;
        } else if (!country.equals(other.country))
            return false;
        if (countyParishCode == null) {
            if (other.countyParishCode != null)
                return false;
        } else if (!countyParishCode.equals(other.countyParishCode))
            return false;
        if (otherDesignation == null) {
            if (other.otherDesignation != null)
                return false;
        } else if (!otherDesignation.equals(other.otherDesignation))
            return false;
        if (stateOrProvince == null) {
            if (other.stateOrProvince != null)
                return false;
        } else if (!stateOrProvince.equals(other.stateOrProvince))
            return false;
        if (streetAddress == null) {
            if (other.streetAddress != null)
                return false;
        } else if (!streetAddress.equals(other.streetAddress))
            return false;
        if (zipOrPostalCode == null) {
            if (other.zipOrPostalCode != null)
                return false;
        } else if (!zipOrPostalCode.equals(other.zipOrPostalCode))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
