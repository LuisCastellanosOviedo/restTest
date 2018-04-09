package com.restesting.restesting.flowManager.stepServices;


import com.fasterxml.jackson.databind.JsonNode;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.stepServices.executor.StepExecutor;
import com.restesting.restesting.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class StepFlowService {



   // public static final String MAIN_URL = "src/main/resources/static";
   public static final String MAIN_URL = "/home/developer/Flows";


    @Autowired
    StepExecutor stepExecutor;

    @Autowired
    JsonUtils jsonUtils;


    final static Map<String, String> fillJsonBodyByHttpVerb = new HashMap<>();

    @PostConstruct
    private void fillStrategy()
    {
        fillJsonBodyByHttpVerb.put("get", "/bodyResponse.json");
        fillJsonBodyByHttpVerb.put("post","/bodyRequest.json");
    }


    public  FlowStep createStepFlowEntity(String flowName, int stepNumber) throws IOException {

        String urlStep= createUrlStep(flowName, stepNumber);


        String conf =  jsonUtils.readJsonConf(urlStep+"/setup.json");
        JsonNode jsonNode = jsonUtils.getJsonNode(conf);


        FlowStep flowStep = new FlowStep();
        flowStep.setStepNumer(stepNumber);
        flowStep.setUrl(jsonNode.get("url").asText());
        flowStep.setHeaders(jsonUtils.getValuesAsMap(jsonNode.get("headers")));
        flowStep.setMethod(jsonNode.get("method").asText());
        flowStep.setBodyResponse(readJsonBody(urlStep+getBodyJsonName(flowStep.getMethod())));
        flowStep.setBodyRequest(readJsonBody(urlStep+getBodyJsonName(flowStep.getMethod())));

        return flowStep;

    }

    private String createUrlStep(String flowName, int stepNumber) {
        return MAIN_URL + "/"+flowName+"/step"+stepNumber;
    }


    public String readJsonBody(String url){
        return jsonUtils.readJsonConf(url);
    }

    public String getBodyJsonName(String bodyType){
        String jsonFileName  = fillJsonBodyByHttpVerb.get(bodyType);
        return jsonFileName!=null?jsonFileName:"";
    }

    public void executeStep(FlowStep flowStep) throws Exception {
        try {
            stepExecutor.executeStep(flowStep);
        } catch (Exception e) {
            throw new Exception("ERROR EXECUTING STEP" + e.getMessage());
        }
    }


}
