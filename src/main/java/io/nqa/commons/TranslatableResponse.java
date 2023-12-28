package io.nqa.commons;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class TranslatableResponse {
    private ResponseType responseType;
    private ResponseMessages message;
}
