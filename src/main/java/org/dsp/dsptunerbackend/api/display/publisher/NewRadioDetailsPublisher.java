package org.dsp.dsptunerbackend.api.display.publisher;

import org.dsp.dsptunerbackend.model.radiodetails.RadioDetails;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;
import reactor.util.concurrent.Queues;

@Component
public class NewRadioDetailsPublisher {

    private final Sinks.Many<RadioDetails> sink;

    private static final Logger LOG = LoggerFactory.getLogger(NewRadioDetailsPublisher.class);

    public NewRadioDetailsPublisher() {
        this.sink = Sinks.many()
                .multicast()
                .onBackpressureBuffer(Queues.SMALL_BUFFER_SIZE, false);
    }

    @Async
    @EventListener
    public void onNewRadioDetails(RadioDetails radioDetails) {
        this.sink.emitNext(radioDetails, Sinks.EmitFailureHandler.FAIL_FAST);
        LOG.debug("Emitted new radio details to event publisher sink");
    }

    public Flux<RadioDetails> getPublisher() {
        return this.sink.asFlux();
    }
}
