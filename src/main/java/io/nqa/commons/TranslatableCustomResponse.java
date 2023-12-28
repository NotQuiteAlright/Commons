package io.nqa.commons;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Combination for CustomResponse and TranslatableResponse
 */
@Data
@AllArgsConstructor
public class TranslatableCustomResponse {
    private boolean success;
    private Object object;
    private Enum<? extends Enum> responseType;
    private Enum<? extends Enum> message;

    public TranslatableCustomResponse(boolean success, Enum<? extends Enum> responseType, Enum<? extends Enum> message) {
        this.success = success;
        this.object = null;
        this.responseType = responseType;
        this.message = message;
    }

    public TranslatableCustomResponse(boolean success, Enum<? extends Enum> responseType) {
        this.success = success;
        this.object = null;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }

    public TranslatableCustomResponse(Object object, Enum<? extends Enum> responseType, Enum<? extends Enum> message) {
        this.success = object != null;
        this.object = object;
        this.responseType = responseType;
        this.message = message;
    }

    public TranslatableCustomResponse(Object object, Enum<? extends Enum> responseType) {
        this.success = object != null;
        this.object = object;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }

    public TranslatableCustomResponse(boolean success, Object object, Enum<? extends Enum> responseType) {
        this.success = success;
        this.object = object;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }
}
