package org.example.tdd;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class DisabledClassDemo {

    @Test
    void testWillBeSkipped() {
    }
}
class DisabledTestsDemo {

    @Disabled("Disabled until bug #42 has been resolved")
    @Test
    void testWillBeSkipped() {
    }

    @Test
    void testWillBeExecuted() {
    }
}
