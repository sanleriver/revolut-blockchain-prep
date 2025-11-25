package com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate;

import com.sanleriver.fiatservice.domain.exception.UnknownCurrencyException;
import com.sanleriver.fiatservice.domain.model.ExchangeRate;
import com.sanleriver.fiatservice.domain.port.out.ExchangeRateProvider;
import com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate.data.ExchangeRateConverter;
import com.sanleriver.fiatservice.infrastructure.adapters.r2dbc.exchangerate.data.ExchangeRateEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.relational.core.query.Query;
import reactor.core.publisher.Mono;

import static org.springframework.data.relational.core.query.Criteria.where;

@RequiredArgsConstructor
public class ExchangeRateRepository implements ExchangeRateProvider {
    private final R2dbcEntityTemplate template;
    private static final ExchangeRateConverter converter = new ExchangeRateConverter();

    @Override
    public Mono<ExchangeRate> findByCurrency(String currency) {
        return template.selectOne(Query.query(where("currency").is(currency))
                , ExchangeRateEntity.class)
                .map(converter::toModel)
                .switchIfEmpty(Mono.error(new UnknownCurrencyException(currency)));
    }
}
