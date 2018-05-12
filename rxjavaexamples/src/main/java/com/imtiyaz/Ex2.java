package com.imtiyaz;

import rx.Observable;
import rx.Subscription;

public class Ex2 {
    public static void main(String[] args) throws Throwable {
        // infinite stream
        Observable<Integer> observable = Observable.unsafeCreate(subscriber -> {
            Runnable r = () -> {
                int start = 10;
                while (!subscriber.isUnsubscribed())

                {
                    subscriber.onNext(start++);
                }
            };
            new Thread(r).start();
        });

        Subscription subscription = observable.subscribe(integer -> System.out.println(integer));

        Thread.sleep(60);

        subscription.unsubscribe();

    }
}
