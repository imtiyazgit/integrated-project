package com.imtiyaz;

import rx.Observable;
import rx.Subscriber;

public class Ex1 {
    public static void main(String[] args) {


        /*Observable<String> observable = Observable.just("hello");
        observable.subscribe(str-> System.out.println(str));

        //----
        Observable.range(1, 10).subscribe(i-> System.out.println(i));

        //---
        Observable.create(new Observable.OnSubscribe<Integer>(){

            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                subscriber.onNext(45);
                subscriber.onNext(46);
                subscriber.onCompleted();
            }
        }).subscribe(i-> System.out.println(i));

        //---

        Observable<Integer> ob1 = Observable.create(new Observable.OnSubscribe<Integer>() {
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                System.out.println("Sending");
                subscriber.onNext(6);
            }
        }).cache();

        ob1.subscribe(i-> System.out.println(i));
        ob1.subscribe(j-> System.out.println(j));*/



    }
}
