package org.dsp.dsptunerbackend.model.events;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Data
@ToString
@RequiredArgsConstructor
public class SetEvent {
    @NonNull SetType type;
    @NonNull String val;
    @NonNull UUID commandId;
}
