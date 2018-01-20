package daggerok.stock1;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(staticName = "of")
public class StockInfo {

  final String data;

  public static StockInfo fetch(final String s) {
    return StockInfo.of(s.toLowerCase());
  }
}
