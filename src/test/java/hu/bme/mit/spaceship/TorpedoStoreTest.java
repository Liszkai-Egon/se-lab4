package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

    @Test
    void fire_Success() {
        // Arrange
        TorpedoStore store = new TorpedoStore(1);

        // Act
        boolean result = store.fire(1);

        // Assert
        assertEquals(true, result);
        assertEquals(0, store.getTorpedoCount());
    }

    @Test 
    void fire_Fail(){
        TorpedoStore store = new TorpedoStore(1, 1.0);

        boolean result = store.fire(1);

        assertEquals(false, result);
        assertEquals(1, store.getTorpedoCount());
    }

    @Test
    void fire_IllegalArgument() {
        TorpedoStore store = new TorpedoStore(2);

        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(3);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            store.fire(0);
        });
    }

    @Test
    void isEmpty() {
        TorpedoStore store1 = new TorpedoStore(0);
        TorpedoStore store2 = new TorpedoStore(1);

        assertEquals(true, store1.isEmpty());
        assertEquals(false, store2.isEmpty());
    }

    @Test
    void getTorpedoCount(){
        TorpedoStore store = new TorpedoStore(1);
        assertEquals(1, store.getTorpedoCount());
    }
}
