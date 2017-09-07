package com.flyingrain.translate.dungeon.api;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.io.InputStream;

/**
 * Created by wally on 9/7/17.
 */
@Path("/upload")
public interface DungeonFileuploadResource {

    @POST
    @Path("/dungeonImg")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    @Produces(MediaType.APPLICATION_JSON)
    int uploadImg(@FormDataParam("file")InputStream inputStream, @FormDataParam("file")FormDataContentDisposition dataContentDisposition);
}
