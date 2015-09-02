/*
 * Copyright 2011 ArcBees Inc.
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

package com.gwtplatform.samples.basic.server.dispatch;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.google.inject.Provider;
import com.gwtplatform.samples.basic.shared.FieldVerifier;
import com.gwtplatform.samples.basic.shared.TextResponse;

@Path("/text")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SendTextResource {
    private final Provider<HttpServletRequest> requestProvider;
    private final ServletContext servletContext;

    @Inject
    SendTextResource(
            Provider<HttpServletRequest> requestProvider,
            ServletContext servletContext) {
        this.requestProvider = requestProvider;
        this.servletContext = servletContext;
    }

    @POST
    public Response execute(String text) {
        if (!FieldVerifier.isValidName(text)) {
            return Response.status(Status.BAD_REQUEST).entity("Name must be at least 4 characters long.").build();
        }

        String serverInfo = servletContext.getServerInfo();
        String userAgent = requestProvider.get().getHeader("User-Agent");
        String response = String.format("Hello, %s!<br/><br/>I am running %s.<br/><br/>" +
                "It looks like you are using:<br/>%s", text, serverInfo, userAgent);

        return Response.ok(new TextResponse(response)).build();
    }
}
