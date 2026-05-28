package com.salomovs.mastersys.doc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class OpenAPIConf {

  @Value("${spring.application.name}")
  private String projectName;

  @Value("${project.version}")
  private String version;

  @Value("${project.dev.name}")
  private String devName;

  @Value("${project.dev.email}")
  private String devEmail;

  @Value("${project.repository.url}")
  private String projectRepositoryURL;

  @Value("${project.license.name}")
  private String licenseName;

  @Value("${project.license.url}")
  private String licenseURL;

  private final String summary = "An API to manage GYM businesses";
  private final String description = """
    It can handle:

    - Student registration
    - Modalities and Plans
    - Business reports
    - Financial jobs
  """;

  @Bean
  public OpenAPI openAPI() {
    var api = new OpenAPI();

    var contact = new Contact()
      .name(devName)
      .email(devEmail);

    var license = new License()
      .name(licenseName)
      .url(licenseURL);

    var info = new Info()
      .title(projectName.toUpperCase().concat(" API"))
      .summary(summary)
      .description(description)
      .version(version)
      .license(license)
      .contact(contact);

    var externalDocs = new ExternalDocumentation()
      .description("Github")
      .url(projectRepositoryURL);

    return api.info(info).externalDocs(externalDocs);
  }

}
