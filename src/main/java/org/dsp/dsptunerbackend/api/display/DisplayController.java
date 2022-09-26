package org.dsp.dsptunerbackend.api.display;

import org.dsp.dsptunerbackend.api.display.publisher.NewRadioDetailsPublisher;
import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

@Controller
public class DisplayController {

    private final NewRadioDetailsPublisher newRadioDetailsPublisher;

    private static final Logger LOG = LoggerFactory.getLogger(DisplayController.class);

    public DisplayController(NewRadioDetailsPublisher newRadioDetailsPublisher) {
        this.newRadioDetailsPublisher = newRadioDetailsPublisher;
    }

    @SubscriptionMapping
    public Flux<RadioDetails> onNewRadioDetails() {
        LOG.debug("Received subscription to new radio details");
        return newRadioDetailsPublisher.getPublisher();
    }

}
