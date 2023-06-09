package com.webcodein.admin.dto;

import lombok.Getter;

@Getter
public class RestResponse {
    private String message;

    private String rootMessage;


    public RestResponse() {
    }

    public RestResponse(String message) {
        this.message = message;
    }



    public RestResponse(String message, String causeMessage) {
        this.message = message;
        this.rootMessage = causeMessage;
    }


}
