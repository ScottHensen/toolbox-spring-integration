/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.scotthensen.toolbox.si.siia.messageschannels;

import java.util.ArrayList;
import java.util.List;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Marius Bogoevici
 */
@Slf4j
public class AuditService {

  private List<AuditRecord> auditRecords = new ArrayList<>();

  public void audit(Object auditedPayload) {
      auditRecords.add(new AuditRecord(auditedPayload));
      log.debug("\n>>> audit data: {}", auditedPayload);
  }

  public List<AuditRecord> getAuditRecords() {
      return auditRecords;
  }
}
