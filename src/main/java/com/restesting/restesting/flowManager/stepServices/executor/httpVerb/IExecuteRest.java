package com.restesting.restesting.flowManager.stepServices.executor.httpVerb;

import com.mashape.unirest.http.exceptions.UnirestException;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;

@FunctionalInterface
public interface IExecuteRest {
     FlowStep executeRest(FlowStep flowStep) throws UnirestException;
}
