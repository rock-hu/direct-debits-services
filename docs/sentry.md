# sentry

```bash
account-access-consents-services
accounts-services
balances-services
transactions-services
beneficiaries-services
direct-debits-services
standing-orders-services
products-services
offers-services
parties-services
scheduled-payments-services
statements-services
```

## SentryExceptionResolver

```java
package io.sentry.spring;

import static io.sentry.TypeCheckHint.SPRING_RESOLVER_REQUEST;
import static io.sentry.TypeCheckHint.SPRING_RESOLVER_RESPONSE;

import com.jakewharton.nopen.annotation.Open;
import io.sentry.Hint;
import io.sentry.IHub;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.exception.ExceptionMechanismException;
import io.sentry.protocol.Mechanism;
import io.sentry.spring.tracing.TransactionNameProvider;
import io.sentry.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

@Open
public class SentryExceptionResolver implements HandlerExceptionResolver, Ordered {
  public static final String MECHANISM_TYPE = "Spring5ExceptionResolver";

  private final @NotNull IHub hub;
  private final @NotNull TransactionNameProvider transactionNameProvider;
  private final int order;

  public SentryExceptionResolver(
      final @NotNull IHub hub,
      final @NotNull TransactionNameProvider transactionNameProvider,
      final int order) {
    this.hub = Objects.requireNonNull(hub, "hub is required");
    this.transactionNameProvider =
        Objects.requireNonNull(transactionNameProvider, "transactionNameProvider is required");
    this.order = order;
  }

  @Override
  public @Nullable ModelAndView resolveException(
      final @NotNull HttpServletRequest request,
      final @NotNull HttpServletResponse response,
      final @Nullable Object handler,
      final @NotNull Exception ex) {

    final SentryEvent event = createEvent(request, ex);
    final Hint hint = createHint(request, response);

    hub.captureEvent(event, hint);

    // null = run other HandlerExceptionResolvers to actually handle the exception
    return null;
  }

  @Override
  public int getOrder() {
    return order;
  }

  @NotNull
  protected SentryEvent createEvent(
      final @NotNull HttpServletRequest request, final @NotNull Exception ex) {

    final Mechanism mechanism = new Mechanism();
    mechanism.setHandled(false);
    mechanism.setType(MECHANISM_TYPE);
    final Throwable throwable =
        new ExceptionMechanismException(mechanism, ex, Thread.currentThread());
    final SentryEvent event = new SentryEvent(throwable);
    event.setLevel(SentryLevel.FATAL);
    event.setTransaction(transactionNameProvider.provideTransactionName(request));

    return event;
  }

  @Nullable
  protected Hint createHint(
      final @NotNull HttpServletRequest request, final @NotNull HttpServletResponse response) {

    final Hint hint = new Hint();
    hint.set(SPRING_RESOLVER_REQUEST, request);
    hint.set(SPRING_RESOLVER_RESPONSE, response);

    return hint;
  }
}
```

