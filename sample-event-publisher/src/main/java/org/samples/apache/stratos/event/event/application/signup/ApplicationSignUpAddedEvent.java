/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.samples.apache.stratos.event.event.application.signup;

import org.samples.apache.stratos.event.event.SampleEventInterface;
import org.samples.apache.stratos.event.util.Utils;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Application signup added event.
 */
@XmlRootElement(name = "ApplicationSignUpAddedEvent")
public class ApplicationSignUpAddedEvent extends ApplicationSignUpEvent implements SampleEventInterface {
    private String applicationId;
    private int tenantId;
    private List<String> clusterIds;

    public ApplicationSignUpAddedEvent() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public int getTenantId() {
        return tenantId;
    }

    public void setTenantId(int tenantId) {
        this.tenantId = tenantId;
    }

    public List<String> getClusterIds() {
        return clusterIds;
    }

    public void setClusterIds(List<String> clusterIds) {
        this.clusterIds = clusterIds;
    }

    @Override
    public void process() {
        org.apache.stratos.messaging.event.application.signup.ApplicationSignUpAddedEvent applicationSignUpAddedEvent
                = new org.apache.stratos.messaging.event.application.signup.ApplicationSignUpAddedEvent
                (applicationId, tenantId, clusterIds);
        Utils.publishEvent(applicationSignUpAddedEvent);
    }
}
