package com.xsc.mundiagua

import java.io.IOException
import java.io.OutputStream
import java.io.InputStream
import com.amazonaws.serverless.exceptions.ContainerInitializationException
import com.amazonaws.serverless.proxy.spring.SpringBootLambdaContainerHandler
import com.amazonaws.serverless.proxy.model.AwsProxyResponse
import com.amazonaws.serverless.proxy.model.HttpApiV2ProxyRequest
import com.amazonaws.services.lambda.runtime.Context
import com.amazonaws.services.lambda.runtime.RequestStreamHandler
import java.lang.RuntimeException


class StreamLambdaHandler : RequestStreamHandler {
    companion object {
        private var handler: SpringBootLambdaContainerHandler<HttpApiV2ProxyRequest, AwsProxyResponse>? = null

        init {
            try {
                handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(MundiaguaApplication::class.java)
                // If you are using HTTP APIs with the version 2.0 of the proxy model, use the getHttpApiV2ProxyHandler
                // method: handler = SpringBootLambdaContainerHandler.getHttpApiV2ProxyHandler(Application.class);
            } catch (e: ContainerInitializationException) {
                // if we fail here. We re-throw the exception to force another cold start
                e.printStackTrace()
                throw RuntimeException("Could not initialize Spring Boot application", e)
            }
        }
    }

    @Throws(IOException::class)
    override fun handleRequest(inputStream: InputStream?, outputStream: OutputStream?, context: Context?) {
        handler!!.proxyStream(inputStream, outputStream, context)
    }
}