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

package com.scorchedecho.bookstore.controller.error;

import java.util.Map;
import java.util.NoSuchElementException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * Global Error Handler class of the Bookstore application
 * This class is used to handle all errors that occur in the application.
 *
 * @author Ari
 * @since 2024-01-26
 */
@RestControllerAdvice
@Slf4j
public class GlobalErrorHandler {

  /**
   * Handle NoSuchElementException.
   *
   * @param nsee the NoSuchElementException
   * @return the error message
   */
  // HTTP 404 (NOT FOUND)
  @ExceptionHandler(NoSuchElementException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public Map<String, String> handleNoSuchElementException(NoSuchElementException nsee) {
    // log the error
    log.error("NoSuchElementException: " + nsee.toString());
    // return the error message
    return Map.of("message", nsee.toString());
  }

  /**
   * Handle IllegalArgumentException.
   *
   * @param iae the IllegalArgumentException
   * @return the error message
   */
  // HTTP 400 (BAD REQUEST)
  @ExceptionHandler(IllegalArgumentException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public Map<String, String> handleIllegalArgumentException(IllegalArgumentException iae) {
    // log the error
    log.error("IllegalArgumentException: " + iae.toString());
    // return the error message
    return Map.of("message", iae.toString());
  }

  // todo HttpRequestMethodNotSupportedException
}
