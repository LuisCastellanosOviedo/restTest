package com.restesting.restesting.flowManager.validationRules;

import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.validationRules.ChainDefinition.ChainRespObject;

public class CodeTextValidationProcessor extends ChainRespObject<FlowStep> {


    public static final String STATUS_TEXT = "ok";

    @Override
    protected FlowStep handleWork(FlowStep input) throws Exception {
        if(!input.getResponseAsString().getStatusText().toLowerCase().equals(STATUS_TEXT)){
            throw  new Exception(" STATUS TEXT ARE NOT OK IS  "+input.getResponseAsString().getStatusText());
        }
        return input;
    }
}
