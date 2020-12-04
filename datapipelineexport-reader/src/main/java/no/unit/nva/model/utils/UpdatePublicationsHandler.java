package no.unit.nva.model.utils;

import com.amazonaws.services.lambda.runtime.Context;
import nva.commons.exceptions.ApiGatewayException;
import nva.commons.handlers.ApiGatewayHandler;
import nva.commons.handlers.RequestInfo;
import nva.commons.handlers.RestRequestHandler;
import nva.commons.utils.Environment;
import nva.commons.utils.JacocoGenerated;
import org.apache.http.HttpStatus;
import org.slf4j.LoggerFactory;

import java.time.Instant;

import static java.util.Objects.nonNull;
import static nva.commons.utils.StringUtils.isEmpty;

public class UpdatePublicationsHandler extends
        ApiGatewayHandler<ReadFromS3BucketRequest, UpdatePublicationsResponse> {

    public static final String MISSING_REQUIRED_PARAMETER = "Missing required parameter";
    public static final String JOB_STARTED_MESSAGE = "Job started";

    @JacocoGenerated
    public UpdatePublicationsHandler() {
        this(new Environment());
    }

    /**
     * Creates UpdatePersonIdentifiersHandler with the given environment.
     * @param environment containeg settings for function
     */
    public UpdatePublicationsHandler(Environment environment) {
        super(ReadFromS3BucketRequest.class,
                environment,
                LoggerFactory.getLogger(UpdatePublicationsHandler.class));
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
    protected UpdatePublicationsResponse processInput(ReadFromS3BucketRequest input,
                                                      RequestInfo requestInfo, Context context)
            throws ApiGatewayException {
        if (!parametersIsValid(input)) {
            return new UpdatePublicationsResponse(MISSING_REQUIRED_PARAMETER,
                    input,
                    HttpStatus.SC_BAD_REQUEST,
                    Instant.now());
        }
        return new UpdatePublicationsResponse(JOB_STARTED_MESSAGE, input, HttpStatus.SC_ACCEPTED, Instant.now());
    }

    private boolean parametersIsValid(ReadFromS3BucketRequest input) {
        return nonNull(input) && !isEmpty(input.getS3bucket()) && !isEmpty(input.getS3folderkey());
    }

    /**
     * Define the success status code.
     *
     * @param input  The request input.
     * @param output The response output
     * @return the success status code.
     */
    @Override
    protected Integer getSuccessStatusCode(ReadFromS3BucketRequest input, UpdatePublicationsResponse output) {
        return output.getStatusCode();
    }
}
