package com.wingnest.groovy.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.DefaultExchange;

public final class CamelHelper {

	public static CamelContext createDefaultCamelContext() {
		return new DefaultCamelContext();
	}	
	
    public static String getDirectOnceUri() {
        return "direct:once";
    }

    public static void execCamelContext(RouteBuilder routeBuilder) throws Exception {
    	execCamelContext(createDefaultCamelContext(), routeBuilder);
    }
    
    public static void execCamelContext(CamelContext camelContext, RouteBuilder routeBuilder) throws Exception {
    	camelContext.addRoutes(routeBuilder);
    	camelContext.start();
    	camelContext.createProducerTemplate().send("direct:once", new DefaultExchange(camelContext));
    	camelContext.stop();
    }

    private CamelHelper() { /* noop */ }

}

