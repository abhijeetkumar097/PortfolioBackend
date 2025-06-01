package com.example.portfolio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CertificateDto {
    private String id;
    private String name;
    private String provider;
    private String duration;
    private String url;
}
