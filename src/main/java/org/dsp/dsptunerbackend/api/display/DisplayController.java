package org.dsp.dsptunerbackend.api.display;

import org.dsp.dsptunerbackend.api.display.publisher.NewRadioDetailsPublisher;
import org.dsp.dsptunerbackend.model.Pong;
import org.dsp.dsptunerbackend.model.events.SetEvent;
import org.dsp.dsptunerbackend.model.events.SetType;
import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Controller
public class DisplayController {

    private final NewRadioDetailsPublisher newRadioDetailsPublisher;
    private final ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOG = LoggerFactory.getLogger(DisplayController.class);

    public DisplayController(NewRadioDetailsPublisher newRadioDetailsPublisher, ApplicationEventPublisher applicationEventPublisher) {
        this.newRadioDetailsPublisher = newRadioDetailsPublisher;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @QueryMapping
    public Pong ping(@Argument Integer pongVersion) {
        if (pongVersion == 0) {
            return new Pong("pong 0");
        }
        return new Pong("pong 1");
    }

    @SubscriptionMapping
    public Flux<RadioDetails> onNewRadioDetails() {
        LOG.debug("Received subscription to new radio details");
        return newRadioDetailsPublisher.getPublisher();
    }

    @MutationMapping
    public void setSquelch(@Argument Integer val, @Argument UUID commandId) {
        applicationEventPublisher.publishEvent(
                new SetEvent(SetType.SQUELCH, val.toString(), commandId));
        LOG.debug("Published set event for type " + SetType.SQUELCH.toString().toLowerCase());
    }

}
