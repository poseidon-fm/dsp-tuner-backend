package org.dsp.dsptunerbackend.adapter.api.display;

import org.dsp.dsptunerbackend.domain.Foobar;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class FoobarController {

    @QueryMapping
    public Foobar getSomething() {
        return new Foobar("Klaas Vaak: 117");
    }


}
