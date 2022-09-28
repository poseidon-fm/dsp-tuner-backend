package org.dsp.dsptunerbackend.model;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Pong {
    @NonNull
    private String name;
}
