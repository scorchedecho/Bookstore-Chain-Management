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

package com.scorchedecho.bookstore.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Employee Entity class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Entity
@Data
public class Employee {
  // primary key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long employeeId;

  private String employeeFirstName;
  private String employeeLastName;
  private String employeePhone;
  private String employeeEmail;
  private String employeeJobTitle;

  // relationship variable
  @EqualsAndHashCode.Exclude
  @ToString.Exclude // prevent recursion
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "bookstore_id")
  private Bookstore bookstore;
}
