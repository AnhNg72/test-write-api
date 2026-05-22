package com.localintegrationapps.simpleapi.ui.model.output;

public class RestOutputModel {

    private String statusCode;
    private String Description;


    public RestOutputModel(String statusCode, String description) {
        this.statusCode = statusCode;
        Description = description;
    }



    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
