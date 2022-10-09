package org.dsp.dsptunerbackend.model.radiodetails;

import lombok.Data;
import lombok.NonNull;

@Data
public class RadioDetails {
    @NonNull String radioId;
    @NonNull RadioSettings settings;
    @NonNull RadioData data;
}
