package org.dsp.dsptunerbackend.api.tuner.service;

import org.dsp.dsptunerbackend.model.events.ChangeSettingsEvent;
import org.springframework.stereotype.Service;

@Service
public class ChangeSettingsEventService {

    public void processChangeSettings(ChangeSettingsEvent event) {

        //TODO: send event command to tuner

    }
}
