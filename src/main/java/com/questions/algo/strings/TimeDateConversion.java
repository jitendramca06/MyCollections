package com.questions.algo.strings;


import okhttp3.*;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.InputStreamBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.apache.http.impl.nio.conn.PoolingNHttpClientConnectionManager;
import org.apache.http.impl.nio.reactor.DefaultConnectingIOReactor;
import org.apache.http.impl.nio.reactor.IOReactorConfig;
import org.apache.http.nio.client.methods.HttpAsyncMethods;
import org.apache.http.nio.conn.NoopIOSessionStrategy;
import org.apache.http.nio.conn.SchemeIOSessionStrategy;
import org.apache.http.nio.conn.ssl.SSLIOSessionStrategy;
import org.apache.http.nio.protocol.BasicAsyncResponseConsumer;
import org.apache.http.nio.protocol.HttpAsyncRequestProducer;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.apache.http.nio.reactor.ConnectingIOReactor;
import org.apache.http.nio.reactor.IOReactorException;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * @author Jitendra Kumar : 18/12/18
 */
public class TimeDateConversion {
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss,SSS");
        dateFormat.setLenient(false);
        try {

            Date date = dateFormat.parse(inDate.trim());
            System.out.println(date);

            long miisec = date.getTime();
            miisec = miisec + 120000;
            long startTime = miisec - 420000;
            System.out.println(dateFormat.format(miisec));
            System.out.println(dateFormat.format(startTime));

            Calendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(date.getTime());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fmt.setTimeZone(TimeZone.getTimeZone("GMT"));
            System.out.println(fmt.format(calendar.getTime()));
        } catch (ParseException pe) {
            return false;
        }
        return true;
    }

    private static void isoToGMT(String d) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
        Date date = null;
        try {
            date = dateFormat.parse(d.trim());
            Calendar calendar = new GregorianCalendar();
            calendar.setTimeInMillis(date.getTime());
            SimpleDateFormat fmt = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            fmt.setTimeZone(TimeZone.getTimeZone("IST"));
            System.out.println(fmt.format(calendar.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private static void asyncCall() {
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)
                .setSocketTimeout(1000)
                .setConnectionRequestTimeout(1000)
                .build();
        IOReactorConfig config = IOReactorConfig.custom()
                .setIoThreadCount(2).build();

        ConnectingIOReactor ioReactor = null;
        try {
            ioReactor = new DefaultConnectingIOReactor(config);
        } catch (IOReactorException e) {
            System.out.println(e.getMessage());
        }

        PoolingNHttpClientConnectionManager cm = null;
        CloseableHttpAsyncClient client = null;

        cm = new PoolingNHttpClientConnectionManager(ioReactor, RegistryBuilder.<SchemeIOSessionStrategy>create()
                .register("http", NoopIOSessionStrategy.INSTANCE)
                .build());
        cm.setDefaultMaxPerRoute(20);
        cm.setMaxTotal(20);

        client = HttpAsyncClients.custom()
                .setConnectionManager(cm)
                .setDefaultRequestConfig(requestConfig).build();
        client.start();

        File inFile = new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar");
        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("File", inFile.getName(),RequestBody.create(MediaType.parse("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),inFile))
                .build();

        /*HttpAsyncRequestProducer request = null;
        try {
            request = HttpAsyncMethods.createPost("http://192.168.2.111:8081/jars/upload", body, ContentType.create("multipart/form-data;"));
        } catch (UnsupportedEncodingException e1) {
            System.out.println(e1.getMessage());
        }*/

        HttpAsyncResponseConsumer<HttpResponse> consumer = new BasicAsyncResponseConsumer();
    }


    private static void runFlinkJob() throws Exception {
        OkHttpClient client = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS).writeTimeout(180, TimeUnit.SECONDS).readTimeout(180, TimeUnit.SECONDS).build();
        int count = 5;
        while (count-- > 0) {
            File inFile = new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar");
            RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                    .addFormDataPart("File", inFile.getName(),RequestBody.create(MediaType.parse(""),inFile))
                    .build();
            Request request = new Request.Builder().url("http://192.168.2.111:8081/jars/upload").post(body).build();
            client.newCall(request).enqueue(new Callback() {

                @Override
                public void onFailure(Call call, IOException e) {
                    System.out.println(e.getMessage());
                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    String result = response.body().string();
                    System.out.println(result);
                }
            });
            //Thread.sleep(1000);
        }
        client.dispatcher().executorService().shutdown();



        //Response response = client.newCall(request).execute();
        //String result = response.body().string();
        //System.out.println(result);


        //InputStream inputStream = new FileInputStream("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar");
        /*CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://192.168.2.111:8081/jars/upload");
        MultipartEntityBuilder builder = MultipartEntityBuilder.create();
        String boundaryString = "------BoundaryXXXX";
        String crlf = "\r\n";
        String payloadString = "--"+boundaryString + crlf + "Content-Disposition: form-data;"
                + " name=\"jarfile\";"
                + " filename=\"sample.jar\""+crlf
                + "Content-Type: application/x-java-archive"+crlf+crlf;

        File inFile = new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar");
        FileInputStream fis = new FileInputStream(inFile);
        FileBody uploadFilePart = new FileBody(new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar"));


        builder.addPart( "file", uploadFilePart);
        builder.addBinaryBody("jarfile", new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar"));
        //builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
        //builder.addBinaryBody("name", new File("/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar"));
        HttpEntity multipart = builder.build();
        httpPost.setEntity(multipart);
        //httpPost.setHeader("Accept", "application/json");
        //httpPost.setHeader("Content-Disposition", "form-data; name=\"jarfile\"; filename=\"sample.jar\"");
        //httpPost.setHeader("Content-type", "application/x-java-archive");
        httpPost.setHeader("Content-Type", "multipart/form-data; boundary=" + boundaryString);

        System.out.println(payloadString);

        try{
            //StringEntity stringEntity = new StringEntity(payloadString);
            //httpPost.getRequestLine();
            //httpPost.setEntity(stringEntity);

            CloseableHttpResponse response = client.execute(httpPost);
            System.out.println(response);
            BufferedReader rd = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            String line = "";
            while ((line = rd.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }*/





        /*URL serverUrl = new URL("http://192.168.2.111:8081/jars/upload");

        HttpURLConnection urlConnection = (HttpURLConnection)
                serverUrl.openConnection();

        String boundaryString = "------BoundaryXXXX";
        String crlf = "\r\n";
        String fileUrl = "/home/jitendrak/Desktop/Appsone/Workplace/Flink/Examples/sample/classes/artifacts/sample_jar/sample.jar";
        File jarToUpload = new File(fileUrl);

        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setRequestProperty("Connection", "Keep-Alive");
        urlConnection.setRequestProperty("Cache-Control", "no-cache");
        urlConnection.addRequestProperty("Content-Type", "multipart/form-data;boundary=" + boundaryString);

                OutputStream outputStreamToRequestBody = urlConnection.getOutputStream();
        BufferedWriter httpRequestBodyWriter =
                new BufferedWriter(new OutputStreamWriter(outputStreamToRequestBody));

        String payloadString = boundaryString + crlf + "Content-Disposition:form-data;"
                + " name=\"jarfile\";"
                + " filename=\"sample.jar\""+crlf
                + "Content-Type: application/x-java-archive"+crlf+crlf;
        //System.out.println(payloadString);
        httpRequestBodyWriter.write(payloadString);
        httpRequestBodyWriter.flush();

        // Write the actual file contents
        FileInputStream inputStream = new FileInputStream(jarToUpload);

        int bytesRead;
        byte[] dataBuffer = new byte[1024];
        while((bytesRead = inputStream.read(dataBuffer)) != -1) {
            outputStreamToRequestBody.write(dataBuffer, 0, bytesRead);
        }

        outputStreamToRequestBody.flush();

        httpRequestBodyWriter.write(boundaryString +crlf);
        httpRequestBodyWriter.flush();

        inputStream.close();
        outputStreamToRequestBody.close();
        httpRequestBodyWriter.close();
        BufferedReader httpResponseReader =
                new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
        String lineRead;
        while((lineRead = httpResponseReader.readLine()) != null) {
            System.out.println(lineRead);
        }*/
    }

    public static void main(String[] args) throws Exception {
        //System.out.println(isValidDate("2018/01/08 12:34:49,430"));
        //isoToGMT("2019-02-18T15:40:56+08:30");
        runFlinkJob();
    }
}
