package no.unit.nva.model.utils;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import nva.commons.utils.JacocoGenerated;

import java.util.Objects;

public class ReadFromS3BucketRequest {

    private final String s3bucket;
    private final String s3folderkey;

    @JacocoGenerated
    @JsonCreator
    public ReadFromS3BucketRequest(@JsonProperty("s3bucket") String s3bucket,
                             @JsonProperty("s3folderkey") String s3folderkey) {
        this.s3bucket = s3bucket;
        this.s3folderkey = s3folderkey;
    }

    protected ReadFromS3BucketRequest(Builder builder) {
        this.s3bucket = builder.s3bucket;
        this.s3folderkey = builder.s3folderkey;
    }

    public String getS3bucket() {
        return s3bucket;
    }

    public String getS3folderkey() {
        return s3folderkey;
    }

    @JacocoGenerated
    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof ReadFromS3BucketRequest)) {
            return false;
        }
        ReadFromS3BucketRequest that = (ReadFromS3BucketRequest) o;
        return Objects.equals(s3bucket, that.s3bucket)
                && Objects.equals(s3folderkey, that.s3folderkey);
    }

    @JacocoGenerated
    @Override
    public int hashCode() {
        return Objects.hash(s3bucket, s3folderkey);
    }

    public static final class Builder {

        private String s3bucket;
        private String s3folderkey;

        public Builder() {
        }

        public ReadFromS3BucketRequest.Builder withS3Bucket(String s3bucket) {
            this.s3bucket = s3bucket;
            return this;
        }

        public ReadFromS3BucketRequest.Builder withS3FolderKey(String s3folderkey) {
            this.s3folderkey = s3folderkey;
            return this;
        }

        public ReadFromS3BucketRequest build() {
            return new ReadFromS3BucketRequest(this);
        }

    }
}