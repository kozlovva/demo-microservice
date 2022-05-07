package io.github.kozlovva.os.domain.order.port.filters;

import io.github.kozlovva.core.caf.port.dto.SearchFilters;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Getter
public class OrderFilters extends SearchFilters {
    private Long number;
    private String customerId;
}
