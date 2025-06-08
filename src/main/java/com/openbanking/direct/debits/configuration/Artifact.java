package com.openbanking.direct.debits.configuration;

import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ConfigurationProperties(prefix = "artifact")
public class Artifact implements Serializable {
	private String groupId;
	private String artifactId;
	private String version;
}
