package store.dto;

import java.time.LocalDate;

public record SalesReport(String productsName, Long amountSold, LocalDate dateOfLastSale) { }
