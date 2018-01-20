package daggerok;

import daggerok.stock1.Entries;
import daggerok.stock1.StockInfo;
import daggerok.stock1.StockServer;
import io.reactivex.Observable;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class App {
  public static void main(String[] args) {

    final List<String> symbols = Entries.get();
    final Observable<StockInfo> feed = StockServer.getFeed(symbols);

    feed.doOnSubscribe(s -> log.info("subscribe on feeds"))
        .subscribe(
            data -> log.info("data: {}", data),
            err -> log.error("error: {}", err),
            () -> log.debug("done")
        );
  }
}
