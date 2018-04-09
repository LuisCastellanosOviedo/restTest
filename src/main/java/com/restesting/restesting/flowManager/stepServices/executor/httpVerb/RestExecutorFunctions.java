package com.restesting.restesting.flowManager.stepServices.executor.httpVerb;


import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RestExecutorFunctions {


    public Function<FlowStep,FlowStep> executeGet = (x ->{

        try {
            HttpResponse<String>    responseAsString = Unirest.get(x.getUrl())
                    .headers(x.getHeaders())
                    .asString();

            x.setResponseAsString(responseAsString);
        } catch (UnirestException e) {
            System.out.println("ERROR EXECUTING REST SERVICE - GET - UNIREST ");
        }

        return x;
    }
    );


    public Function<FlowStep,FlowStep> executePost = (x ->{

        try {
            HttpResponse<String>    responseAsString = Unirest.post(x.getUrl())
                    .headers(x.getHeaders())
                    .body(x.getBodyRequest())
                    .asString();

            x.setResponseAsString(responseAsString);
        } catch (UnirestException e) {
            System.out.println("ERROR EXECUTING REST SERVICE - POST -UNIREST ");
        }

        return x;
    }
    );


}
