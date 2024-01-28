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

import com.scorchedecho.bookstore.entity.Bookstore;
import com.scorchedecho.bookstore.entity.Customer;
import com.scorchedecho.bookstore.entity.Employee;
import com.scorchedecho.bookstore.entity.Order;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bookstore Data class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Data
@NoArgsConstructor
public class BookstoreData {
  private long bookstoreId;
  private String bookstoreName;
  private String bookstoreAddress;
  private String bookstoreCity;
  private String bookstoreState;
  private String bookstoreZip;
  private String bookstorePhone;
  private Set<Customer> customers = new HashSet<>();
  private Set<Order> orders = new HashSet<>();
  private Set<Employee> employees = new HashSet<>();

  /**
   * Constructor for BookstoreData.
   *
   * @param bookstore the bookstore to be converted to BookstoreData
   */
  public BookstoreData(Bookstore bookstore) {
    // copy all the fields from the Bookstore to the BookstoreData
    this.bookstoreId = bookstore.getBookstoreId();
    this.bookstoreName = bookstore.getBookstoreName();
    this.bookstoreAddress = bookstore.getBookstoreAddress();
    this.bookstoreCity = bookstore.getBookstoreCity();
    this.bookstoreState = bookstore.getBookstoreState();
    this.bookstoreZip = bookstore.getBookstoreZip();
    this.bookstorePhone = bookstore.getBookstorePhone();
    this.customers = bookstore.getCustomers();
    this.orders = bookstore.getOrders();
    this.employees = bookstore.getEmployees();
  }
}
