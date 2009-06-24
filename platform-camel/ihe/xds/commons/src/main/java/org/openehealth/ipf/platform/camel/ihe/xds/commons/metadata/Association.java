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
 * Represents an association between two documents.
 * @author Jens Riemschneider
 */
public class Association {
    private String targetUUID;
    private String sourceUUID;
    private AssociationType associationType;

    public String getTargetUUID() {
        return targetUUID;
    }

    public void setTargetUUID(String targetUUID) {
        this.targetUUID = targetUUID;
    }

    public String getSourceUUID() {
        return sourceUUID;
    }
    
    public void setSourceUUID(String sourceUUID) {
        this.sourceUUID = sourceUUID;
    }
    
    public AssociationType getAssociationType() {
        return associationType;
    }

    public void setAssociationType(AssociationType associationType) {
        this.associationType = associationType;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((associationType == null) ? 0 : associationType.hashCode());
        result = prime * result + ((sourceUUID == null) ? 0 : sourceUUID.hashCode());
        result = prime * result + ((targetUUID == null) ? 0 : targetUUID.hashCode());
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
        Association other = (Association) obj;
        if (associationType == null) {
            if (other.associationType != null)
                return false;
        } else if (!associationType.equals(other.associationType))
            return false;
        if (sourceUUID == null) {
            if (other.sourceUUID != null)
                return false;
        } else if (!sourceUUID.equals(other.sourceUUID))
            return false;
        if (targetUUID == null) {
            if (other.targetUUID != null)
                return false;
        } else if (!targetUUID.equals(other.targetUUID))
            return false;
        return true;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
