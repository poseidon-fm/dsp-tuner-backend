package org.dsp.dsptunerbackend.tuner.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class RadioSettings {
    @NonNull Integer squelch;
    @NonNull Boolean stereo;
}
