/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.examples;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.kie.kogito.rules.DataStore;

import io.smallrye.mutiny.Uni;
import io.vertx.mutiny.core.eventbus.EventBus;
import io.vertx.mutiny.core.eventbus.Message;

@Path("/2units")
public class TwoUnitsEndpoint {

    @Inject
    EventBus bus;

    public TwoUnitsEndpoint() {

    }

    @POST()
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Uni<List> executeQuery(org.kie.kogito.examples.ApplicantValidationUnit unitDTO) {
        Uni<DataStore> validatedUni = bus.<DataStore> request("applicant-validation", unitDTO.getLoanApplications())
                .onItem()
                .transform(Message::body);
        DataStore<LoanApplication> loanApplications = validatedUni.await().indefinitely();
        Uni<List> approvedUni = bus.<List> request("loan", loanApplications)
                .onItem()
                .transform(Message::body);
        return approvedUni;
    }
}
