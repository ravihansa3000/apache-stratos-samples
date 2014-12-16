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
package org.samples.apache.stratos.event.model.topology;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Properties;

/**
 * Model class for InstanceSpawnedEvent.
 */

@XmlRootElement(name = "InstanceSpawnedEvent")
public class InstanceSpawnedEvent extends TopologyEvent {

    private static final Log log = LogFactory.getLog(InstanceSpawnedEvent.class);
    private String serviceName;
    private String clusterId;
    private String networkPartitionId;
    private String partitionId;
    private String memberId;
    private String lbClusterId;
    private String memberPublicIp;
    private String memberIp;
    private Properties properties;

    public InstanceSpawnedEvent() {

    }

    public InstanceSpawnedEvent(String serviceName, String clusterId, String networkPartitionId, String partitionId, String memberId) {
        this.serviceName = serviceName;
        this.clusterId = clusterId;
        this.networkPartitionId = networkPartitionId;
        this.partitionId = partitionId;
        this.memberId = memberId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getClusterId() {
        return clusterId;
    }

    public void setClusterId(String clusterId) {
        this.clusterId = clusterId;
    }

    public String getNetworkPartitionId() {
        return networkPartitionId;
    }

    public void setNetworkPartitionId(String networkPartitionId) {
        this.networkPartitionId = networkPartitionId;
    }

    public String getPartitionId() {
        return partitionId;
    }

    public void setPartitionId(String partitionId) {
        this.partitionId = partitionId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getLbClusterId() {
        return lbClusterId;
    }

    public void setLbClusterId(String lbClusterId) {
        this.lbClusterId = lbClusterId;
    }

    public String getMemberPublicIp() {
        return memberPublicIp;
    }

    public void setMemberPublicIp(String memberPublicIp) {
        this.memberPublicIp = memberPublicIp;
    }

    public String getMemberIp() {
        return memberIp;
    }

    public void setMemberIp(String memberIp) {
        this.memberIp = memberIp;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public String toString() {
        return String.format("[service] %s , [cluster-id] %s , [partition] %s , [network-partition] %s , [member] %s , [lb-cluster] %s , " +
                        "[public-ip] %s , [private-ip] %s , [properties] %s",
                serviceName, clusterId, partitionId, networkPartitionId, memberId, lbClusterId, memberPublicIp, memberIp, properties);
    }

    @Override
    public void process() {

        org.apache.stratos.messaging.event.topology.InstanceSpawnedEvent
                instanceSpawnedEvent = new org.apache.stratos.messaging.event.topology.InstanceSpawnedEvent(
                serviceName, clusterId, networkPartitionId, partitionId, memberId);
        instanceSpawnedEvent.setMemberIp(memberIp);
        instanceSpawnedEvent.setLbClusterId(lbClusterId);
        instanceSpawnedEvent.setMemberPublicIp(memberPublicIp);

        topologyPublisher.publish(instanceSpawnedEvent);
        if (log.isInfoEnabled()) {
            log.info(this.getClass().toString() + " Event published: " + this);
        }
    }
}
