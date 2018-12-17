package com.imtiyaz;

import rx.Observable;
import rx.Subscription;
import rx.subscriptions.Subscriptions;

import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Ex3 {


    public static Observable<Integer> delayed(Integer item) {
        // delayed observable every 10 sec
        /*return  Observable.unsafeCreate(subscriber -> {
                    Thread thread = new Thread(() -> {
                        sleep(10, SECONDS);
                        while (!subscriber.isUnsubscribed()) {
                            subscriber.onNext(item);
                            subscriber.onCompleted();
                        }
                    });

                    thread.start();

                    subscriber.add(Subscriptions.create(thread::interrupt));
                }
        );*/
        return null;
    }

    public static void main(String[] args) throws InterruptedException {


        /*Subscription subscription = delayed(55).subscribe(integer -> System.out.println(integer));

        Thread.sleep(2000);

        subscription.unsubscribe();*/
    }

    public static void sleep(int timeout, TimeUnit timeUnit) {
        try {
            timeUnit.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
