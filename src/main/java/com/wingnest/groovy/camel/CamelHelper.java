package com.wingnest.groovy.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultExchange;

public final class CamelHelper {

    public static String getDirectOnceUri() {
        return "direct:once";
    }

    public static void startCamelContext(CamelContext camelContext) throws Exception {
    	camelContext.start();
    	camelContext.createProducerTemplate().send("direct:once", new DefaultExchange(camelContext));
    	camelContext.stop();
    }

    private CamelHelper() { /* noop */ }

}

