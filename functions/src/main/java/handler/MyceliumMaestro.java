package handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.amazonaws.services.lambda.runtime.logging.LogLevel;
import java.util.Map;

public class MyceliumMaestro implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

  @Override
  public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
    LambdaLogger LOGGER = context.getLogger();

    Map<String, String> pathParams = input.getPathParameters();
    Map<String, String> queryParams = input.getQueryStringParameters();

    for (Map.Entry<String, String> entry : pathParams.entrySet()) {
      LOGGER.log("path: " + entry.getKey() + "=" + entry.getValue(), LogLevel.INFO);
    }

    for (Map.Entry<String, String> entry : queryParams.entrySet()) {
      LOGGER.log("query: " + entry.getKey() + "=" + entry.getValue(), LogLevel.INFO);
    }

    return new APIGatewayProxyResponseEvent()
        .withBody("{}")
        .withIsBase64Encoded(false)
        .withStatusCode(200);
  }
}