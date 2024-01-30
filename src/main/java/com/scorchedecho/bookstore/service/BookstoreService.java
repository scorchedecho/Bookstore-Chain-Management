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
import com.scorchedecho.bookstore.dao.BookstoreDao;
import com.scorchedecho.bookstore.dao.CustomerDao;
import com.scorchedecho.bookstore.dao.EmployeeDao;
import com.scorchedecho.bookstore.dao.OrderDao;
import com.scorchedecho.bookstore.entity.Book;
import com.scorchedecho.bookstore.entity.Bookstore;
import com.scorchedecho.bookstore.entity.Customer;
import com.scorchedecho.bookstore.entity.Employee;
import com.scorchedecho.bookstore.entity.Orderb;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Bookstore Service class of the Bookstore application.
 *
 * @author Ari
 * @since  2024-01-26
 */
@Service
public class BookstoreService {
  // inject DAOs
  @Autowired
  private BookstoreDao bookstoreDao;
  @Autowired
  private CustomerDao customerDao;
  @Autowired
  private EmployeeDao employeeDao;
  @Autowired
  private BookDao bookDao;
  @Autowired
  private OrderDao orderDao;

  // PLANNING
  // No methods are yet implemented in this service.

  /* *************************************
   * BOOKSTORE METHODS                   *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  /**
   * Save a {@link Bookstore} to the database.
   *
   * @param bookstoreData the BookstoreData to save
   * @return              the saved BookstoreData
   */
  @Transactional
  public BookstoreData saveBookstore(BookstoreData bookstoreData) {
    Bookstore bookstore = findOrCreateBookstore(bookstoreData.getBookstoreId()); // find or create bookstore
    copyBookstoreData(bookstore, bookstoreData); // copy data from bookstoreData to bookstore
    return new BookstoreData(bookstoreDao.save(bookstore)); // save and return new bookstoreData
  }

  /**
   * Delete a {@link Bookstore} from the database.
   *
   * @param bookstoreId the ID of the Bookstore to delete
   */
  public void deleteBookstore(long bookstoreId) {
    bookstoreDao.delete(findBookstore(bookstoreId)); // find and delete bookstore
  }

  /**
   * Get a {@link BookstoreData} by ID.
   *
   * @param bookstoreId the ID of the Bookstore to get
   * @return            the BookstoreData
   */
  public BookstoreData getBookstore(long bookstoreId) {
    return new BookstoreData(findBookstore(bookstoreId)); // find and return bookstore
  }

  /**
   * Get all {@link BookstoreData} from the database.
   *
   * @return a list of all BookstoreData
   */
  public List<BookstoreData> getAllBookstores() {
    List<BookstoreData> result = new LinkedList<>();

    for (Bookstore bookstore : bookstoreDao.findAll()) {
      // yoink it
      BookstoreData bookstoreData = new BookstoreData(bookstore);

      // remove customers, orders, and employees
      bookstoreData.getCustomers().clear();
      bookstoreData.getOrderbs().clear();
      bookstoreData.getEmployees().clear();
      // add
      result.add(bookstoreData);
    }

    return result;
  }

  /**
   * Find or create a {@link Bookstore} by ID.
   *
   * @param bookstoreId the ID of the Bookstore to find or create
   * @return            the Bookstore
   */
  private Bookstore findOrCreateBookstore(long bookstoreId) {
    Bookstore bookstore = null;

    // attempt to find
    if (bookstoreId > 0) {
      // if id not null, but not exists, throw exception (thrown in findBookstore)
      // if id not null, and exists, retrieve bookstore
      bookstore = findBookstore(bookstoreId);
    }
    // if still null, not found. create a new one
    if (bookstore == null) {
      bookstore = new Bookstore();
    }
    return bookstore;
  }

  /**
   * Find a {@link Bookstore} by ID.
   *
   * @param bookstoreId the ID of the Bookstore to find
   * @return            the Bookstore
   */
  private Bookstore findBookstore(long bookstoreId) {
    return bookstoreDao.findById(bookstoreId).orElseThrow(
      // throw exception if bookstore not found
      () -> new NoSuchElementException(
        String.format("Bookstore with ID %b not found", bookstoreId))
    );
  }

  /**
   * Copy the data from the {@link BookstoreData} to the {@link Bookstore}.
   *
   * @param bookstore     the Bookstore to be updated
   * @param bookstoreData the BookstoreData to copy from
   */
  private void copyBookstoreData(Bookstore bookstore, BookstoreData bookstoreData) {
    // copy all the fields from the BookstoreData to Bookstore
    bookstore.setBookstoreId(bookstoreData.getBookstoreId());
    bookstore.setBookstoreName(bookstoreData.getBookstoreName());
    bookstore.setBookstoreAddress(bookstoreData.getBookstoreAddress());
    bookstore.setBookstoreCity(bookstoreData.getBookstoreCity());
    bookstore.setBookstoreState(bookstoreData.getBookstoreState());
    bookstore.setBookstoreZip(bookstoreData.getBookstoreZip());
    bookstore.setBookstorePhone(bookstoreData.getBookstorePhone());
    bookstore.setBookstoreWebsite(bookstoreData.getBookstoreWebsite());
  }

  /* *************************************
   * BOOKSTORE EMPLOYEE METHODS          *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  /**
   * Save a {@link Employee} to the database.
   *
   * @param bookstoreId  the ID of the Bookstore the Employee is at
   * @param employeeData the BookstoreEmployeeData to save
   * @return             the saved BookstoreEmployeeData
   */
  @Transactional
  public BookstoreEmployeeData saveEmployee(long bookstoreId, BookstoreEmployeeData employeeData) {
    // find bookstore & find or create employee
    Bookstore bookstore = findBookstore(bookstoreId);
    Employee employee = findOrCreateEmployee(bookstoreId, employeeData.getEmployeeId());
    //copy all data from employeeData to employee
    copyEmployeeData(employee, employeeData);
    // save the employee (and return it)
    employee.setBookstore(bookstore);
    bookstore.getEmployees().add(employee);
    return new BookstoreEmployeeData(employeeDao.save(employee));
  }

  /**
   * Delete a {@link Employee} from the database.
   *
   * @param bookstoreId the ID of the Bookstore the Employee is at
   * @param employeeId  the ID of the Employee to delete
   */
  public void deleteEmployee(long bookstoreId, long employeeId) {
    employeeDao.delete(findEmployee(bookstoreId, employeeId)); // find and delete employee
  }

  /**
   * Get a {@link BookstoreEmployeeData} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore the Employee works at
   * @param employeeId  the ID of the Employee to get
   * @return            the BookstoreEmployeeData
   */
  public BookstoreEmployeeData getEmployee(long bookstoreId, long employeeId) {
    return new BookstoreEmployeeData(findEmployee(bookstoreId, employeeId)); // find and return employee
  }

  /**
   * Get all {@link BookstoreEmployeeData} from the database.
   *
   * @param bookstoreId the ID of the Bookstore to get all Employees from
   * @return            a list of all BookstoreEmployeeData
   */
  public List<BookstoreEmployeeData> getAllEmployees(long bookstoreId) {
    List<BookstoreEmployeeData> result = new LinkedList<>();

    for(Employee employee : employeeDao.findAll()) {
      // yoink
      BookstoreEmployeeData employeeData = new BookstoreEmployeeData(employee);
      if (employee.getBookstore().getBookstoreId() == bookstoreId) {
        result.add(employeeData); // add to result list
      }
    }

    return result;
  }

  /**
   * Find or create a {@link Employee} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find or create the Employee at
   * @param employeeId  the ID of the Employee to find or create
   * @return            the Employee
   */
  private Employee findOrCreateEmployee(long bookstoreId, long employeeId) {
    Employee employee = null;
    // attempt to find the employee by id
    if (employeeId > 0) {
      // if id not null, but not exists, throw exception
      // if id not null, and exists, retrieve employee
      employee = findEmployee(bookstoreId, employeeId);
    }
    // if still null, not found. create a new employee
    if (employee == null) {
      employee = new Employee();
    }

    return employee;
  }

  /**
   * Find a {@link Employee} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find the Employee at
   * @param employeeId  the ID of the Employee to find
   * @return            the Employee
   */
  private Employee findEmployee(long bookstoreId, long employeeId) {
    return employeeDao.findById(employeeId).orElseThrow(
      // throw exception if employee not found
      () -> new NoSuchElementException(
        String.format("Employee with ID %b not found at bookstore with ID %b", employeeId, bookstoreId)
      )
    );
  }

  /**
   * Copy the data from the {@link BookstoreEmployeeData} to the {@link Employee}.
   *
   * @param employee     the Employee to be updated
   * @param employeeData the BookstoreEmployeeData to copy from
   */
  private void copyEmployeeData(Employee employee, BookstoreEmployeeData employeeData) {
    employee.setEmployeeId(employeeData.getEmployeeId());
    employee.setEmployeeFirstName(employeeData.getEmployeeFirstName());
    employee.setEmployeeLastName(employeeData.getEmployeeLastName());
    employee.setEmployeePhone(employeeData.getEmployeePhone());
    employee.setEmployeeEmail(employeeData.getEmployeeEmail());
  }

  /* *************************************
   * BOOKSTORE CUSTOMER METHODS          *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  /**
   * Save a {@link Customer} to the database.
   *
   * @param bookstoreId  the ID of the Bookstore the Customer is at
   * @param customerData the BookstoreCustomerData to save
   * @return             the saved BookstoreCustomerData
   */
  @Transactional
  public BookstoreCustomerData saveCustomer(long bookstoreId, BookstoreCustomerData customerData) {
    // find book store & find or create customer
    Bookstore bookstore = findBookstore(bookstoreId);
    Customer customer = findOrCreateCustomer(bookstoreId, customerData.getCustomerId());
    //copy all data from bookstoreCustomer to employee
    copyCustomerData(customer, customerData);
    // save the customer (and return it)
    customer.getBookstores().add(bookstore);
    bookstore.getCustomers().add(customer);
    return new BookstoreCustomerData(customerDao.save(customer));
  }


  /**
   * Get a {@link BookstoreCustomerData} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore the Customer works at
   * @param customerId  the ID of the Customer to get
   * @return            the BookstoreCustomerData
   */
  public BookstoreCustomerData getCustomer(long bookstoreId, long customerId) {
    return new BookstoreCustomerData(findCustomer(bookstoreId, customerId)); // find and return customer
  }

  /**
   * Get all {@link BookstoreCustomerData} from the database.
   *
   * @param bookstoreId the ID of the Bookstore to get all Customers from
   * @return            a list of all BookstoreCustomerData
   */
  public List<BookstoreCustomerData> getAllCustomers(long bookstoreId) {
    List<BookstoreCustomerData> result = new LinkedList<>();

    for(Customer customer : customerDao.findAll()) {
      // yoink
      BookstoreCustomerData customerData = new BookstoreCustomerData(customer);
      for (Bookstore bookstore : customer.getBookstores()) {
        if (bookstore.getBookstoreId() == bookstoreId) {
          result.add(customerData); // add to result list
        }
      }
    }

    return result;
  }

  /**
   * Find or create a {@link Customer} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find or create the Customer at
   * @param customerId  the ID of the Customer to find or create
   * @return            the Customer
   */
  private Customer findOrCreateCustomer(long bookstoreId, long customerId) {
    Customer customer = null;
    // attempt to find the employee by id
    if (customerId > 0) {
      // if id not null, but not exists, throw exception
      // if id not null, and exists, retrieve employee
      customer = findCustomer(bookstoreId, customerId);
    }
    // if still null, not found. create a new employee
    if (customer == null) {
      customer = new Customer();
    }

    return customer;
  }

  /**
   * Find a {@link Customer} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find the Customer at
   * @param customerId  the ID of the Customer to find
   * @return            the Customer
   */
  private Customer findCustomer(long bookstoreId, long customerId) {
    return customerDao.findById(customerId).orElseThrow(
      // throw exception if customer not found
      () -> new NoSuchElementException(
        String.format("Customer with ID %b not found at bookstore with ID %b", customerId, bookstoreId)
      )
    );
  }

  /**
   * Copy the data from the {@link BookstoreCustomerData} to the {@link Customer}.
   *
   * @param customer     the Customer to be updated
   * @param customerData the BookstoreCustomerData to copy from
   */
  private void copyCustomerData(Customer customer, BookstoreCustomerData customerData) {
    // copy all the fields from the BookstoreCustomerData to Customer
    customer.setCustomerId(customerData.getCustomerId());
    customer.setCustomerFirstName(customerData.getCustomerFirstName());
    customer.setCustomerLastName(customerData.getCustomerLastName());
    customer.setCustomerPhone(customerData.getCustomerPhone());
    customer.setCustomerEmail(customerData.getCustomerEmail());
  }

  /* *************************************
   * BOOKSTORE BOOKS METHODS             *
   * CRUD?: CREATE, READ, UPDATE, DELETE *
   * *************************************/

  /**
   * Save a {@link Book} to the database.
   *
   * @param bookstoreId       the ID of the Bookstore the Book is at
   * @param bookstoreBookData the BookstoreBookData to save
   * @return                  the saved BookstoreBookData
   */
  @Transactional
  public BookstoreBookData saveBook(long bookstoreId, BookstoreBookData bookstoreBookData) {
    // find bookstore & find or create book
    Bookstore bookstore = findBookstore(bookstoreId);
    Book book = findOrCreateBook(bookstoreId, bookstoreBookData.getBookId());
    //copy all data from bookstoreBookData to book
    copyBookData(book, bookstoreBookData);
    // save the book (and return it)
    book.getBookstores().add(bookstore);
    bookstore.getBooks().add(book);
    return new BookstoreBookData(bookDao.save(book));
  }

  /**
   * Delete a {@link Book} from the database.
   *
   * @param bookstoreId the ID of the Bookstore the Book is at
   * @param bookId      the ID of the Book to delete
   */
  public void deleteBook(long bookstoreId, long bookId) {
    bookDao.delete(findBook(bookstoreId, bookId)); // find and delete book
  }

  /**
   * Get a {@link BookstoreBookData} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore the Book is at
   * @param bookId      the ID of the Book to get
   * @return            the BookstoreBookData
   */
  public BookstoreBookData getBook(long bookstoreId, long bookId) {
    return new BookstoreBookData(findBook(bookstoreId, bookId)); // find and return book
  }

  public List<BookstoreBookData> getAllBooks(long bookstoreId) {
    List<BookstoreBookData> result = new LinkedList<>();

    for(Book book : bookDao.findAll()) {
      // yoink
      BookstoreBookData bookData = new BookstoreBookData(book);
      for (Bookstore bookstore : book.getBookstores()) {
        if (bookstore.getBookstoreId() == bookstoreId) {
          result.add(bookData); // add to result list
        }
      }
    }

    return result;
  }

  /**
   * Get all {@link BookstoreBookData} from the database by genre.
   *
   * @param bookstoreId the ID of the Bookstore to get all Books from
   * @param genre       the genre of the Books to get
   * @return            a list of all BookstoreBookData
   */
  public List<BookstoreBookData> getAllBooksByGenre(long bookstoreId, String genre) {
    List<BookstoreBookData> result = new LinkedList<>();

    for(Book book : bookDao.findAll()) {
      // yoink
      BookstoreBookData bookData = new BookstoreBookData(book);
      for (Bookstore bookstore : book.getBookstores()) {
        if (book.getBookGenre().equals(genre) && bookstore.getBookstoreId() == bookstoreId) {
          // add to result list if genre matches & bookstore matches
          result.add(bookData);
        }
      }
    }

    return result;
  }

  /**
   * Find or create a {@link Book} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find or create the Book at
   * @param bookId      the ID of the Book to find or create
   * @return            the Book
   */
  private Book findOrCreateBook(long bookstoreId, long bookId) {
    Book book = null;
    // attempt to find the employee by id
    if (bookId > 0) {
      // if id not null, but not exists, throw exception
      // if id not null, and exists, retrieve employee
      book = findBook(bookstoreId, bookId);
    }
    // if still null, not found. create a new employee
    if (book == null) {
      book = new Book();
    }

    return book;
  }

  /**
   * Find a {@link Book} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find the Book at
   * @param bookId      the ID of the Book to find
   * @return            the Book
   */
  private Book findBook(long bookstoreId, long bookId) {
    return bookDao.findById(bookId).orElseThrow(
      // throw exception if book not found
      () -> new NoSuchElementException(
        String.format("Book with ID %b not found at bookstore with ID %b", bookId, bookstoreId)
      )
    );
  }

  /**
   * Copy the data from the {@link BookstoreBookData} to the {@link Book}.
   *
   * @param book     the Book to be updated
   * @param bookData the BookstoreBookData to copy from
   */
  private void copyBookData(Book book, BookstoreBookData bookData) {
    // copy all the fields from the BookData to Book
    book.setBookId(bookData.getBookId());
    book.setBookTitle(bookData.getBookTitle());
    book.setBookAuthor(bookData.getBookAuthor());
    book.setBookPublisher(bookData.getBookPublisher());
    book.setBookGenre(bookData.getBookGenre());
  }

  /* *************************************
   * ORDER METHODS                       *
   * CRUD?: CREATE, READ, UPDATE         *
   * *************************************/

  /**
   * Save an {@link Orderb} to the database.
   *
   * @param bookstoreId        the ID of the Bookstore the Order is at
   * @param bookstoreOrderData the BookstoreOrderData to save
   * @return                   the saved BookstoreOrderData
   */
  @Transactional
  public BookstoreOrderData saveOrder(long bookstoreId, BookstoreOrderData bookstoreOrderData) {
    // find bookstore & find or create order
    Bookstore bookstore = findBookstore(bookstoreId);
    Orderb orderb = findOrCreateOrder(bookstoreId, bookstoreOrderData.getOrderId());
    //copy all data from bookstoreOrderData to order
    copyOrderData(orderb, bookstoreOrderData);
    // save the order (and return it)
    orderb.setBookstore(bookstore);
    bookstore.getOrderbs().add(orderb);
    return new BookstoreOrderData(orderDao.save(orderb));
  }

  /**
   * Get a {@link BookstoreOrderData} by its ID
   * and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore the Order is at
   * @param orderId     the ID of the Order to get
   * @return            the BookstoreOrderData
   */
  public BookstoreOrderData getOrder(long bookstoreId, long orderId) {
    return new BookstoreOrderData(findOrder(bookstoreId, orderId)); // find and return order
  }

  public List<BookstoreOrderData> getAllOrders(long bookstoreId) {
    List<BookstoreOrderData> result = new LinkedList<>();

    for(Orderb orderb : orderDao.findAll()) {
      // yoink
      BookstoreOrderData orderData = new BookstoreOrderData(orderb);
      if (orderb.getBookstore().getBookstoreId() == bookstoreId) {
        result.add(orderData); // add to result list
      }
    }

    return result;
  }

  /**
   * Find or create an {@link Orderb} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find or create the Order at
   * @param orderId     the ID of the Order to find or create
   * @return            the Order
   */
  private Orderb findOrCreateOrder(long bookstoreId, long orderId) {
    Orderb orderb = null;
    // attempt to find the order by id
    if (orderId > 0) {
      // if id not null, but not exists, throw exception
      // if id not null, and exists, retrieve order
      orderb = findOrder(bookstoreId, orderId);
    }
    // if still null, not found. create a new order
    if (orderb == null) {
      orderb = new Orderb();
    }

    return orderb;
  }

  /**
   * Find a {@link Orderb} by its ID and the ID of the {@link Bookstore} it is at.
   *
   * @param bookstoreId the ID of the Bookstore to find the Order at
   * @param orderId     the ID of the Order to find
   * @return            the Order
   */
  private Orderb findOrder(long bookstoreId, long orderId) {
    return orderDao.findById(orderId).orElseThrow(
      // throw exception if order not found
      () -> new NoSuchElementException(
        String.format("Order with ID %b not found at bookstore with ID %b", orderId, bookstoreId)
      )
    );
  }

  /**
   * Copy the data from the {@link BookstoreOrderData} to the {@link Orderb}.
   *
   * @param orderb    the Order to be updated
   * @param orderData the BookstoreOrderData to copy from
   */
  private void copyOrderData(Orderb orderb, BookstoreOrderData orderData) {
    // copy all the fields from the BookstoreOrderData to Order
    orderb.setOrderId(orderData.getOrderId());
    orderb.setOrderDate(orderData.getOrderDate());
    orderb.setCustomer(orderData.getCustomer());
    orderb.setBookstore(orderData.getBookstore());
  }
}
