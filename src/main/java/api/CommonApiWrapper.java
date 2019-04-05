package api;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import helpers.Utilities;

public class CommonApiWrapper {
    private static final Logger logger = Logger.getLogger(CommonApiWrapper.class.getName());
    private HttpClient httpclient = HttpClients.createDefault();
    private JsonHelper jsonHelper = new JsonHelper();
    protected String baseUrl = Utilities.getPropertyFromAppProp("baseUrl");
    private final String newLine = "\n";

    protected static int deleteStatus, getStatus, postStatus;

    protected Object post(Object payload, String endpoint) throws IOException {
        HttpPost httpPost = new HttpPost(endpoint);
        logger.info("Post HTTP method initialized: " + httpPost);
        StringEntity requestEntity = new StringEntity(jsonHelper.parseJavaObjectsToJson(payload),
            ContentType.APPLICATION_JSON);
        logger.info("POST REQUEST " + jsonHelper.parseJavaObjectsToJson(payload));
        httpPost.setEntity(requestEntity);
        HttpResponse response = httpclient.execute(httpPost);
        postStatus = response.getStatusLine().getStatusCode();
        Object responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
        ), payload.getClass());
        logger.info("POST HTTP RESPONSE " + postStatus);
        logger.info("POST RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto) + newLine);

        return responseDto;
    }

    protected Object get(Object payload, String endpoint) throws IOException {
        HttpGet httpGet = new HttpGet(endpoint);
        logger.info("Get HTTP method initialized: " + httpGet);
        HttpResponse response = httpclient.execute(httpGet);
        getStatus = response.getStatusLine().getStatusCode();
        Object responseDto = jsonHelper.parseJsonToJava(EntityUtils.toString(response.getEntity()
        ), payload.getClass());
        logger.info("GET HTTP RESPONSE " + getStatus);
        logger.info("GET RESPONSE " + jsonHelper.parseJavaObjectsToJson(responseDto) + newLine);

        return responseDto;
    }

    protected void delete(String endpoint) throws IOException{
        HttpDelete httpDelete = new HttpDelete(endpoint);
        logger.info("Delete HTTP method initialized" + httpDelete);
        HttpResponse response = httpclient.execute(httpDelete);
        deleteStatus = response.getStatusLine().getStatusCode();
        logger.info("DELETE HTTP RESPONSE " + deleteStatus + newLine);
    }
}
