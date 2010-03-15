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
package org.openehealth.ipf.platform.camel.ihe.ws;

import java.util.Map;

import org.apache.camel.Exchange;
import org.apache.camel.ExchangePattern;
import org.apache.commons.lang.Validate;

/**
 * Base class for web services that are aware of a {@link DefaultItiConsumer}.
 *
 * @author Jens Riemschneider
 */
public class DefaultItiWebService {
    private DefaultItiConsumer consumer;

    /**
     * Calls the consumer for processing via Camel.
     *
     * @param body
     *          contents of the in-message body to be processed.
     * @param headers
     *          additional in-message headers.
     * @param exchangePattern
     *          pattern of the exchange put into the route.
     * @return the resulting exchange.
     */
    protected Exchange process(
            Object body, 
            Map<String, Object> headers,
            ExchangePattern exchangePattern) 
    {
        Validate.notNull(consumer);

        Exchange exchange = consumer.getEndpoint().createExchange(exchangePattern);
        exchange.getIn().setBody(body);
        if (headers != null) {
            exchange.getIn().getHeaders().putAll(headers);
        }
        consumer.process(exchange);
        return exchange;
    }

    /**
     * Calls the consumer for synchronous (InOut) processing via Camel
     * without additional in-message headers.
     *
     * @param body
     *          contents of the in-message body to be processed.
     * @return the resulting exchange.
     */
    protected Exchange process(Object body) {
        return process(body, null, ExchangePattern.InOut);
    }
    
    /**
     * Sets the consumer to be used to process exchanges
     * @param consumer
     *          the consumer to be used
     */
    public void setConsumer(DefaultItiConsumer consumer) {
        Validate.notNull(consumer, "consumer");
        this.consumer = consumer;
    }

    /**
     * Returns the configured ITI consumer instance.
     */
    protected DefaultItiConsumer getConsumer() {
        return consumer;
    }
}
