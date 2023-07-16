package io.nqa.commons;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomResponse {
    private boolean success;
    private String message;
    private Object object;

    public CustomResponse(boolean success) {
        this.success = success;
        if (success) this.message = "success";
        else this.message = "failure";
    }

    public CustomResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public CustomResponse(boolean success, Object object) {
        this.success = success;
        if (success) this.message = "success";
        else this.message = "failure";
        this.object = object;
    }

    public CustomResponse(Object object) {
        if (object == null) {
            this.success = false;
            this.message = "failure";
        } else {
            this.success = true;
            this.message = "success";
        }
        this.object = object;
    }
}
