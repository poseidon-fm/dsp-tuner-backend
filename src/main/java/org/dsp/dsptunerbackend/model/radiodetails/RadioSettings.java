package org.dsp.dsptunerbackend.model.radiodetails;

import lombok.Data;
import lombok.NonNull;

@Data
public class RadioSettings {
    @NonNull Integer squelch;
    @NonNull Boolean stereo;
}
