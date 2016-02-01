/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.openehealth.ipf.commons.ihe.fhir.iti78;

import ca.uhn.fhir.rest.gclient.StringClientParam;
import ca.uhn.fhir.util.ElementUtil;
import org.hl7.fhir.instance.model.HumanName;
import org.hl7.fhir.instance.model.Patient;
import org.hl7.fhir.instance.model.annotations.Child;
import org.hl7.fhir.instance.model.annotations.Description;
import org.hl7.fhir.instance.model.annotations.Extension;
import org.hl7.fhir.instance.model.annotations.ResourceDef;
import org.openehealth.ipf.commons.ihe.fhir.Constants;

/**
 * Patient as defined by the PDQm specification. This extends the default patient resource with the following attributes:
 * <ul>
 *     <li>mothersMaidenName</li>
 * </ul>
 */
@ResourceDef(name = "Patient", id = "pdqm", profile = "http://www.ihe.net/ITI-78/Profile/pdqm")
public class PdqPatient extends Patient {

    // Search Parameters
    
    public static final StringClientParam IDENTIFIER = new StringClientParam(Patient.SP_IDENTIFIER);
    public static final StringClientParam FAMILY = new StringClientParam(Patient.SP_FAMILY);
    public static final StringClientParam GIVEN = new StringClientParam(Patient.SP_GIVEN);
    public static final StringClientParam BIRTHDATE = new StringClientParam(Patient.SP_BIRTHDATE);
    public static final StringClientParam ADDRESS = new StringClientParam(Patient.SP_ADDRESS);
    public static final StringClientParam GENDER = new StringClientParam(Patient.SP_GENDER);
    public static final StringClientParam RESOURCE_IDENTIFIER = new StringClientParam(Constants.SP_RESOURCE_IDENTIFIER);
    public static final StringClientParam TELECOM = new StringClientParam(Patient.SP_TELECOM);
    public static final StringClientParam MULTIPLE_BIRTH_ORDER_NUMBER = new StringClientParam(Constants.SP_MULTIPLE_BIRTH_ORDER_NUMBER);
    public static final StringClientParam SP_MOTHERS_MAIDEN_NAME_GIVEN = new StringClientParam(Constants.SP_MOTHERS_MAIDEN_NAME_GIVEN);
    public static final StringClientParam SP_MOTHERS_MAIDEN_NAME_FAMILY = new StringClientParam(Constants.SP_MOTHERS_MAIDEN_NAME_FAMILY);

    @Child(name = "mothersMaidenName")
    @Extension(url = "http://www.ihe.net/ITI-78/Profile/pdqm#mothersMaidenName", isModifier = false, definedLocally = false)
    @Description(shortDefinition = "Mother's maiden name of a patient")
    private HumanName mothersMaidenName;

    @Override
    public boolean isEmpty() {
        return super.isEmpty() && ElementUtil.isEmpty(mothersMaidenName);
    }

    public HumanName getMothersMaidenName() {
        if (mothersMaidenName == null) {
            mothersMaidenName = new HumanName();
        }
        return mothersMaidenName;
    }

    public void setMothersMaidenName(HumanName mothersMaidenName) {
        this.mothersMaidenName = mothersMaidenName;
    }


}
