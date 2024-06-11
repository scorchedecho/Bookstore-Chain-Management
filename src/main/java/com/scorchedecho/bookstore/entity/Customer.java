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
import jakarta.persistence.ManyToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.ToString.Exclude;

/**
 * Customer Entity class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Entity
@Data
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Customer {

  // primary key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long customerId;

  private String customerFirstName;
  private String customerLastName;
  private String customerPhone;
  private String customerEmail;

  // relationship variable
  @EqualsAndHashCode.Exclude
  @Exclude // prevent recursion
  @ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
  private Set<Bookstore> bookstores = new HashSet<>();
}
