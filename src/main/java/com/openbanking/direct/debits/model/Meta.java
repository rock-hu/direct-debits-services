package com.openbanking.direct.debits.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Meta Data relevant to the payload
 */

@Schema(description = "Meta Data relevant to the payload")
@Getter
@Setter
public class Meta implements Serializable {
	private static final long serialVersionUID = 1L;

}
