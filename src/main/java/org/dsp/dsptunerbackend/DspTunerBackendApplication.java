package org.dsp.dsptunerbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class DspTunerBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(DspTunerBackendApplication.class, args);
    }

}
