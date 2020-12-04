package no.unit.nva.model.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNull;

class PublicationUtilTest {


    @Test
    public void createPublicationFromEmptySourceExpectedToFail() {
        String publicationJsonSource = "{}";
        var publication =  new PublicationUtil().getPublication(publicationJsonSource);
        assertNull(publication);
    }

}