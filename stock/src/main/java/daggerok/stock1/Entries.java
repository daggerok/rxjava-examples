package daggerok.stock1;

import java.util.List;

import static java.util.Arrays.asList;

public class Entries {

  public static List<String> get() {
    return asList("AAPL", "GOOG", "MSFT", "INTC");
  }

  private Entries() {}
}
