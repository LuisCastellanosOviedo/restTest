package com.restesting.restesting.flowManager.stepServices;


import com.fasterxml.jackson.databind.JsonNode;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.stepServices.executor.StepExecutor;
import com.restesting.restesting.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StepFlowService {



    public static final String MAIN_URL = "src/main/resources/static";


    @Autowired
    StepExecutor stepExecutor;

    @Autowired
    JsonUtils jsonUtils;


    public  FlowStep loadFlowStep(String flowName,int stepNumber) throws IOException {

        String urlStep= MAIN_URL + "/"+flowName+"/step"+stepNumber;


        String conf =  jsonUtils.readJsonConf(urlStep+"/setup.json");
        JsonNode jsonNode = jsonUtils.getJsonNode(conf);

        FlowStep flowStep = new FlowStep();

        flowStep.setStepNumer(stepNumber);
        flowStep.setUrl(jsonNode.get("url").asText());
        flowStep.setHeaders(jsonUtils.getValuesAsMap(jsonNode.get("headers")));
        flowStep.setMethod(jsonNode.get("method").asText());


        if(flowStep.getMethod().equals("get")){
                flowStep.setBodyResponse(jsonUtils.readJsonConf(urlStep+"/bodyResponse.json"));
        }else if (flowStep.getMethod().equals("post")){
            flowStep.setBodyRequest(jsonUtils.readJsonConf(urlStep+"/bodyRequest.json"));
        }

        return flowStep;

    }


    public void executeStep(FlowStep flowStep) throws Exception {
        try {
            stepExecutor.executeStep(flowStep);
        } catch (Exception e) {
            throw new Exception("ERROR EXECUTING STEP" + e.getMessage());
        }
    }


}
