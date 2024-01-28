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

import com.scorchedecho.bookstore.controller.model.BookData;
import com.scorchedecho.bookstore.controller.model.BookstoreCustomerData;
import com.scorchedecho.bookstore.controller.model.BookstoreData;
import com.scorchedecho.bookstore.controller.model.BookstoreEmployeeData;
import com.scorchedecho.bookstore.controller.model.OrderData;
import com.scorchedecho.bookstore.dao.BookDao;
import com.scorchedecho.bookstore.dao.CustomerDao;
import com.scorchedecho.bookstore.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Pet Store Service class of the Pet Store application.
 *
 * @author Ari
 * @since 2024-01-26
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

  /* Transactional Methods */

  @Transactional
  public BookstoreData saveBookstore(BookstoreData bookstoreData) {

  }

  @Transactional
  public BookstoreEmployeeData saveEmployee(BookstoreEmployeeData employeeData) {

  }

  @Transactional
  public BookstoreCustomerData saveCustomer(BookstoreCustomerData customerData) {

  }

  @Transactional
  public BookData saveBook(BookData bookData) {

  }

  @Transactional
  public OrderData saveOrder(OrderData orderData) {

  }
}
