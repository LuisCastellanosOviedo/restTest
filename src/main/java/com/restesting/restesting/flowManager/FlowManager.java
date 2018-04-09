package com.restesting.restesting.flowManager;


import com.restesting.restesting.flowManager.flowservices.FlowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@Component
public class FlowManager {


    @Autowired
    FlowService flowService;


    public void executeFlows() throws IOException {

        List<String> flows = flowService.loadFlowList();


        flows.stream().forEach( f -> {
            try {
                System.out.println("############  TESTING FLOW --> "+f);
                flowService.executeFlow(f);
                System.out.println("############  TESTING COMPLETED AND VALID - FLOW "+f);
            } catch (IOException e) {
                throw new RuntimeException("ERROR EXECUTING FLOW "+f);
            } catch (Exception e) {
                System.out.println("============ >>>>>  ERROR EXECUTING FLOW "+e.getMessage());
            }
        });

        System.out.println("ALL FLOWS HAS BEEN EXECUTED ");
    }


;
}
