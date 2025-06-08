package com.openbanking.direct.debits.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * An array of detail error codes, and messages, and URLs to documentation to help remediation.
 */

@Schema(description = "An array of detail error codes, and messages, and URLs to documentation to help remediation.")
@Getter
@Setter
public class OBErrorResponse1 implements Serializable {
	private static final long serialVersionUID = 1L;

}
