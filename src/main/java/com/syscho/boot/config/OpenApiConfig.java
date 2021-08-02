package com.syscho.boot.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@OpenAPIDefinition(info = @Info(title = "${info.title}",
        description = "${info.description}",
        contact = @Contact(email = "Test@tst.com",
                name = "${info.contact..name}",
                url = "${info.contact.url}")))
public class OpenApiConfig {
}
