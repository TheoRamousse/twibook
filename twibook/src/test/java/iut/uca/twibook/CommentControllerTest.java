package iut.uca.twibook;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.HttpStatusCodeException;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class CommentControllerTest {
    @Test
    public void givenCommentDoesNotExists_whenCommentInfoIsRetrieved_then400IsReceived()
            throws HttpStatusCodeException, IOException {

        // Given
        String fakeCommentId = RandomStringUtils.randomAlphabetic( 3 );
        HttpUriRequest request = new HttpGet( "http://localhost:9000/comments/" + fakeCommentId );

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        assertEquals(
                httpResponse.getStatusLine().getStatusCode(),
                HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void givenAllCommentExist_whenCommentsInfoIsRetrieved_then200or204IsReceived()
            throws HttpStatusCodeException, IOException {

        // Given
        HttpUriRequest request = new HttpGet( "http://localhost:9000/comments/");

        // When
        HttpResponse httpResponse = HttpClientBuilder.create().build().execute( request );

        // Then
        switch (httpResponse.getStatusLine().getStatusCode()){
            case (HttpStatus.SC_OK):
                assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_OK);
                break;
            case (HttpStatus.SC_NO_CONTENT):
                assertEquals(httpResponse.getStatusLine().getStatusCode(), HttpStatus.SC_NO_CONTENT);
                break;
            default:
                fail();
        }
    }
}
