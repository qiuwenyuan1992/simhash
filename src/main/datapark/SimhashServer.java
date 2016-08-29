package datapark;

import com.sun.net.httpserver.HttpServer;
import datapark.SimHashSample3.DuplicateJudge;
import datapark.SimHashSample3.DuplicateRemoversFactory;
import datapark.test.SimHasher;
import datapark.utils.PropertiesUtil;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.util.Map;


/**
 * Created by datapark-2 on 2015/11/25.
 */
@Path("/duplicateJudge")
public class SimhashServer {


    public static final Logger log = Logger.getLogger(SimhashServer.class.getName());
    private static Map configProperties = PropertiesUtil.getPropertyMap();

    @Path("charts")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String processDatas() {//��������

        String s = "{\n" +
                "\t\n" +
                "\t\"kpivalue\":\"all\",\n" +
                "\t\"starttime\":\"2015-01-01\",\n" +
                "\t\"charttype\":\"line\",\n" +
                "\t\"metricunit\":\"month\",\n" +
                "\t\"endtime\":\"2015-06-30\",\n" +
                "\t\"size\":10,\n" +
                "\t\"term\":\"material\",\n" +
                "\t\"category\":\"women\",\n" +
                "\t\"options\":[{\"brand_alias\":\"大众品牌\",\"src_name\":\"京东\"}]\n" +
                "}";
        log.info("test-processDatas");
        return s;
    }
    @POST
    @Path("simhash")
    @Produces({"application/json;charset=utf-8"})
    public String getMsg(String requestStr) {
        long start = System.currentTimeMillis();
        String responseStr = "";
        JSONObject requestStrObj = JSONObject.fromString(requestStr);
        String func = (String)requestStrObj.get("func");
        JSONObject requestDataObj = (JSONObject)requestStrObj.get("requestData");
        DuplicateJudge simHashJudge = DuplicateRemoversFactory.factory(func);
        responseStr = simHashJudge.duplicate(requestDataObj);
        log.info("func url is : "+requestDataObj.get("url") + " all time is " +(System.currentTimeMillis() -start));
        return responseStr;
    }

    public static void main(String[] args) throws Exception {

        ResourceConfig rc = new ResourceConfig(SimhashServer.class);
        try {
            URI serveruri = new URI("http://localhost:8080/");//192.168.31.111 192.168.31.176
            HttpServer server = JdkHttpServerFactory.createHttpServer(serveruri, rc);
            System.out.println("start");
            //HttpServer server = HttpServerFactory.create("http://192.168.31.177:8080/");
//            server.start();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}