package com.openbanking.direct.debits.configuration;

import io.swagger.v3.oas.models.info.Info;
import org.apache.commons.lang3.StringUtils;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class SwaggerDocumentationConfig {

	@Bean

	public GroupedOpenApi actuatorGroup() {
		return GroupedOpenApi.builder().group("actuator").pathsToMatch("/actuator/**").build();
	}

	@Bean
	public GroupedOpenApi apiGroup(@Autowired
	Artifact artifact) {
		return GroupedOpenApi.builder().group("direct-debits-services")
				.addOpenApiCustomizer(openApi -> openApi
						.info(new Info().title(StringUtils.join(new String[] { artifact.getGroupId(), artifact.getArtifactId(), artifact.getVersion() }, ":"))
								.version(artifact.getVersion())))
				.packagesToScan("com.openbanking.direct.debits.controller").build();
	}

}
