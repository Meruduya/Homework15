package TicketManager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.*;


public class TicketManagerTest {
    @Test
    public void testSortFewTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "SPB");
        Ticket[] expected = {ticket2, ticket1, ticket6, ticket4, ticket8};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("MSK", "LA");
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTickets() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);

        Ticket[] actual = manager.search("NEW", "LA");
        Ticket[] expected = {ticket7};

       assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("MSK", "SPB", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket2, ticket6, ticket4};
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortZeroTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("NEW", "MSK", comparator);
        Ticket[] expected = {};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortOneTicketsWithComparator() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("MSK", "SPB", 200, 10, 12);
        Ticket ticket2 = new Ticket("MSK", "SPB", 100, 11, 14);
        Ticket ticket3 = new Ticket("MSK", "UFA", 200, 10, 16);
        Ticket ticket4 = new Ticket("MSK", "SPB", 400, 7, 17);
        Ticket ticket5 = new Ticket("USA", "SPB", 800, 4, 9);
        Ticket ticket6 = new Ticket("MSK", "SPB", 200, 6, 10);
        Ticket ticket7 = new Ticket("NEW", "LA", 300, 15, 18);
        Ticket ticket8 = new Ticket("MSK", "SPB", 500, 7, 8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        Comparator<Ticket> comparator = new TicketTimeComparator();

        Ticket[] actual = manager.searchAndSortBy("NEW", "LA", comparator);
        Ticket[] expected = {ticket7};

        assertArrayEquals(expected, actual);
    }

    @Test
    public void testCompareTicketsWithSameDurationReturnsZero() {

        Ticket ticket1 = new Ticket("NEW", "MSK", 150, 900, 1100);
        Ticket ticket2 = new Ticket("LA", "SPB", 120, 800, 1000);

        TicketTimeComparator comparator = new TicketTimeComparator();

        int result = comparator.compare(ticket1, ticket2);

        assertEquals(0, result);
    }

    @Test
    public void testFindAllReturnsAddedTickets() {
        AviaSouls manager = new AviaSouls();

        Ticket ticket1 = new Ticket("NA", "SPB", 150, 900, 1100);
        Ticket ticket2 = new Ticket("NEW", "MSK", 120, 800, 1000);


        manager.add(ticket1);
        manager.add(ticket2);
        Ticket[] allTickets = manager.findAll();

        assertEquals(2, allTickets.length);
        assertSame(ticket1, allTickets[0]);
        assertSame(ticket2, allTickets[1]);
    }

    @Test
    public void testEqualsSameObjectReturnsTrue() {
        Ticket ticket = new Ticket("MSK", "BL", 100, 800, 1000);
        assertTrue(ticket.equals(ticket));
    }

    @Test
    public void testEqualsNullReturnsFalse() {
        Ticket ticket = new Ticket("MSK", "BL", 100, 800, 1000);
        assertFalse(ticket.equals(null));
    }

    @Test
    public void testEqualsDifferentClassReturnsFalse() {
        Ticket ticket = new Ticket("MSK", "BL", 100, 800, 1000);
        String notATicket = "Not a ticket";
        assertFalse(ticket.equals(notATicket));
    }

    @Test
    public void testEqualsSameValuesReturnsTrue() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("MSK", "BL", 150, 900, 1100);
        assertTrue(ticket1.equals(ticket2));
    }

    @Test
    public void testEqualsDifferentFromReturnsFalse() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("SPB", "BL", 150, 900, 1100);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    public void testEqualsDifferentToReturnsFalse() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("MSK", "EK", 150, 900, 1100);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    public void testEqualsDifferentPriceReturnsFalse() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("MSK", "BL", 200, 900, 1100);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    public void testEqualsDifferentTimeFromReturnsFalse() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("MSK", "BL", 150, 950, 1100);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    public void testEqualsDifferentTimeToReturnsFalse() {
        Ticket ticket1 = new Ticket("MSK", "BL", 150, 900, 1100);
        Ticket ticket2 = new Ticket("MSK", "BL", 150, 900, 1150);
        assertFalse(ticket1.equals(ticket2));
    }

    @Test
    public void testHashCode_EqualObjects_HashCodesEqual() {
        Ticket ticket1 = new Ticket("Moscow", "Berlin", 150, 900, 1100);
        Ticket ticket2 = new Ticket("Moscow", "Berlin", 150, 900, 1100);
        assertTrue(ticket1.equals(ticket2));
        assertEquals(ticket1.hashCode(), ticket2.hashCode());
    }

    @Test
    public void testHashCode_DifferentObjects_HashCodesLikelyDifferent() {
        Ticket ticket1 = new Ticket("Moscow", "Berlin", 150, 900, 1100);
        Ticket ticket2 = new Ticket("Saint Petersburg", "Kiev", 200, 1000, 1200);
        assertFalse(ticket1.equals(ticket2));
        assertNotEquals(ticket1.hashCode(), ticket2.hashCode());
    }

    @Test
    public void testGetPrice_ReturnsCorrectPrice() {
        int expectedPrice = 150;
        Ticket ticket = new Ticket("MSK", "SPB", expectedPrice, 900, 1100);
        assertEquals(expectedPrice, ticket.getPrice());
    }
}