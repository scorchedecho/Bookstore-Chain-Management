/*
 *  Copyright 2024 scorchedE.C.H.O
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at:
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.scorchedecho.bookstore.controller.model;

import com.scorchedecho.bookstore.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bookstore Employee Data class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Data
@NoArgsConstructor
public class BookstoreEmployeeData {
  private long employeeId;
  private String employeeFirstName;
  private String employeeLastName;
  private String employeePhone;
  private String employeeEmail;
  private String employeeJobTitle;

  /**
   * Constructor for BookstoreEmployeeData.
   *
   * @param employee the employee to be converted to BookstoreEmployeeData
   */
  public BookstoreEmployeeData(Employee employee) {
    // copy all the fields from the Employee to the BookstoreEmployeeData
    this.employeeId = employee.getEmployeeId();
    this.employeeFirstName = employee.getEmployeeFirstName();
    this.employeeLastName = employee.getEmployeeLastName();
    this.employeePhone = employee.getEmployeePhone();
    this.employeeEmail = employee.getEmployeeEmail();
    this.employeeJobTitle = employee.getEmployeeJobTitle();
  }
}
