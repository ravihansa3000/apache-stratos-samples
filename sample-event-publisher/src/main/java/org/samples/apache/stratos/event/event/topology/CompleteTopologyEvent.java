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

package org.samples.apache.stratos.event.event.topology;

import org.apache.stratos.messaging.domain.topology.ServiceType;
import org.samples.apache.stratos.event.domain.topology.Service;
import org.samples.apache.stratos.event.domain.topology.Topology;
import org.samples.apache.stratos.event.event.SampleEventInterface;
import org.samples.apache.stratos.event.util.Utils;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Model class for CompleteTopologyEvent.
 */

@XmlRootElement(name = "CompleteTopologyEvent")
public class CompleteTopologyEvent extends TopologyEvent implements SampleEventInterface {
    private Topology topology;

    public CompleteTopologyEvent() {
    }

    public Topology getTopology() {
        return topology;
    }

    public void setTopology(Topology topology) {
        this.topology = topology;
    }

    @Override
    public String toString() {
        return String.format("[topology] %s", topology);
    }

    @Override
    public void process() {
        org.apache.stratos.messaging.domain.topology.Topology topology1 =
                new org.apache.stratos.messaging.domain.topology.Topology();
        for (Service service : topology.getServices()) {
            ServiceType serviceType = ServiceType.valueOf(service.getServiceType().name());
            org.apache.stratos.messaging.domain.topology.Service
                    service1 =
                    new org.apache.stratos.messaging.domain.topology.Service(service.getServiceName(), serviceType);

            topology1.addService(service1);
        }
        org.apache.stratos.messaging.event.topology.CompleteTopologyEvent
                completeTopologyEvent =
                new org.apache.stratos.messaging.event.topology.CompleteTopologyEvent(topology1);
        Utils.publishEvent(completeTopologyEvent);
    }
}