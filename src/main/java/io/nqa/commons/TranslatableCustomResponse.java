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
    private ResponseType responseType;
    private ResponseMessages message;

    public TranslatableCustomResponse(boolean success, ResponseType responseType, ResponseMessages message) {
        this.success = success;
        this.object = null;
        this.responseType = responseType;
        this.message = message;
    }

    public TranslatableCustomResponse(boolean success, ResponseType responseType) {
        this.success = success;
        this.object = null;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }

    public TranslatableCustomResponse(Object object, ResponseType responseType, ResponseMessages message) {
        this.success = object != null;
        this.object = object;
        this.responseType = responseType;
        this.message = message;
    }

    public TranslatableCustomResponse(Object object, ResponseType responseType) {
        this.success = object != null;
        this.object = object;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }

    public TranslatableCustomResponse(boolean success, Object object, ResponseType responseType) {
        this.success = success;
        this.object = object;
        this.responseType = responseType;
        this.message = ResponseMessages.EMPTY;
    }
}
