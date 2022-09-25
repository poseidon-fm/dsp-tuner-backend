package org.dsp.dsptunerbackend.api.display.publisher;

import org.dsp.dsptunerbackend.model.radiodetails.RadioData;
import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.dsp.dsptunerbackend.model.radiodetails.RadioSettings;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

import java.math.BigDecimal;
import java.util.UUID;

@Component
public class NewRadioDetailsPublisher {

    private static final Logger LOG = LoggerFactory.getLogger(NewRadioDetailsPublisher.class);
    private final Sinks.Many<RadioDetails> sink;

    public NewRadioDetailsPublisher() {
        this.sink = Sinks.many()
                .multicast()
                .onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    }

//    @TransactionalEventListener
//    @Transactional(propagation = Propagation.REQUIRES_NEW)
//    public void onNewRadioDetails(RadioDetails radioDetails) {
//        this.sink.emitNext(radioDetails, Sinks.EmitFailureHandler.FAIL_FAST);
//
//        LOG.info("NEW RADIO DETAILS ARE EMITTED TO FLUX STREAM");
//
//    }

    @Scheduled(fixedRate = 3000)
    public void onNewRadioDetails() {
        var radioSettings = new RadioSettings(12, true);
        var radioData = new RadioData(new BigDecimal("45.63"));
        var radioDetails = new RadioDetails(UUID.randomUUID().toString(), radioSettings, radioData);
        this.sink.tryEmitNext(radioDetails);
        LOG.info("NEW RADIO DETAILS ARE EMITTED TO FLUX STREAM");
    }

    public Flux<RadioDetails> getPublisher() {
        return this.sink.asFlux();
    }
}
