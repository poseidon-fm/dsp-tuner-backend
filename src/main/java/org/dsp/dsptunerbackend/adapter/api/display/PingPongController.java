package org.dsp.dsptunerbackend.adapter.api.display;

import org.dsp.dsptunerbackend.domain.Pong;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PingPongController {

    @QueryMapping
    public Pong ping() {
        return new Pong("We have connection!");
    }


}
