package ExtensionTestPackage;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Created by aze on 2017.04.04..
 */
class ExtensionTest {

  Extension extension = new Extension();

  @Test
  void testAdd_2and3is5() {
    assertEquals(5, extension.add(2, 3));
  }

  @Test
  void testAdd_3and3is3() {
    assertEquals(6, extension.add(3, 3));
  }

  @Test
  void testAdd_1and4is5() {
    assertEquals(5, extension.add(1, 4));
  }

  @Test
  void testMaxOfThree_first() {
    assertEquals(5, extension.maxOfThree(5, 4, 3));
  }

  @Test
  void testMaxOfThree_third() {
    assertEquals(50, extension.maxOfThree(5, 4, 50));
  }

  @Test
  void testMaxOfThree_second() {
    assertEquals(55, extension.maxOfThree(5, 55, 50));
  }


  @Test
  void testMedian_four() {
    assertEquals(5, extension.median(Arrays.asList(7,5,3,5)));
  }

  @Test
  void testMedian_five() {
    assertEquals(3, extension.median(Arrays.asList(1,2,5,4,3)));
  }

  @Test
  void testIsVowel_a() {
    assertTrue(extension.isVowel('a'));
  }

  @Test
  void testIsVowel_c() {
    assertFalse(extension.isVowel('c'));
  }

  @Test
  void testIsVowel_u() {
    assertTrue(extension.isVowel('U'));
  }

  @Test
  void testTranslate_beemutatkozik() {
    assertEquals("beveevemuvutavatkovozivik", extension.translate("beemutatkozik"));
  }

  @Test
  void testTranslate_lagopuus() {
    assertEquals("lavagovopuvuuvus", extension.translate("lagopuus"));
  }
}
