package com.hcc.entities.DTOs;

import java.time.LocalDateTime;

public record AssignmentResponseDto(
        Long id,
        String title,
        String description,
        LocalDateTime deadline,
        String status
) {
}
