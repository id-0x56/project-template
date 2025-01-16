package com.example.common.exception;

import lombok.*;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ResponseException {
    private Integer code;

    private List<String> messages;

    private Instant date;
}
