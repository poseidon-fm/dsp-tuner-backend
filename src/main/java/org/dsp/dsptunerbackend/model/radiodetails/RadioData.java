package org.dsp.dsptunerbackend.model.radiodetails;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString
@RequiredArgsConstructor
public class RadioData {
    @NonNull BigDecimal signalStrength;
}
