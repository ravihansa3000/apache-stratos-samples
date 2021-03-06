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

package org.samples.apache.stratos.event.domain.topology;

import javax.xml.bind.annotation.XmlType;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Defines a topology of serviceMap in Stratos.
 */

@XmlType(name = "Topology")
public class Topology {

    // Key: Service.serviceName
    private Map<String, Service> serviceMap;
    private boolean initialized;

    public Topology() {
        this.serviceMap = new HashMap<String, Service>();
    }

    public Collection<Service> getServices() {
        return serviceMap.values();
    }

    public void addService(Service service) {
        this.serviceMap.put(service.getServiceName(), service);
    }

    public void addServices(Collection<Service> services) {
        for (Service service : services) {
            addService(service);
        }
    }

    public void removeService(Service service) {
        this.serviceMap.remove(service.getServiceName());
    }

    public void removeService(String serviceName) {
        this.serviceMap.remove(serviceName);
    }

    public Service getService(String serviceName) {
        return this.serviceMap.get(serviceName);
    }

    public boolean serviceExists(String serviceName) {
        return this.serviceMap.containsKey(serviceName);
    }

    public void clear() {
        this.serviceMap.clear();
    }

    public boolean isInitialized() {
        return initialized;
    }

    public void setInitialized(boolean initialized) {
        this.initialized = initialized;
    }

    public Map<String, Service> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(Map<String, Service> serviceMap) {
        this.serviceMap = serviceMap;
    }
}
