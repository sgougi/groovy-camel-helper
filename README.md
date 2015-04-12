使い方（Usage）
=====

```
@GrabResolver(name=':groovy-camel-helper', root='http://www.wingnest.com/mvn-repo/')
@Grab('com.wingnest.groovy:groovy-camel-helper:1.0-M1-SNAPSHOT')

import static com.wingnest.groovy.camel.CamelHelper.getDirectOnceUri as once
import static com.wingnest.groovy.camel.CamelHelper.execCamelContext

execCamelContext(new RouteBuilder() {
    def void configure() {
        from(once())
        // components, processor, ....
    }
})

// OR

def camelContext = new DefaultCamelContext()
....
execCamelContext(camelContext, new RouteBuilder() {
    def void configure() {
        from(once())
        // components, processor, ....
    }
})

```

Licence
========
Groovy Camel Helper is distributed under the [Apache 2 licence](http://www.apache.org/licenses/LICENSE-2.0.html).
 
