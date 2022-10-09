package org.dsp.dsptunerbackend.api.tuner;

import org.dsp.dsptunerbackend.api.tuner.service.ChangeSettingsEventService;
import org.dsp.dsptunerbackend.model.events.ChangeSettingsEvent;
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
    private final ChangeSettingsEventService changeSettingsEventService;

    private static final Logger LOG = LoggerFactory.getLogger(TunerController.class);

    public TunerController(ApplicationEventPublisher applicationEventPublisher, ChangeSettingsEventService changeSettingsEventService) {
        this.applicationEventPublisher = applicationEventPublisher;
        this.changeSettingsEventService = changeSettingsEventService;
    }

    @MutationMapping
    public void sendRadioDetailsToDisplay(@Argument("radioDetails") RadioDetails radioDetails) {
        applicationEventPublisher.publishEvent(radioDetails);
        LOG.debug("Published radio details event for radioId " + radioDetails.getRadioId());
    }

    @Async
    @EventListener
    public void onChangeSettingsEvent(ChangeSettingsEvent event) {
        LOG.debug("Received on change settings event");
        LOG.debug(event.toString());
        changeSettingsEventService.processChangeSettings(event);
    }

}
