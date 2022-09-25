package org.dsp.dsptunerbackend.model.radiodetails;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@ToString
@RequiredArgsConstructor
public class RadioSettings {
    @NonNull Integer squelch;
    @NonNull Boolean stereo;
}
