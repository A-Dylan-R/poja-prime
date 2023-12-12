package com.poja.prime.endpoint.rest.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.poja.prime.conf.FacadeIT;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class HealthControllerIT extends FacadeIT {

  @Autowired HealthController healthController;

  @Test
  void ping() {
    assertEquals("pong", healthController.ping());
  }

  @Test
  void can_read_from_dummy_table() {
    var dummyTableEntries = healthController.dummyTable();
    assertEquals(1, dummyTableEntries.size());
    assertEquals("dummy-table-id-1", dummyTableEntries.get(0).getId());
  }
    @Test
  void generateNewPrime() {
    String primeString = healthController.generateNewPrime();

    // Attempt to convert the returned string to a BigInteger
    BigInteger prime = new BigInteger(primeString);

    // Verify that the generated number is probably prime
    assertTrue(prime.isProbablePrime(50), "Generated number is not prime");
  }
}
