package com.restesting.restesting.flowManager.stepServices;

import com.fasterxml.jackson.databind.JsonNode;
import com.restesting.restesting.flowManager.stepServices.entity.FlowStep;
import com.restesting.restesting.util.JsonUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;

import static org.mockito.Mockito.when;


@RunWith(MockitoJUnitRunner.class)
public class StepFlowServiceTest {




    @InjectMocks
    private StepFlowService stepFlowService;

    private String flowName;
    private  int stepNumber;
    private String jsonAsString;

    private JsonUtils jsonUtilReal;

    @Mock
    private JsonUtils jsonUtils;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        flowName="flow1";
        stepNumber=1;
        jsonAsString = setupJsonTest();
        jsonUtilReal =new JsonUtils();
    }


    @Test
    public void stepFlowNotNull() {
        Assert.assertNotNull(stepFlowService);
    }


    @Test
    public void stepFlowGet() {
        try {
            //given
            when(jsonUtils.readJsonConf("src/main/resources/static/flow1/step1/setup.json")).thenReturn(jsonAsString);
            when(jsonUtils.getJsonNode(jsonAsString)).thenReturn(jsonUtilReal.getJsonNode(jsonAsString));


            FlowStep flowStep= stepFlowService.loadFlowStep(flowName,stepNumber);

            Assert.assertNotNull(flowStep);

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static String setupJsonTest(){
        return "{\n" +
                "  \"url\": \"https://api-mobile-air-booking.dev5.southwest.com/v1/mobile-air-booking/page/view-reservation/QKLZRX?first-name=Yzzywrnqe&last-name=Bycuybmnh\",\n" +
                "  \"method\": \"get\",\n" +
                "  \"headers\": {\n" +
                "    \"x-api-key\": \"l7xxbfc2e646cc724d3ab0fe30857157cec0\",\n" +
                "    \"X-Account-Number\": \"601143885\",\n" +
                "    \"true-host\": \"mobile.southwest.com\",\n" +
                "    \"X-Api-IDToken\": \"eyJhbGciOiJSUzI1NiJ9.eyJhdF9oYXNoIjoia0d1RDAtakxRclhwdG91RmVMcmQyUSIsImFjY2Vzc190b2tlbiI6IjA4MTg2Y2EwLWE3NjEtNGQ4My04MTg4LWMyNjRmM2IyNjU0MCIsInN1YiI6IjNpT3hNU1JITFJqZHpialRnQ1NZNm5aQ1VRVHdUNnBRMGpTZE9jemVBczQiLCJhdWQiOiI5OWFhNjNiOS01YTdmLTRkZjItYmIyZi0xMDBjZGEwMDg0ZGUiLCJhenAiOiI5OWFhNjNiOS01YTdmLTRkZjItYmIyZi0xMDBjZGEwMDg0ZGUiLCJhdXRoX3RpbWUiOjE1MTYxNDI0NDYsImlzcyI6Imh0dHBzOi8vYXBpLXNlY3VyaXR5Lml0ZXN0LnNvdXRod2VzdC5jb20iLCJleHAiOjE1MTYxNDQyNDYsImlhdCI6MTUxNjE0MjQ0Niwibm9uY2UiOiJTV0EyMDE2OjE1MTYxNDI0NDYiLCJjdXN0b21lclN1bW1hcnkiOnsiY29tcGFuaW9uUGFzc0luZm8iOnsiY29tcGFuaW9uUXVhbGlmeWluZ0ZsaWdodHMiOjAsImNvbXBhbmlvblBhc3NFeHBpcmF0aW9uRGF0ZSI6IjIwMTgtMTItMzEiLCJjb21wYW5pb25RdWFsaWZ5aW5nUG9pbnRzIjo3MDAwMCwiY29tcGFuaW9uRGVjbGFyZWQiOnRydWUsImNvbXBhbmlvblBhc3NBY2hpZXZlZCI6dHJ1ZX0sImZpcnN0TmFtZSI6IkZ3ZGNtaGd2byIsImxhc3ROYW1lIjoiQXJ1dXZ1YnEiLCJ0aWVyU3RhdHVzUGVuZGluZyI6ZmFsc2UsInRpZXIiOiJBX0xJU1RfUFJFRkVSUkVEIiwicmVkZWVtYWJsZVBvaW50cyI6NzE0NSwiYWNjb3VudFR5cGUiOiJNRU1CRVIiLCJhY2NvdW50TnVtYmVyIjoiNjAxMTQzODg1IiwicHJpbWFyeUVtYWlsIjoieDIxMjczNkB3bmNvLmNvbSJ9fQ.lfcT1gT9E0TxaLQu1RXfc7iFYJRgb_BZpBR5Nrunb1wl2xA4nIGK42-9rZTx1lzfFeAI6mNIAa_y98uryR9MXkl74VaGWKPXl8YXA4Lgal3G6DmJqFXqrATkJxFaLg7568U16zWpbCSdfERtcPsKLJ86pSptTCp3c_aq1S9gla1sugVVBvybbrYDv9MPeNyVqmMQIuJpnWPA1dFcKP1MdTFqeL7i4xlhlx6NkKAE9PPpiUcufgyKqk7YRiZSy97DI84k9_CtcfQL0E8vBo1TEZzL1t-Y8x5mngOOm0inL-mcgTymc9FwCKxr0fYbE6TjCFNTLN1jG2zQuZqgqKRhQg\\\"\",\n" +
                "    \"Authorization\": \"Bearer 08186ca0-a761-4d83-8188-c264f3b26540\"\n" +
                "  }\n" +
                "}";
    }
}
