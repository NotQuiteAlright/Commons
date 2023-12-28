package io.nqa.commons;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslatableResponse {
    private Enum<? extends Enum> responseType;
    private Enum<? extends Enum> message;
}
