/*
 * Copyright 2017 the original author or authors.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.openehealth.ipf.commons.audit.types;

/**
 * The Audit Source Type values specify the type of source where an event originated.
 * Codes from coded terminologies and implementation defined codes can also be used for the
 * AuditSource.
 *
 * @author Christian Ohr
 * @since 3.5
 */
public interface AuditSource extends CodedValueType {

    static AuditSource of(String code, String codeSystemName, String originalText) {
        return new AuditSourceImpl(code, codeSystemName, originalText);
    }

    static AuditSource of(CodedValueType codedValueType) {
        return new AuditSourceImpl(codedValueType);
    }

    class AuditSourceImpl extends CodedValueTypeImpl implements AuditSource {
        public AuditSourceImpl(String code, String codeSystemName, String originalText) {
            super(code, codeSystemName, originalText);
        }
        public AuditSourceImpl(CodedValueType codedValueType) {
            super(codedValueType);
        }
    }
}
