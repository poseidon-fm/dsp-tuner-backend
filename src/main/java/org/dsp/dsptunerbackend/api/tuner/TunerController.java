package org.dsp.dsptunerbackend.api.tuner;

import org.dsp.dsptunerbackend.model.events.SetEvent;
import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Controller;

@Controller
public class TunerController {

    private final ApplicationEventPublisher applicationEventPublisher;

    private static final Logger LOG = LoggerFactory.getLogger(TunerController.class);

    public TunerController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @MutationMapping
    public void sendRadioDetailsToDisplay(@Argument("radioDetails") RadioDetails radioDetails) {
        applicationEventPublisher.publishEvent(radioDetails);
        LOG.debug("Published radio details event");
    }

    @Async
    @EventListener
    public void onSetEvent(SetEvent setEvent) {
        LOG.debug("Received on set event for type " + setEvent.getType().toString().toLowerCase() + ", value " + setEvent.getVal() + ", commandId " + setEvent.getCommandId());

        // TODO: implement command to tuner

    }

}
