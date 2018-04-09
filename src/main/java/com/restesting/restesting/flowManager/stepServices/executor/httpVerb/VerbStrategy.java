package com.restesting.restesting.flowManager.stepServices.executor.httpVerb;


import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class VerbStrategy {


    @Autowired
    RestExecutorFunctions restExecutorFunctions;

    final static Map<String, Function<FlowStep,FlowStep>> httpVerbExecution = new HashMap<>();

    @PostConstruct
    private void fillStrategy()
     {
        httpVerbExecution.put("get", restExecutorFunctions.executeGet);
        httpVerbExecution.put("post",restExecutorFunctions.executePost);
    }

    public Function<FlowStep,FlowStep> getHttpVerbExecution(String verbAction){
            Function<FlowStep,FlowStep> step = httpVerbExecution.get(verbAction.toLowerCase());
            if(step!=null){
                return step;
            }
        throw new IllegalArgumentException("Http verb does not exist " + verbAction.toUpperCase());

    }



}
