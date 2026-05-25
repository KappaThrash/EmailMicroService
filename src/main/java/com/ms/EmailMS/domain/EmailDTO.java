package com.ms.EmailMS.domain;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Instant;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmailDTO {

    @NotBlank
    private String payerNome;
    @NotBlank
    private String payeeNome;

    @Email
    private String payerEmail;
    @Email
    private String payeeEmail;
    @NotNull
    private BigDecimal transactionValue;
    @NotNull
    private Instant transactionTime;
}
