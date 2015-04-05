使い方（Usage）
=====

```
@GrabResolver(name='groovy-camel-helper', root='http://www.wingnest.com/mvn-repo/')
@Grab('com.wingnest.groovy:groovy-camel-helper:1.0-SNAPSHOT')

import static com.wingnest.groovy.camel.CamelHelper.newStopProcessor as stop
import static com.wingnest.groovy.camel.CamelHelper.getOnceTimerUri as once
import static com.wingnest.groovy.camel.CamelHelper.startCamelContext

def camelContext = new DefaultCamelContext()
camelContext.addRoutes(new RouteBuilder() {
    def void configure() {
        onException(Exception.class).process(stop(-1))
        from(once())
        // components, processor, ....
        .process(stop(0))
    }
})

startCamelContext(this, camelContext)
```

Licence
========
Groovy Camel Helper is distributed under the [Apache 2 licence](http://www.apache.org/licenses/LICENSE-2.0.html).
 
