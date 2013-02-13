/**
 * Copyright 2013 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.samples.basicrest.server.rest;

import com.gwtplatform.samples.basicrest.shared.FieldVerifier;
import com.gwtplatform.samples.basicrest.shared.ResourcesPath;
import com.gwtplatform.samples.basicrest.shared.SendTextResult;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path(ResourcesPath.TEXT_PATH)
public class TextResource {
    @Context
    ServletContext context;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response sendText(@QueryParam("name") String input, @HeaderParam("User-Agent") String userAgent){
        Response.ResponseBuilder rb = null;

        // Verify that the input is valid.
        if (!FieldVerifier.isValidName(input)) {
            rb = Response.serverError().entity("Name must be at least 4 characters long");
        } else {
            String serverInfo = context.getServerInfo();

            String toSend = "Hello, " + input + "!<br><br>I am running " + serverInfo + ".<br><br>It looks like you are " +
                "using:<br>" + userAgent;
            SendTextResult result = new SendTextResult(toSend);

            rb = Response.ok().entity(result);
        }

        return rb.build();
    }
}
