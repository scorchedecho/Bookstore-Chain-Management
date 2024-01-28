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
import com.scorchedecho.bookstore.entity.Order;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Bookstore Customer Data class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Data
@NoArgsConstructor
public class BookstoreCustomerData {
  private long customerId;
  private String customerFirstName;
  private String customerLastName;
  private String customerPhone;
  private String customerEmail;
  private Set<BookstoreData> bookstores = new HashSet<>();
  private Set<BookstoreOrderData> orders = new HashSet<>();

  /**
   * Constructor for BookstoreCustomerData.
   *
   * @param customer the customer to be converted to BookstoreCustomerData
   */
  public BookstoreCustomerData(Customer customer) {
    // copy all the fields from the Customer to the BookstoreCustomerData
    this.customerId = customer.getCustomerId();
    this.customerFirstName = customer.getCustomerFirstName();
    this.customerLastName = customer.getCustomerLastName();
    this.customerPhone = customer.getCustomerPhone();
    this.customerEmail = customer.getCustomerEmail();

    for (Bookstore bookstore : customer.getBookstores()) {
      this.bookstores.add(new BookstoreData(bookstore));
    }
    for (Order order : customer.getOrders()) {
      this.orders.add(new BookstoreOrderData(order));
    }
  }
}
