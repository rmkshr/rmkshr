package org.srv.combinatorpattern;

import static org.srv.combinatorpattern.CustomerRegistrationValidator.ValidationResult;
import static org.srv.combinatorpattern.CustomerRegistrationValidator.ValidationResult.EMAIL_NOT_VALID;
import static org.srv.combinatorpattern.CustomerRegistrationValidator.ValidationResult.IS_NOT_AN_ADULT;
import static org.srv.combinatorpattern.CustomerRegistrationValidator.ValidationResult.PHONE_NUMBER_NOT_VALID;
import static org.srv.combinatorpattern.CustomerRegistrationValidator.ValidationResult.SUCCESS;

import java.time.LocalDate;
import java.time.Period;
import java.util.function.Function;

/**
 * @author Ramkishore
 */
public interface CustomerRegistrationValidator
    extends Function<Customer, ValidationResult> {

  static CustomerRegistrationValidator isEmailValid() {
    return customer -> customer.getEmail().contains("@") ?
        SUCCESS : EMAIL_NOT_VALID;
  }

  static CustomerRegistrationValidator isPhoneValid() {
    return customer -> customer.getPhoneNumber().startsWith("+91") ?
        SUCCESS : PHONE_NUMBER_NOT_VALID;
  }

  static CustomerRegistrationValidator isAdult() {
    return customer -> Period.between(customer.getDob(), LocalDate.now()).getYears() > 18 ?
        SUCCESS : IS_NOT_AN_ADULT;
  }

  default CustomerRegistrationValidator combine
      (CustomerRegistrationValidator customerRegistrationValidator) {
    return customer -> {
      ValidationResult validationResult = this.apply(customer);
      return validationResult.equals(SUCCESS) ?
          customerRegistrationValidator.apply(customer) : validationResult;
    };
  }

  enum ValidationResult {
    SUCCESS,
    PHONE_NUMBER_NOT_VALID,
    EMAIL_NOT_VALID,
    IS_NOT_AN_ADULT
  }
}
