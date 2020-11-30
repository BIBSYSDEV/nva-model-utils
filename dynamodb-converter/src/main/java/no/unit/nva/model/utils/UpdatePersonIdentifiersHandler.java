package no.unit.nva.model.utils;

import com.amazonaws.services.lambda.runtime.Context;
import nva.commons.exceptions.ApiGatewayException;
import nva.commons.handlers.ApiGatewayHandler;
import nva.commons.handlers.RequestInfo;
import nva.commons.handlers.RestRequestHandler;
import nva.commons.utils.Environment;
import nva.commons.utils.JacocoGenerated;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class UpdatePersonIdentifiersHandler extends
        ApiGatewayHandler<UpdatePersonIdentifierRequest, UpdatePersonIdentifierResponse> {

    public static final String MISSING_REQUIRED_PARAMERTERS = "Missing required paramerters";

    @JacocoGenerated
    public UpdatePersonIdentifiersHandler() {
        this(new Environment());
    }

    /**
     * Creates UpdatePersonIdentifiersHandler with the given environment.
     * @param environment containeg settings for function
     */
    public UpdatePersonIdentifiersHandler(Environment environment) {
        super(UpdatePersonIdentifierRequest.class,
                environment,
                LoggerFactory.getLogger(UpdatePersonIdentifiersHandler.class));
    }

    /**
     * Implements the main logic of the handler. Any exception thrown by this method will be handled by {@link
     * RestRequestHandler#handleExpectedException} method.
     *
     * @param input       The input object to the method. Usually a deserialized json.
     * @param requestInfo Request headers and path.
     * @param context     the ApiGateway context.
     * @return the Response body that is going to be serialized in json
     * @throws ApiGatewayException all exceptions are caught by writeFailure and mapped to error codes through the
     *                             method {@link RestRequestHandler#getFailureStatusCode}
     */
    @Override
    protected UpdatePersonIdentifierResponse processInput(UpdatePersonIdentifierRequest input,
                                                          RequestInfo requestInfo, Context context)
            throws ApiGatewayException {
        if (Objects.isNull(input)) {
            throw new InputException(MISSING_REQUIRED_PARAMERTERS);
        }
        return null;
    }

    /**
     * Define the success status code.
     *
     * @param input  The request input.
     * @param output The response output
     * @return the success status code.
     */
    @Override
    protected Integer getSuccessStatusCode(UpdatePersonIdentifierRequest input, UpdatePersonIdentifierResponse output) {
        return output.getStatusCode();
    }
}
