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

package com.scorchedecho.bookstore.service;

import com.scorchedecho.bookstore.controller.model.BookstoreBookData;
import com.scorchedecho.bookstore.controller.model.BookstoreCustomerData;
import com.scorchedecho.bookstore.controller.model.BookstoreData;
import com.scorchedecho.bookstore.controller.model.BookstoreEmployeeData;
import com.scorchedecho.bookstore.controller.model.BookstoreOrderData;
import com.scorchedecho.bookstore.dao.BookDao;
import com.scorchedecho.bookstore.dao.CustomerDao;
import com.scorchedecho.bookstore.dao.EmployeeDao;
import com.scorchedecho.bookstore.entity.Book;
import com.scorchedecho.bookstore.entity.Bookstore;
import com.scorchedecho.bookstore.entity.Customer;
import com.scorchedecho.bookstore.entity.Employee;
import com.scorchedecho.bookstore.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Pet Store Service class of the Pet Store application.
 *
 * @author Ari
 * @since  2024-01-26
 */
@Service
public class BookstoreService {
  // inject DAOs
  @Autowired
  private BookDao bookstoreDao;
  @Autowired
  private CustomerDao customerDao;
  @Autowired
  private EmployeeDao employeeDao;
  @Autowired
  private BookDao bookDao;

  // PLANNING
  // No methods are yet implemented in this service.

  /* *************************************
   * BOOKSTORE METHODS                   *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  @Transactional
  public BookstoreData saveBookstore(BookstoreData bookstoreData) {

  }

  private Bookstore findOrCreateBookstore(BookstoreData bookstoreData) {

  }

  private Bookstore findBookstore(long bookstoreId) {

  }

  private void copyBookstoreData(Bookstore bookstore, BookstoreData bookstoreData) {

  }

  private void deleteBookstore(long bookstoreId) {

  }

  /* *************************************
   * BOOKSTORE EMPLOYEE METHODS          *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  @Transactional
  public BookstoreEmployeeData saveEmployee(long bookstoreId, BookstoreEmployeeData employeeData) {

  }

  private Employee findOrCreateEmployee(long bookstoreId, BookstoreEmployeeData employeeData) {

  }

  private Employee findEmployee(long bookstoreId, long employeeId) {

  }

  private void copyEmployeeData(Employee employee, BookstoreEmployeeData employeeData) {

  }

  private void deleteEmployee(long employeeId) {

  }

  /* *************************************
   * BOOKSTORE CUSTOMER METHODS          *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  @Transactional
  public BookstoreCustomerData saveCustomer(long bookstoreId, BookstoreCustomerData customerData) {

  }

  private Customer findOrCreateCustomer(long bookstoreId, BookstoreCustomerData customerData) {

  }

  private Customer findCustomer(long bookstoreId, long customerId) {

  }

  private void copyCustomerData(Customer customer, BookstoreCustomerData customerData) {

  }

  /* *************************************
   * BOOKSTORE BOOKS METHODS             *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  @Transactional
  public BookstoreBookData saveBook(long bookstoreId, BookstoreBookData bookstoreBookData) {

  }

  private Book findOrCreateBook(long bookstoreId, BookstoreBookData bookData) {

  }

  private Book findBook(long bookstoreId, long bookId) {

  }

  private void copyBookData(Book book, BookstoreBookData bookData) {

  }

  private void deleteBook(long bookId) {

  }

  /* *************************************
   * ORDER METHODS                       *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  @Transactional
  public BookstoreOrderData saveOrder(long bookstoreId, BookstoreOrderData bookstoreOrderData) {

  }

  private Order findOrCreateOrder(long bookstoreId, BookstoreOrderData orderData) {

  }

  private Order findOrder(long bookstoreId, long orderId) {

  }

  private void copyOrderData(Book book, BookstoreOrderData orderData) {

  }
}
