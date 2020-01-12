package com.byrne.cfts.domain;
import lombok.Data;
import org.springframework.data.annotation.Id;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.net.URL;
import java.util.List;


@Data
@Document
public class Exchange {
    @Id
    private String code;
    @NotBlank
    @Indexed(unique = true)
    private String name;
    private URL website;
}
