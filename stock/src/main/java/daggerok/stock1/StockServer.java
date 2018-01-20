package daggerok.stock1;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class StockServer {
  public static Observable<StockInfo> getFeed(final List<String> symbols) {
    log.info("created.");
    return Observable.create(subscriber -> emit(subscriber, symbols));
  }

  private static void emit(final ObservableEmitter<StockInfo> subscriber, final List<String> symbols) {
    symbols.stream()
           .map(StockInfo::fetch)
           .forEach(subscriber::onNext);
  }
}
