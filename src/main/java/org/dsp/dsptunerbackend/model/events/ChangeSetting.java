package org.dsp.dsptunerbackend.model.events;

import lombok.Data;
import lombok.NonNull;

@Data
public class ChangeSetting {
    @NonNull String radioId;
    @NonNull SettingType type;
    @NonNull String val;
    @NonNull Integer commandId;
}
