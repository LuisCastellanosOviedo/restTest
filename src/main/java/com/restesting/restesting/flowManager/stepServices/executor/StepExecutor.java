package com.restesting.restesting.flowManager.stepServices.executor;


import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.flowManager.stepServices.executor.httpVerb.VerbStrategy;
import com.restesting.restesting.flowManager.validationRules.BodyEqualValidationProcessor;
import com.restesting.restesting.flowManager.validationRules.CodeTextValidationProcessor;
import com.restesting.restesting.flowManager.validationRules.CodeValidationProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StepExecutor {



    @Autowired
    VerbStrategy verbStrategy;

    public  void executeStep(FlowStep flowStep) throws Exception {
        flowStep= executeRest(flowStep);
        applyValidationsToRequest(flowStep);
    }



    private void applyValidationsToRequest(FlowStep flowStep) throws Exception {
        CodeValidationProcessor codeValidationProcessor = new CodeValidationProcessor();
        CodeTextValidationProcessor codeTextValidationProcessor = new CodeTextValidationProcessor();
        BodyEqualValidationProcessor bodyEqualValidationProcessor = new BodyEqualValidationProcessor();


        codeValidationProcessor.setNext(codeTextValidationProcessor);
        codeTextValidationProcessor.setNext(bodyEqualValidationProcessor);
        codeValidationProcessor.handle(flowStep);
    }

    private FlowStep executeRest(FlowStep flowStep) {
        return  verbStrategy.getHttpVerbExecution(flowStep.getMethod()).apply(flowStep);
    }

}
