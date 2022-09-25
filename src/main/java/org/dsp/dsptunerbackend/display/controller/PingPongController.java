package org.dsp.dsptunerbackend.display.controller;

import org.dsp.dsptunerbackend.display.model.Pong;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PingPongController {

    @QueryMapping
    public Pong ping() {
        return new Pong("We have connection!");
    }

}
