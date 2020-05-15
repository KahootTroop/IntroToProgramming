package battleship;

import static org.junit.Assert.*;

import java.util.Scanner;

import org.junit.Test;

public class BattleshipTest {

	@Test
	public void testgetColTile() {
		assertEquals(Battleship.getColTile('A', "ABCDEFGH".toCharArray()), 2);
		assertEquals(Battleship.getColTile('B', "ABCDEFGH".toCharArray()), 5);
		assertEquals(Battleship.getColTile('C', "ABCDEFGH".toCharArray()), 8);
	}

}
