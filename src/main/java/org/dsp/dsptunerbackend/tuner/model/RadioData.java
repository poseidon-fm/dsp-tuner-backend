package org.dsp.dsptunerbackend.tuner.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class RadioData {
    @NonNull BigDecimal signalStrength;
}
