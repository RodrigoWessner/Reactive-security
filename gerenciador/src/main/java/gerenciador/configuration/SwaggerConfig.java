package gerenciador.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

@Configuration
public class SwaggerConfig {

    @Value("${SERVER_CONTEXT_PATH:/}")
    String contextPath;

    @Bean
    public GroupedOpenApi apiForGerenciador(@Value("${VERSION:latest}") String version) {
        var contact = new Contact()
                .name("Suport")
                .email("XXX.gmail.com");
        var info = new Info()
                .title("user API")
                .description("User management API")
                .contact(contact)
                .version(version);

        return GroupedOpenApi.builder()
                .group("users-api")
                .packagesToScan("gerenciador.user")
                .addOpenApiCustomiser(openApi -> openApi.setInfo(info))
                .addOpenApiCustomiser(openApi -> openApi.setServers(buildServerList()))
                .build();
    }

    @Bean
    public OpenAPI openAPI() {
        return new OpenAPI();
    }

    private List<Server> buildServerList() {
        return Collections.singletonList(new Server().url(contextPath));
    }

}
