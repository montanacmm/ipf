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

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 * Represents the human or machine that created an entry.
 * 
 * @author Jens Riemschneider
 */
public class Author {
    private Person authorPerson;
    private final List<String> authorInstitution = new ArrayList<String>();
    private final List<String> authorRole = new ArrayList<String>(); 
    private final List<String> authorSpecialty = new ArrayList<String>();

    /**
     * @return basic information about the author.
     */
    public Person getAuthorPerson() {
        return authorPerson;
    }
    
    /**
     * @param authorPerson
     *          basic information about the author.
     */
    public void setAuthorPerson(Person authorPerson) {        
        this.authorPerson = authorPerson;
    }

    /**
     * @return the list of author institutions. Never <code>null</code>, but
     *          can be empty. 
     */
    public List<String> getAuthorInstitution() {
        return authorInstitution;
    }
    
    /**
     * @return the list of author roles. Never <code>null</code>, but
     *          can be empty. 
     */
    public List<String> getAuthorRole() {
        return authorRole;
    }
    
    /**
     * @return the list of author specialties. Never <code>null</code>, but
     *          can be empty. 
     */
    public List<String> getAuthorSpecialty() {
        return authorSpecialty;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((authorInstitution == null) ? 0 : authorInstitution.hashCode());
        result = prime * result + ((authorPerson == null) ? 0 : authorPerson.hashCode());
        result = prime * result + ((authorRole == null) ? 0 : authorRole.hashCode());
        result = prime * result + ((authorSpecialty == null) ? 0 : authorSpecialty.hashCode());
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
        Author other = (Author) obj;
        if (authorInstitution == null) {
            if (other.authorInstitution != null)
                return false;
        } else if (!authorInstitution.equals(other.authorInstitution))
            return false;
        if (authorPerson == null) {
            if (other.authorPerson != null)
                return false;
        } else if (!authorPerson.equals(other.authorPerson))
            return false;
        if (authorRole == null) {
            if (other.authorRole != null)
                return false;
        } else if (!authorRole.equals(other.authorRole))
            return false;
        if (authorSpecialty == null) {
            if (other.authorSpecialty != null)
                return false;
        } else if (!authorSpecialty.equals(other.authorSpecialty))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
