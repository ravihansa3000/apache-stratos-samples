#!/bin/bash
# --------------------------------------------------------------
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
#     http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
# KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
# --------------------------------------------------------------
#
host_ip="localhost"
host_port=9443

set -e

echo "" && echo "Undeploying application..."
curl -X POST -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/applications/single-cartridge-app-kub/undeploy

sleep 10

echo "" && echo "Deleting application..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/applications/single-cartridge-app-kub

echo "" && echo "Removing cartridges..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/cartridges/php-kub

echo "" && echo "Removing autoscale policies..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/autoscalingPolicies/autoscaling-policy_kub

echo "" && echo "Removing deployment policies..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/deploymentPolicies/deployment-policy_kub

echo "" && echo "Removing application policies..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/applicationPolicies/application-policy_kub

echo "" && echo "Removing network partitions..."
curl -X DELETE -H "Content-Type: application/json" -k -u ${AUTH_CREDENTIALS} https://${host_ip}:${host_port}/api/networkPartitions/network-partition_vagrant-kub

