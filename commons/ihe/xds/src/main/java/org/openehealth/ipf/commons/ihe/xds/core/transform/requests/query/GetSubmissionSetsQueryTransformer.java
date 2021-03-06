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
package org.openehealth.ipf.commons.ihe.xds.core.transform.requests.query;

import static org.openehealth.ipf.commons.ihe.xds.core.transform.requests.QueryParameter.*;

import org.openehealth.ipf.commons.ihe.xds.core.ebxml.EbXMLAdhocQueryRequest;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetAssociationsQuery;
import org.openehealth.ipf.commons.ihe.xds.core.requests.query.GetSubmissionSetsQuery;

/**
 * Transforms between {@link GetAssociationsQuery} and {@link EbXMLAdhocQueryRequest}.
 *
 * @author Jens Riemschneider
 */
public class GetSubmissionSetsQueryTransformer extends GetByUUIDQueryTransformer<GetSubmissionSetsQuery> {
    /**
     * Constructs the transformer.
     */
    public GetSubmissionSetsQueryTransformer() {
        super(UUID);
    }

    /**
     * @param query the query. Can be <code>null</code>.
     * @param ebXML ebXML request
     */
    @Override
    public void toEbXML(GetSubmissionSetsQuery query, EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.toEbXML(query, ebXML);

        var slots = new QuerySlotHelper(ebXML);
        slots.fromInteger(METADATA_LEVEL, query.getMetadataLevel());
    }

    /**
     * @param query the query. Can be <code>null</code>.
     * @param ebXML ebXML request
     */
    @Override
    public void fromEbXML(GetSubmissionSetsQuery query, EbXMLAdhocQueryRequest ebXML) {
        if (query == null || ebXML == null) {
            return;
        }

        super.fromEbXML(query, ebXML);

        var slots = new QuerySlotHelper(ebXML);
        query.setMetadataLevel(slots.toInteger(METADATA_LEVEL));
    }
}