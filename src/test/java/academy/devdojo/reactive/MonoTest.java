package academy.devdojo.reactive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
/**
 * Reactive streams
 * 1. Asynchronous
 * 2. Non-blocking
 * 3. Backpressure
 * Publisher <- (subscribe) Subscriber
 * Subscription is created
 * Publisher (onSubscribe with the subscription) -> Subscriber
 * Subscription <- (request N) Subscriber
 * Publisher -> (onNext) Subscriber
 * until:
 * 1. Publisher sends all the objects requested.
 * 2. Publisher sends all the objects it has. (onComplete) subscriber and subscription will be canceled
 * 3. There is an error. (onError) -> subscriber and subscription will be canceled
 */
public class MonoTest {

    @Test
    public void monoSubscriber() {
        String name = "Elivelton Gustavo";
        Mono<String> mono = Mono.just(name)
                .log();

        mono.subscribe();
        log.info("-----------------------------------------");
        StepVerifier.create(mono)
                .expectNext(name)
                .verifyComplete();
    }
}
