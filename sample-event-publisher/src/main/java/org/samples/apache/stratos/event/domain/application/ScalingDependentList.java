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

package org.samples.apache.stratos.event.domain.application;

import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlType(name = "ScalingDependentList")
public class ScalingDependentList {

    private List<String> scalingDependentListComponents;

    public ScalingDependentList() {
    }

    public ScalingDependentList(List<String> scalingDependentList) {
        this.scalingDependentListComponents = scalingDependentList;
    }

    public List<String> getScalingDependentListComponents() {
        return scalingDependentListComponents;
    }

    public boolean isScalingDependent(String id) {
        return scalingDependentListComponents.contains(id);
    }

    public void setScalingDependentListComponents(List<String> scalingDependentListComponents) {
        this.scalingDependentListComponents = scalingDependentListComponents;
    }
}