package com.restesting.restesting.flowManager.validationRules;

import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.validationRules.ChainDefinition.ChainRespObject;

public class CodeValidationProcessor extends ChainRespObject<FlowStep> {

    public static final int STATUS_OK = 200;

    @Override
    protected FlowStep handleWork(FlowStep input) throws Exception {
        if(input.getResponseAsString().getStatus()!= STATUS_OK){
            throw  new Exception(" STATUS ARE NOT 200 IS "+input.getResponseAsString().getStatus());
        }

        return input;
    }
}
