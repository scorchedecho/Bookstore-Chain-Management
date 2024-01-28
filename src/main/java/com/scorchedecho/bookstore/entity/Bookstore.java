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
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Bookstore Entity class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Entity
@Data
public class Bookstore {
  // primary key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long bookstoreId;

  private String bookstoreName;
  private String bookstoreAddress;
  private String bookstoreCity;
  private String bookstoreState;
  private String bookstoreZip;
  private String bookstorePhone;

  // relationship variable
  @EqualsAndHashCode.Exclude
  @ToString.Exclude // prevent recursion
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(name = "bookstore_customer",
      joinColumns = @JoinColumn(name = "bookstore_id"),
      inverseJoinColumns = @JoinColumn(name = "customer_id"))
  private Set<Customer> customers = new HashSet<>();

  // relationship variable
  @EqualsAndHashCode.Exclude
  @ToString.Exclude // prevent recursion
  @OneToMany(mappedBy = "bookstore", cascade = CascadeType.PERSIST)
  private Set<Order> orders = new HashSet<>();

  // relationship variable
  @EqualsAndHashCode.Exclude
  @ToString.Exclude // prevent recursion
  @OneToMany(mappedBy = "bookstore", cascade = CascadeType.ALL, orphanRemoval = true)
  private Set<Employee> employees = new HashSet<>();

  // relationship variable
  @EqualsAndHashCode.Exclude
  @ToString.Exclude // prevent recursion
  @ManyToMany(mappedBy = "bookstores", cascade = CascadeType.ALL) // TODO ask about this
  private Set<Book> books = new HashSet<>();
}
