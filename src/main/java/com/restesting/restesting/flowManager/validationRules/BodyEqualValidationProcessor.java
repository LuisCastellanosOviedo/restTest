package com.restesting.restesting.flowManager.validationRules;

import com.fasterxml.jackson.databind.JsonNode;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.validationRules.ChainDefinition.ChainRespObject;
import com.restesting.restesting.util.JsonUtils;
import org.springframework.stereotype.Component;

@Component
public class BodyEqualValidationProcessor extends ChainRespObject<FlowStep> {



    public JsonUtils jsonUtils = new JsonUtils();

    @Override
    protected FlowStep handleWork(FlowStep input) throws Exception {


        return input;
    }





    private void compareAsString(FlowStep input) throws Exception {
        String res = input.getResponseAsString().getBody();

        JsonNode response =  jsonUtils.getJsonNode(res);
        JsonNode responseRecorded = jsonUtils.getJsonNode(input.getBodyResponse());

        if(response.equals(responseRecorded)) {
            throw new Exception("  **** details = BODY ARE NOT EQUALS method:"+input.getMethod()+" step number "+input.getStepNumer());
        }
    }
}
