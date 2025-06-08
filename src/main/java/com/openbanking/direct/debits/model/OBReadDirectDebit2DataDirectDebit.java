package com.openbanking.direct.debits.model;

import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import lombok.Getter;
import lombok.Setter;

/**
 * Account to or from which a cash entry is made.
 */

@Schema(description = "Account to or from which a cash entry is made.")
@Getter
@Setter
public class OBReadDirectDebit2DataDirectDebit implements Serializable {
	private static final long serialVersionUID = 1L;

}
