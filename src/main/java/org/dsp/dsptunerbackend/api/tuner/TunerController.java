package org.dsp.dsptunerbackend.api.tuner;

import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class TunerController {

    private static final Logger LOG = LoggerFactory.getLogger(TunerController.class);
    private final ApplicationEventPublisher applicationEventPublisher;

    public TunerController(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @MutationMapping
    public void sendRadioDetailsToDisplay(@Argument("radioDetails") RadioDetails radioDetails) {
        LOG.info(">>>> sendRadioDetailsToDisplay call received!!!");

        LOG.info("radioId: " + radioDetails.getRadioId());
        LOG.info("squelch: " + radioDetails.getSettings().getSquelch());
        LOG.info("signalStrength: " + radioDetails.getData().getSignalStrength());

        applicationEventPublisher.publishEvent(radioDetails);

        LOG.info("EVENT IS PUBLISHED");

    }

}
