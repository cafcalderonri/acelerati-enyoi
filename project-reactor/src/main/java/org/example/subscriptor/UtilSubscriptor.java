package org.example.subscriptor;


import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

public class UtilSubscriptor<T> implements Subscriber<T> {

    private Subscription subscription;

    @Override
    public void onSubscribe(Subscription s) {
        this.subscription = s;
    }

    @Override
    public void onNext(T item) {
        System.out.println("ON NEXT: " + item);
    }

    @Override
    public void onError(Throwable throwable) {
        System.out.println("ON ERROR -> " + throwable);
    }

    @Override
    public void onComplete() {
        System.out.println("SE TERMINÓ DE EMITIR");
    }
}
