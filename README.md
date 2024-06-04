The Bookstore API is a RESTful API that allows users to manage bookstores, employees, customers, and orders. 
The API is built using Java and Spring Boot and uses a MySQL database to store data.

You can find the project's Javadoc [here](https://doc.aridstraea.dev/BookstoreChainManagement).

Additionally, a wiki with all the information in this document and more information about the project can be found [here](https://github.com/aristraea/Bookstore-Chain-Management/wiki).

This project was created as part of the Back End boot camp at Promineo Tech. The requirements for the project are as follows:
- A REST Web API server that uses JPA and Spring Boot.
- A database design with at least 3 entities and 3 tables.
- Contains all CRUD operations.
  - Each entity must have at least one.
  - At least one entity must have all four.
- Contains at least one one-to-many relationship.
- Contains at least one many-to-many relationship.

## Table of Contents
- [Managing Bookstores](#managing-bookstores)
  - [Adding a new bookstore](#adding-a-new-bookstore)
  - [Updating a bookstore](#updating-a-bookstore)
  - [Deleting a bookstore](#deleting-a-bookstore)
  - [Retrieving a bookstore by ID](#retrieving-a-bookstore-by-id)
  - [Retrieving all bookstores](#retrieving-all-bookstores)
  - [Example Bookstore JSON](#example-bookstore-json)
- [Managing Employees](#managing-employees)
  - [Adding a new employee](#adding-a-new-employee)
  - [Updating an employee](#updating-an-employee)
  - [Deleting an employee](#deleting-an-employee)
  - [Retrieving an employee by ID](#retrieving-an-employee-by-id)
  - [Retrieving all employees by a bookstore ID](#retrieving-all-employees-by-a-bookstore-id)
  - [Example Employee JSON](#example-employee-json)
- [Managing Books](#managing-books)
  - [Adding a new book](#adding-a-new-book)
  - [Updating a book](#updating-a-book)
  - [Deleting a book](#deleting-a-book)
  - [Retrieving a book by ID](#retrieving-a-book-by-id)
  - [Retrieving all books by a bookstore ID](#retrieving-all-books-by-a-bookstore-id)
  - [Example Book JSON](#example-book-json)

## Managing bookstores
### Adding a new bookstore
Add a new bookstore to the database by creating a POST request to the `/bookstore` endpoint. The request should contain the following information:
  - Name
  - Address
  - City
  - State
  - Zip Code
  - Phone Number
  - Website

Upon successful creation, the server will return the new bookstore's ID and information.

### Updating a bookstore
Update a bookstore's information by creating a PUT request to the `/bookstore/{bookstoreId}` endpoint with the updated information.

Upon successful update, the server will return the bookstore's ID and information.

### Deleting a bookstore
Delete a bookstore from the database by creating a DELETE request to the `/bookstore/{bookstoreId}` endpoint.

Upon successful deletion, the server will return a success message.

### Retrieving a bookstore by ID
Retrieve a bookstore's information by creating a GET request to the `/bookstore/{bookstoreId}` endpoint.

Upon successful retrieval, the server will return the bookstore's information.

### Retrieving all bookstores
Retrieve all bookstores in the database by creating a GET request to the `/bookstore` endpoint.

Upon successful retrieval, the server will return a list of all bookstores and their information. 
For clarity, the server will not return the list of employees, orders, or customers associated
with each bookstore.

### Example Bookstore JSON
Below is an example JSON snippet. More examples can be found in the `JSON Examples` directory.

    {
        "bookstoreName": "Bookaria Fort Myers",
        "bookstoreAddress": "1234 Main St",
        "bookstoreCity": "Fort Myers",
        "bookstoreState": "Florida",
        "bookstoreZip" : "33913",
        "bookstorePhone": "239-555-1234",
        "bookstoreWebsite": "www.bookaria.com/locations/ftmyers"
    }

## Managing employees
### Adding a new employee
Add a new employee to the database by creating a POST request to the `/{bookstoreId}/employee` endpoint. The request should contain the following information:
  - First Name
  - Last Name
  - Email
  - Phone Number
  - Job Title

Upon successful creation, the server will return the new employee's ID and information.

### Updating an employee
Update an employee's information by creating a PUT request to the `/{bookstoreId}/employee/{employeeId}` endpoint with the updated information.

Upon successful update, the server will return the employee's ID and information.

### Deleting an employee
Delete an employee from the database by creating a DELETE request to the `/{bookstoreId}/employee/{employeeId}` endpoint.

Upon successful deletion, the server will return a success message.

### Retrieving an employee by ID
Retrieve an employee's information by creating a GET request to the `/{bookstoreId}/employee/{employeeId}` endpoint.

Upon successful retrieval, the server will return the employee's information.

### Retrieving all employees by a bookstore ID
Retrieve all employees in the database by creating a GET request to the `/{bookstoreId}/employee` endpoint.

### Example Employee JSON
Below is an example JSON snippet. More examples can be found in the `JSON Examples` directory.

    {
        "employeeFirstName": "Ari",
        "employeeLastName": "S",
        "employeePhone": "555-555-1234",
        "employeeEmail": "ari_s@bookstore.net",
        "employeeJobTitle": "Manager"
    }  

## Managing books
### Adding a new book
Add a new book to the database by creating a POST request to the `/{bookstoreId}/book` endpoint. The request should contain the following information:
- Title
- Author
- Publisher
- Genre

Upon successful creation, the server will return the new book's ID and information.

### Updating a book
Update a book's information by creating a PUT request to the `/{bookstoreId}/book/{bookId}` endpoint with the updated information.

Upon successful update, the server will return the book's ID and information.

### Deleting a book
Delete a book from the database by creating a DELETE request to the `/{bookstoreId}/book/{bookId}` endpoint.

Upon successful deletion, the server will return a success message.

### Retrieving a book by ID
Retrieve a book's information by creating a GET request to the `/{bookstoreId}/book/{bookId}` endpoint.

Upon successful retrieval, the server will return the book's information.

### Retrieving a book by genre
Retrieve all books by genre in the database by creating a GET request to the `/{bookstoreId}/book/genre/{genre}` endpoint.

Upon successful retrieval, the server will return the list of books.

### Retrieving all books by a bookstore ID
Retrieve all books in the database by creating a GET request to the `/{bookstoreId}/book` endpoint.

Upon successful retrieval, the server will return the list of books.

### Example Book JSON
Below is an example JSON snippet. More examples can be found in the `JSON Examples` directory.

    {
        "bookTitle": "A Court of Thorns and Roses",
        "bookAuthor": "Sarah J. Maas",
        "bookPublisher": "Bloomsbury Publishing",
        "bookGenre": "Fantasy Romance"
    } 
