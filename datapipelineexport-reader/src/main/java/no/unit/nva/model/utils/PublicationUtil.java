package no.unit.nva.model.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import nva.commons.utils.JacocoGenerated;
import nva.commons.utils.JsonUtils;
import org.elasticsearch.cluster.coordination.Publication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PublicationUtil {

    private static final ObjectMapper mapper = JsonUtils.objectMapper;
    private static final Logger logger = LoggerFactory.getLogger(PublicationUtil.class);
    public static final String ERROR_READING_PUBLICATION_MESSAGE = "Error reading publication source";

    /**
     * Creates a publication from JSON source.
     * @param publicationJsonSource string containing publication in json
     * @return Publicaiton object created from json source
     */
    @JacocoGenerated
    public Publication getPublication(String publicationJsonSource)  {
        try {
            return mapper.readValue(publicationJsonSource, Publication.class);
        } catch (JsonProcessingException e) {
            logger.error(ERROR_READING_PUBLICATION_MESSAGE,e);
            return null;
        }
    }
}
