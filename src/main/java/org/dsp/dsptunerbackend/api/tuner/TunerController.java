package org.dsp.dsptunerbackend.api.tuner;

import org.dsp.dsptunerbackend.api.tuner.service.SetEventService;
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
    private final SetEventService setEventService;

    private static final Logger LOG = LoggerFactory.getLogger(TunerController.class);

    public TunerController(ApplicationEventPublisher applicationEventPublisher, SetEventService setEventService) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.setEventService = setEventService;
    }

    @MutationMapping
    public void sendRadioDetailsToDisplay(@Argument("radioDetails") RadioDetails radioDetails) {
        applicationEventPublisher.publishEvent(radioDetails);
        LOG.debug("Published radio details event for radioId " + radioDetails.getRadioId());
    }

    @Async
    @EventListener
    public void onSetEvent(SetEvent setEvent) {
        setEventService.setEvent(setEvent);
        LOG.debug("Set event for type " + setEvent.getType().toString().toLowerCase() + ", value " + setEvent.getVal() + ", commandId " + setEvent.getCommandId());
    }

}
