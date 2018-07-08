package daggerok;

import io.reactivex.Flowable;

public class App {
  public static void main(String[] args) {
    Flowable.fromArray(args)
            .subscribe(System.out::println);
  }
}
