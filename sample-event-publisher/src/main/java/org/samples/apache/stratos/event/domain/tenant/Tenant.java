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

package org.samples.apache.stratos.event.domain.tenant;

import javax.xml.bind.annotation.XmlType;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Tenant definition.
 */

@XmlType(name = "Tenant")
public class Tenant implements Serializable {
    private static final long serialVersionUID = 2154359124188618021L;
    private int tenantId;
    private String tenantDomain;
    private Map<String, Boolean> serviceNameMap;

    public Tenant(){

    }

    public Tenant(int tenantId, String tenantDomain) {
        this.tenantId = tenantId;
        this.tenantDomain = tenantDomain;
        this.serviceNameMap = new HashMap();
    }

    public int getTenantId() {
        return this.tenantId;
    }

    public String getTenantDomain() {
        return this.tenantDomain;
    }

    public void setTenantDomain(String tenantDomain) {
        this.tenantDomain = tenantDomain;
    }

    public Collection<String> getServiceSubscriptions() {
        return this.serviceNameMap.keySet();
    }

    public boolean isServiceSubscribed(String serviceName) {
        return this.serviceNameMap.containsKey(serviceName);
    }

    public void addServiceSubscription(String serviceName) {
        this.serviceNameMap.put(serviceName, Boolean.valueOf(true));
    }

    public void removeServiceSubscription(String serviceName) {
        this.serviceNameMap.remove(serviceName);
    }
}
