package org.dsp.dsptunerbackend.tuner.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RadioDetails {
    @NonNull String radioId;
    @NonNull RadioSettings settings;
    @NonNull RadioData data;
}
