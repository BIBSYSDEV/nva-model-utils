package no.unit.nva.model.utils;

import nva.commons.utils.JacocoGenerated;

import java.time.Instant;
import java.util.Objects;

public class UpdatePublicationsResponse {

    private final String message;
    private final ReadFromS3BucketRequest request;
    private final Integer statusCode;
    private final Instant timestamp;

    /**
     * Creates a response telling how the DataImport was started and when.
     * @param message message telling the status
     * @param request echoed parameters from the import
     * @param statusCode was the import started
     * @param timestamp when the request was handled
     */
    public UpdatePublicationsResponse(String message,
                                      ReadFromS3BucketRequest request,
                                      Integer statusCode,
                                      Instant timestamp) {
        this.message = message;
        this.request = request;
        this.statusCode = statusCode;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public ReadFromS3BucketRequest getRequest() {
        return request;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    @JacocoGenerated
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdatePublicationsResponse that = (UpdatePublicationsResponse) o;
        return Objects.equals(getMessage(), that.getMessage())
                && Objects.equals(getRequest(), that.getRequest())
                && Objects.equals(getTimestamp(), that.getTimestamp())
                && Objects.equals(getStatusCode(), that.getStatusCode());
    }

    @JacocoGenerated
    @Override
    public int hashCode() {
        return Objects.hash(getMessage(), getStatusCode());
    }

}

