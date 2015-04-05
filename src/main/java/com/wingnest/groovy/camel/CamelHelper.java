package com.wingnest.groovy.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public final class CamelHelper {

    public static Processor newStopProcessor(int status) {
        return new StopProcessor(status);
    }
    
    public static Processor newStopProcessor() {
        return new StopProcessor(0);
    }    

    public static String getOnceTimerUri() {
        return "timer:?fixedRate=true&repeatCount=1";
    }

    public static void startCamelContext(Object script, CamelContext camelContext) throws Exception {
        camelContext.start();
        synchronized(script){
           script.wait();
        }
    }

    public static class StopProcessor implements Processor {
        private Thread stop;
        private int status;

        public StopProcessor(int status) {
            this.status = status;
        }

        public void process(final Exchange exchange) throws Exception {
            if (stop == null) {
                stop = new Thread() {
                    public void run() {
                        try {
                            exchange.getContext().stop();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        System.exit(status);
                    }
                };
            }
            stop.start();
        }
    }

    private CamelHelper() { /* noop */ }

}
