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

package org.samples.apache.stratos.event.event.application;

import org.samples.apache.stratos.event.event.SampleEventInterface;
import org.samples.apache.stratos.event.util.Utils;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * This event is fired by cartridge agent when it has started the server and
 * applications are ready to serve the incoming requests.
 */
@XmlRootElement(name = "GroupInstanceTerminatedEvent")
public class GroupInstanceTerminatedEvent extends ApplicationEvent implements SampleEventInterface {
    private String groupId;
    private String appId;
    private String instanceId;

    public GroupInstanceTerminatedEvent() {
    }

    public String getGroupId() {
        return this.groupId;
    }

    public String getAppId() {
        return appId;
    }

    public String getInstanceId() {
        return instanceId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setInstanceId(String instanceId) {
        this.instanceId = instanceId;
    }

    @Override
    public void process() {
        org.apache.stratos.messaging.event.application.GroupInstanceTerminatedEvent groupInstanceTerminatedEvent =
                new org.apache.stratos.messaging.event.application.GroupInstanceTerminatedEvent(appId, groupId,
                        instanceId);
        Utils.publishEvent(groupInstanceTerminatedEvent);
    }
}