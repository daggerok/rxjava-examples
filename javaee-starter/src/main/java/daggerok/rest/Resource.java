package daggerok.rest;

import javax.ejb.Stateless;
import javax.json.Json;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("")
@Stateless
@Produces(APPLICATION_JSON)
public class Resource {

  @Context UriInfo uriInfo;

  @GET
  @Path("")
  public Response index() {
/*
    return Response.ok(Json.createObjectBuilder()
                           .add("_self", uriInfo.getBaseUriBuilder()
                                                .path(Resource.class)
                                                .path(Resource.class, "index")
                                                .build()
                                                .toString())
                           .build()
                           .toString())
                   .build();
*/
    return Response.ok(Json.createObjectBuilder()
                           .add("_self", Json.createArrayBuilder()
                                             .add(Json.createObjectBuilder()
                                                      .add("_self", uriInfo.getBaseUriBuilder()
                                                                           .path(Resource.class)
                                                                           .path(Resource.class, "index")
                                                                           .build()
                                                                           .toString())))
                           .build()
                           .toString())
                   .build();
  }
}
