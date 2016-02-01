/*
 * Copyright 2016 the original author or authors.
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
package org.openehealth.ipf.commons.ihe.xds.core.ebxml.enumfactories;

import org.apache.commons.lang3.NotImplementedException;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XdsEnum;
import org.openehealth.ipf.commons.ihe.xds.core.metadata.XdsEnumFactory;
import org.openehealth.ipf.commons.ihe.xds.core.responses.Severity;
import org.openehealth.ipf.commons.ihe.xds.core.stub.ebrs21.rs.ErrorType;

public class SeverityFactory21 extends XdsEnumFactory<Severity> {

    @Override
    public Severity[] getOfficialValues() {
        return Severity.OFFICIAL_VALUES;
    }

    @Override
    protected Severity createCode(XdsEnum.Type type, String ebXML) {
        return new Severity(type, null, ebXML);
    }

    @Override
    public String getEbXML(Severity code) {
        return (code.getType() == XdsEnum.Type.OFFICIAL) ? code.getEbXML21ErrorType().value() : code.getEbXML30();
    }

    public ErrorType getErrorType(Severity code) {
        return code.getEbXML21ErrorType();
    }

}