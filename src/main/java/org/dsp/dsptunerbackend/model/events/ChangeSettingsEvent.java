package org.dsp.dsptunerbackend.model.events;

import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;

@Data
public class ChangeSettingsEvent {
    @NonNull ArrayList<ChangeSetting> changeSettings;
}
