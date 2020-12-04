package no.unit.nva.model.utils.exceptions;

import no.unit.nva.model.utils.exceptions.InputException;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;


public class ExceptionsTest {

    public static final String DUMMY_ERROR_TEXT = "Dummy error text";

    @Test
    public void creatingInputExceptionDefaultConstructorReturnsBadRequest() {
        InputException invalidInputException = new InputException(DUMMY_ERROR_TEXT);
        assertThat(invalidInputException.getStatusCode(), is(equalTo(HttpStatus.SC_BAD_REQUEST)));
    }

}
