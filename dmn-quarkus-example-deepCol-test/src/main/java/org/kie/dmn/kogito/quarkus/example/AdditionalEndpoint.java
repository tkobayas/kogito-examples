package org.kie.dmn.kogito.quarkus.example;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class AdditionalEndpoint {

    public AdditionalEndpoint() {
        //
    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("helloStr")
    public Collection<Collection<String>> helloColString(Collection<Collection<String>> inputData) {
        Collection<Collection<String>> result = Arrays.asList(Arrays.asList("abc", "efg"));
        return result;
    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("helloMyData")
    public MyData helloMyData(MyData inputData) {
        MyData result = new MyData();
        return result;
    }
}
