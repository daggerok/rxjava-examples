package daggerok;

import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;

//tag::content[]
@Slf4j
public class App {
  public static void main(String[] args) {
    Flowable.just("ololo", "trololo")
            .subscribe(log::info);
  }
}
//tag::content[]
