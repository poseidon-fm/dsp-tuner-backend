package org.dsp.dsptunerbackend.api.display;

import org.dsp.dsptunerbackend.api.display.publisher.NewRadioDetailsPublisher;
import org.dsp.dsptunerbackend.model.radiodetails.RadioData;
import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.dsp.dsptunerbackend.model.radiodetails.RadioSettings;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.stream.Stream;

@Controller
public class DisplayController {

    private final NewRadioDetailsPublisher newRadioDetailsPublisher;

    public DisplayController(NewRadioDetailsPublisher newRadioDetailsPublisher) {
        this.newRadioDetailsPublisher = newRadioDetailsPublisher;
    }

    @SubscriptionMapping
    public Flux<RadioDetails> onNewRadioDetails() {
        return Flux.fromStream(
                Stream.generate(() -> {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    var radioSettings = new RadioSettings(12, true);
                    var radioData = new RadioData(new BigDecimal("45.63"));
                    return new RadioDetails(UUID.randomUUID().toString(), radioSettings, radioData);
                })
        );


        //return newRadioDetailsPublisher.getPublisher();
    }

}
