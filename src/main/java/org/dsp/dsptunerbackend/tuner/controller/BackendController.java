package org.dsp.dsptunerbackend.tuner.controller;

import org.dsp.dsptunerbackend.tuner.model.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BackendController {

    private static final Logger LOG = LoggerFactory.getLogger(BackendController.class);

    @MutationMapping
    public void sendRadioDetailsToDisplay(@Argument("radioDetails") RadioDetails radioDetails) {
        LOG.info(">>>> sendRadioDetailsToDisplay call received!!!");

        LOG.info("radioId: " + radioDetails.getRadioId());
        LOG.info("squelch: " + radioDetails.getSettings().getSquelch());
        LOG.info("signalStrength: " + radioDetails.getData().getSignalStrength());

    }

}
