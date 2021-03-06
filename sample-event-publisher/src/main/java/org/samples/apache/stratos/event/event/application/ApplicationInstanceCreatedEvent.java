/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.samples.apache.stratos.event.event.application;

import org.samples.apache.stratos.event.domain.instance.ApplicationInstance;
import org.samples.apache.stratos.event.event.SampleEventInterface;
import org.samples.apache.stratos.event.util.Utils;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This event will be fired upon the application created is detected.
 */
@XmlRootElement(name = "ApplicationInstanceCreatedEvent")
public class ApplicationInstanceCreatedEvent extends ApplicationEvent implements SampleEventInterface {
    private String applicationId;
    private ApplicationInstance applicationInstance;

    public ApplicationInstanceCreatedEvent() {
    }

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public ApplicationInstance getApplicationInstance() {
        return applicationInstance;
    }

    public void setApplicationInstance(ApplicationInstance applicationInstance) {
        this.applicationInstance = applicationInstance;
    }

    @Override
    public void process() {
        org.apache.stratos.messaging.event.application.ApplicationInstanceCreatedEvent
                applicationInstanceCreatedEvent = new org.apache.stratos.messaging.event.application
                .ApplicationInstanceCreatedEvent(applicationId,
                new org.apache.stratos.messaging.domain.instance.ApplicationInstance(applicationInstance.getAlias
                        (), applicationInstance.getInstanceId()));
        Utils.publishEvent(applicationInstanceCreatedEvent);
    }

}
