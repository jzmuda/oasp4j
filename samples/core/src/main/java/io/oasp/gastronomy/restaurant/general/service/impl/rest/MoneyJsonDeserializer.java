package io.oasp.gastronomy.restaurant.general.service.impl.rest;

import java.io.IOException;
import java.math.BigDecimal;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * The {@link JsonDeserializer JSON deserializer} for {@link Money}.
 *
 */
public final class MoneyJsonDeserializer extends JsonDeserializer<Money> {

  @Override
  public Money deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {

    BigDecimal value = jp.readValueAs(BigDecimal.class);
    if (value == null) {
      return null;
    } else {
      return new Money(value);
    }
  }

}
