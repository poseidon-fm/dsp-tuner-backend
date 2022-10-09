package org.dsp.dsptunerbackend.model.radiodetails;

import lombok.Data;
import lombok.NonNull;

import java.math.BigDecimal;

@Data
public class RadioData {
    @NonNull BigDecimal signalStrength;
}
