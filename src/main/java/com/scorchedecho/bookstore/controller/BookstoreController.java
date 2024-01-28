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

package com.scorchedecho.bookstore.controller;

import com.scorchedecho.bookstore.controller.model.BookstoreCustomerData;
import com.scorchedecho.bookstore.controller.model.BookstoreData;
import com.scorchedecho.bookstore.controller.model.BookstoreEmployeeData;
import com.scorchedecho.bookstore.service.BookstoreService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Bookstore Controller class of the Bookstore application
 * This class is used to handle all requests that come into the application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@RestController
// the base path for all requests in this controller.
// for example, a request to http://localhost:8080/bookstore/{request ...}
@RequestMapping("/bookstore")
@Slf4j
public class BookstoreController {
  // inject service
  @Autowired
  private BookstoreService bookstoreService;

  // PLANNING
  // No methods are yet implemented in this controller.

  /* *************************************
   * BOOKSTORE METHODS                   *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  /**
   * Create a new bookstore.
   */
  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public BookstoreData createBookstore() {

  }

  @PostMapping("/{bookstoreId}")
  public BookstoreData updateBookstore() {

  }

  @DeleteMapping("/{bookstoreId}")
  public BookstoreData deleteBookstore() {

  }

  @GetMapping
  public List<BookstoreData> getAllBookstores() {

  }

  @GetMapping("/{bookstoreId}")
  public BookstoreData getBookstoreById() {

  }

  /* *************************************
   * BOOKSTORE EMPLOYEE METHODS          *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public BookstoreEmployeeData createEmployee() {

  }

  @PutMapping("/{booktoreId}/employee/{employeeId}")
  public BookstoreEmployeeData updateEmployee() {

  }

  @DeleteMapping("/{bookstoreId}/employee/{employeeId}")
  public BookstoreEmployeeData deleteEmployee() {

  }

  @GetMapping("/{bookstoreId}/employee")
  public List<BookstoreEmployeeData> getAllEmployeesByBookstoreId() {

  }

  @GetMapping("/{bookstoreId}/employee/{employeeId}")
  public BookstoreEmployeeData getEmployeeById() {

  }

  /* *************************************
   * BOOKSTORE CUSTOMER METHODS          *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public BookstoreCustomerData createCustomer() {

  }

  @PutMapping("/{bookstoreId}/customer/{customerId}")
  public BookstoreCustomerData updateCustomer() {

  }

  @GetMapping("/{bookstoreId}/customer")
  public List<BookstoreCustomerData> getAllCustomersByBookstoreId() {

  }

  @GetMapping("/{bookstoreId}/customer/{customerId}")
  public BookstoreCustomerData getCustomerById() {

  }

  /* *************************************
   * BOOKSTORE BOOKS METHODS             *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public BookstoreData createBook() {

  }

  @PutMapping("/{bookstoreId}/{bookId}")
  public BookstoreData updateBook() {

  }

  @DeleteMapping("/{bookstoreId}/{bookId}")
  public BookstoreData deleteBook() {

  }

  @GetMapping("/{bookstoreId}/book")
  public List<BookstoreData> getAllBooksByBookstoreId() {

  }

  @GetMapping("/{bookstoreId}/{bookId}")
  public BookstoreData getBookById() {

  }

  @GetMapping("/{bookstoreId}/genre")
  public List<BookstoreData> getAllBooksByGenre() {

  }

  /* *************************************
   * ORDER METHODS                       *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  @PostMapping()
  @ResponseStatus(code = HttpStatus.CREATED)
  public BookstoreData createOrder() {

  }

  @PutMapping("/{bookstoreId}/{orderId}")
  public BookstoreData updateOrder() {

  }

  @GetMapping("/{bookstoreId}/order")
  public List<BookstoreData> getAllOrdersByBookstoreId() {

  }

  @GetMapping("/{bookstoreId}/{orderId}")
  public BookstoreData getOrderById() {

  }
}
