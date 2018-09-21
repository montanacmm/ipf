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

package org.openehealth.ipf.commons.audit.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;

import static java.util.Objects.requireNonNull;

/**
 * The ValuePair is used in {@link ParticipantObjectIdentificationType} descriptions to capture
 * parameters.
 * All values (even those that are normally plain text) are encoded as Base64.
 * This is to preserve details of encoding (e.g., nulls) and to protect against text
 * contents that contain XML fragments. These are known attack points against applications,
 * so security logs can be expected to need to capture them without modification by the
 * audit encoding process.
 *
 * @author Christian Ohr
 * @since 3.5
 */
@EqualsAndHashCode
public class TypeValuePairType implements Serializable {

    @Getter
    private final String type;

    @Getter
    private final byte[] value;

    /**
     * Creates an instance
     *
     * @param type  type
     * @param value value string, NOT yet base64 encoded
     */
    public TypeValuePairType(String type, String value) {
        this(type, value, null);
    }

    /**
     * Creates an instance
     *
     * @param type  type
     * @param value value string, NOT yet base64 encoded
     * @param defaultValue default value string used when value is null, NOT yet base64 encoded
     */
    public TypeValuePairType(String type, String value, String defaultValue) {
        this(type,
                value != null ? value.getBytes(StandardCharsets.UTF_8) : null,
                defaultValue != null ? defaultValue.getBytes(StandardCharsets.UTF_8) : null);
    }

    /**
     * Creates an instance
     *
     * @param type  type
     * @param value value byte array, NOT yet base64 encoded
     */
    public TypeValuePairType(String type, byte[] value) {
        this(type, value, null);
    }

    /**
     * Creates an instance
     *
     * @param type  type
     * @param value value byte array, NOT yet base64 encoded
     * @param defaultValue default value byte array used when value is null, NOT yet base64 encoded
     */
    public TypeValuePairType(String type, byte[] value, byte[] defaultValue) {
        this.type = requireNonNull(type, "Type of TypeValuePairType must not be null");
        this.value = requireNonNull(value != null ? value : defaultValue, "Value of TypeValuePairType must not be null");
    }
}
