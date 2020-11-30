package no.unit.nva.model.utils;

import com.amazonaws.services.lambda.runtime.Context;
import nva.commons.exceptions.ApiGatewayException;
import nva.commons.handlers.RequestInfo;
import nva.commons.utils.Environment;
import nva.commons.utils.log.LogUtils;
import nva.commons.utils.log.TestAppender;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UpdatePersonIdentifiersHandlerTest {

    private Context mockContext = mock(Context.class);
    private Environment mockEnvironment = setupMockEnvironment();
    private TestAppender testAppender;


    private Environment setupMockEnvironment() {
        Environment environment = mock(Environment.class);
        return environment;
    }


    UpdatePersonIdentifiersHandler setupMockHandler() throws ApiGatewayException {

        UpdatePersonIdentifiersHandler mockHandler = mock(UpdatePersonIdentifiersHandler.class);
        UpdatePersonIdentifierResponse emptyUpdateResponse = new UpdatePersonIdentifierResponse(null, null, null, null);
        when(mockHandler.processInput(any(), any(), any())).thenReturn(emptyUpdateResponse);
        testAppender = LogUtils.getTestingAppender(UpdatePersonIdentifiersHandler.class);
        return mockHandler;
    }

    @Test
    void handlerAcceptsSampleImportRequest() throws ApiGatewayException {
        UpdatePersonIdentifierRequest updatePersonIdentifierRequest = new UpdatePersonIdentifierRequest();
        setupMockHandler().processInput(updatePersonIdentifierRequest, new RequestInfo(), mockContext);

    }

    @Test
    void handlerThrowsExceptionWhenInputIsBad() {
        UpdatePersonIdentifiersHandler updateHandler = new UpdatePersonIdentifiersHandler(mockEnvironment);
        Executable executable = () -> updateHandler.processInput(null, null, mockContext);
        assertThrows(ApiGatewayException.class, executable);
    }

    @Test
    void getSuccessStatusCodeReturnsCodeFromResponse() throws ApiGatewayException {
        int imATeaPot = 418;
        UpdatePersonIdentifierResponse response = new UpdatePersonIdentifierResponse("",
                new UpdatePersonIdentifierRequest(),
                imATeaPot,
                Instant.now());
        UpdatePersonIdentifiersHandler updateHandler = new UpdatePersonIdentifiersHandler(mockEnvironment);
        Integer actualStatusCode = updateHandler.getSuccessStatusCode(null, response);
        assertEquals(imATeaPot, actualStatusCode);
    }

    @Test
    void handlerReturnsAcceptedWhenInputIsOK() throws ApiGatewayException {

        UpdatePersonIdentifierRequest updatePersonIdentifierRequest = new UpdatePersonIdentifierRequest();

        UpdatePersonIdentifierResponse updatePersonIdentifierResponse =
                setupMockHandler().processInput(updatePersonIdentifierRequest,
                new RequestInfo(),
                mockContext);

        UpdatePersonIdentifierResponse expected = new UpdatePersonIdentifierResponse(null,
                null,
                null,
                null);

        assertEquals(expected,updatePersonIdentifierResponse);
    }

}