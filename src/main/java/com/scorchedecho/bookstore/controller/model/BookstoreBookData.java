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
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Book Data class of the Bookstore application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@Data
@NoArgsConstructor
public class BookstoreBookData {
  private long bookId;
  private String bookTitle;
  private String bookAuthor;
  private String bookPublisher;
  private String bookGenre;

  /**
   * Constructor for BookData.
   *
   * @param book Book
   */
  public BookstoreBookData(Book book) {
    // copy all the fields from the Book into the BookData
    this.bookId = book.getBookId();
    this.bookTitle = book.getBookTitle();
    this.bookAuthor = book.getBookAuthor();
    this.bookPublisher = book.getBookPublisher();
    this.bookGenre = book.getBookGenre();
  }
}
