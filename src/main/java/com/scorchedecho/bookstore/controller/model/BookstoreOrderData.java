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

import com.scorchedecho.bookstore.entity.Book;
import com.scorchedecho.bookstore.entity.Bookstore;
import com.scorchedecho.bookstore.entity.Customer;
import com.scorchedecho.bookstore.entity.Orderb;
import java.util.HashSet;
import java.util.Set;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Order Data class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Data
@NoArgsConstructor
public class BookstoreOrderData {
  private Long orderId;
  private String orderDate;
  private Customer customer;
  private Bookstore bookstore;
  private Set<BookstoreBookData> books = new HashSet<>();

  /**
   * Constructor for OrderData.
   *
   * @param orderb the order to be converted to OrderData.
   */
  public BookstoreOrderData(Orderb orderb) {
    // copy all the fields from the Order to the OrderData
    this.orderId = orderb.getOrderId();
    this.orderDate = orderb.getOrderDate();
    this.customer = orderb.getCustomer();
    this.bookstore = orderb.getBookstore();
    for (Book book : orderb.getBooks()) {
      this.books.add(new BookstoreBookData(book));
    }
  }
}
