package no.unit.nva.model.utils;

import com.amazonaws.services.lambda.runtime.Context;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import no.unit.nva.testutils.HandlerRequestBuilder;
import nva.commons.handlers.ApiGatewayHandler;
import nva.commons.handlers.GatewayResponse;
import nva.commons.utils.Environment;
import nva.commons.utils.log.TestAppender;
import org.apache.http.entity.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static nva.commons.utils.JsonUtils.objectMapper;
import static org.apache.http.HttpHeaders.CONTENT_TYPE;
import static org.apache.http.HttpStatus.SC_ACCEPTED;
import static org.apache.http.HttpStatus.SC_BAD_REQUEST;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class UpdatePublicationsHandlerTest {

    private static final String SAMPLE_S3_BUCKET = "bucket";
    private static final String SAMPLE_S3_KEY = "key";
    public static final String WILDCARD = "*";

    private TestAppender testAppender;
    private Context context;
    private UpdatePublicationsHandler updateHandler;
    private ByteArrayOutputStream output;

    public static final JavaType PARAMETERIZED_GATEWAY_RESPONSE_UPDATEPUBLICATION_RESPONSE_TYPE = objectMapper
            .getTypeFactory()
            .constructParametricType(GatewayResponse.class, UpdatePublicationsResponse.class);

    @BeforeEach
    private void  setup() {
        Environment environment = mock(Environment.class);
        when(environment.readEnv(ApiGatewayHandler.ALLOWED_ORIGIN_ENV)).thenReturn(WILDCARD);

        updateHandler = new UpdatePublicationsHandler(environment);
        context = mock(Context.class);
        output = new ByteArrayOutputStream();
    }

    @Test
    void handlerReturnsBadRequestWhenInputIsEmpty() throws IOException {
        var request = new ReadFromS3BucketRequest("","");

        var requestStream = new HandlerRequestBuilder<ReadFromS3BucketRequest>(objectMapper)
                .withHeaders(generateHeaders())
                .build();
        updateHandler.handleRequest(requestStream, output, context);
        GatewayResponse<UpdatePublicationsResponse> gatewayResponse = toGatewayResponse();
        assertEquals(SC_BAD_REQUEST, gatewayResponse.getStatusCode());
    }

    @Test
    void handlerReturnsBadRequestWhenInputIsPartialEmpty() throws IOException {
        var request = new ReadFromS3BucketRequest("",null);

        var requestStream = new HandlerRequestBuilder<ReadFromS3BucketRequest>(objectMapper)
                .withHeaders(generateHeaders())
                .withBody(request)
                .build();
        updateHandler.handleRequest(requestStream, output, context);
        GatewayResponse<UpdatePublicationsResponse> gatewayResponse = toGatewayResponse();
        assertEquals(SC_BAD_REQUEST, gatewayResponse.getStatusCode());

        request = new ReadFromS3BucketRequest(null,"");

        requestStream = new HandlerRequestBuilder<ReadFromS3BucketRequest>(objectMapper)
                .withHeaders(generateHeaders())
                .withBody(request)
                .build();
        updateHandler.handleRequest(requestStream, output, context);
        assertEquals(SC_BAD_REQUEST, gatewayResponse.getStatusCode());

        request = new ReadFromS3BucketRequest(null,null);

        requestStream = new HandlerRequestBuilder<ReadFromS3BucketRequest>(objectMapper)
                .withHeaders(generateHeaders())
                .withBody(request)
                .build();
        updateHandler.handleRequest(requestStream, output, context);
        assertEquals(SC_BAD_REQUEST, gatewayResponse.getStatusCode());


    }



    @Test
    void handlerReturnsAcceptedWhenInputIsValid() throws IOException {
        updateHandler.handleRequest(generateInputStreamWithValidBodyAndHeaders(), output, context);
        GatewayResponse<UpdatePublicationsResponse> gatewayResponse = toGatewayResponse();
        assertEquals(SC_ACCEPTED, gatewayResponse.getStatusCode());

    }

    private InputStream generateInputStreamWithValidBodyAndHeaders() throws
            IOException {
        return new HandlerRequestBuilder<ReadFromS3BucketRequest>(objectMapper)
                .withBody(createReadFromS3BucketRequest())
                .withHeaders(generateHeaders())
                .build();
    }

    private ReadFromS3BucketRequest createReadFromS3BucketRequest() {
        ReadFromS3BucketRequest request = new ReadFromS3BucketRequest.Builder()
                .withS3Bucket(SAMPLE_S3_BUCKET)
                .withS3FolderKey(SAMPLE_S3_KEY)
                .build();
        return  request;
    }

    private Map<String, String> generateHeaders() {
        Map<String, String> headers = new ConcurrentHashMap<>();
        headers.put(CONTENT_TYPE, ContentType.APPLICATION_JSON.getMimeType());
        return headers;
    }

    private GatewayResponse<UpdatePublicationsResponse> toGatewayResponse() throws JsonProcessingException {
        return objectMapper.readValue(output.toString(),
                PARAMETERIZED_GATEWAY_RESPONSE_UPDATEPUBLICATION_RESPONSE_TYPE);
    }

}