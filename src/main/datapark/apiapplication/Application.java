package datapark.apiapplication;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

/**
 * Created by DATAPARK03 on 2015/9/8.
 */
@ApplicationPath("/v1")
public class Application extends ResourceConfig {
    public Application(){
        packages("datapark.SimhashServer");
    }
}