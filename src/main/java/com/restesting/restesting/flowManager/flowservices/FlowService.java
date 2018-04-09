package com.restesting.restesting.flowManager.flowservices;


import com.fasterxml.jackson.databind.JsonNode;
import com.restesting.restesting.flowManager.stepServices.StepFlowService;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.setupTools.GlobalSetup;
import com.restesting.restesting.util.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.restesting.restesting.constant.IConstants.URL_F_LOWS;

@Component
public class FlowService {



    @Autowired
    StepFlowService stepFlowService;

    @Autowired
    private  JsonUtils jsonUtils;


    public  List<String> loadFlowList() throws IOException {
        String flows = jsonUtils.readJsonConf(GlobalSetup.getInstace().getParameter(URL_F_LOWS)+"/flows.json");
        JsonNode jsonNode = jsonUtils.getJsonNode(flows);
        return jsonUtils.getValuesAsMap(jsonNode).values().stream().collect(Collectors.toList());
    }


    public void executeFlow(String flowName) throws Exception {
      int steps =   getStepsByFlowName(flowName);
        for (int i = 1; i <= steps ; i++) {
          FlowStep step =  stepFlowService.createStepFlowEntity(flowName,i);
          stepFlowService.executeStep(step);
        }
    }

    private int  getStepsByFlowName(String flowName) throws IOException {
        int count = 0;
        try (Stream<Path> files = Files.list(Paths.get(GlobalSetup.getInstace().getParameter(URL_F_LOWS)+"/"+flowName))) {
             count = (int) files.count();
        }
        return count;
    }

}
