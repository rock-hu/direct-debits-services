# postman

## openapi-to-postman

### install

```bash
npm i -g openapi-to-postmanv2
```

### openapi2postmanv2 --help

```bash
Usage: openapi2postmanv2 [options]

Options:
  -v, --version                         output the version number
  -s, --spec <spec>                     Convert given OPENAPI 3.0.0 spec to Postman Collection v2.0
  -o, --output <output>                 Write the collection to an output file
  -t, --test                            Test the OPENAPI converter
  -p, --pretty                          Pretty print the JSON file
  -c, --options-config <optionsConfig>  JSON file containing Converter options
  -O, --options <options>               comma separated list of options
  -h, --help                            output usage information
    Converts a given OPENAPI specification to POSTMAN Collections v2.1.0

    Examples:
 		Read spec.yaml or spec.json and store the output in output.json after conversion
	           ./openapi2postmanv2 -s spec.yaml -o output.json

	        Read spec.yaml or spec.json and print the output to the Console
                   ./openapi2postmanv2 -s spec.yaml

                Read spec.yaml or spec.json and print the prettified output to the Console
                  ./openapi2postmanv2 -s spec.yaml -p
```

### [options](https://github.com/postmanlabs/openapi-to-postman/blob/develop/OPTIONS.md)

| id                           | type    | available options | default  | description                                                                                                                                                                                                                                                                                 | usage                  |
| ---------------------------- | ------- | ----------------- | -------- | ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| requestNameSource            | enum    | URL, Fallback     | Fallback | Determines how the requests inside the generated collection will be named. If “Fallback” is selected, the request will be named after one of the following schema values: `summary`, `operationId`, `description`, `url`.                                                                   | CONVERSION, VALIDATION |
| indentCharacter              | enum    | Space, Tab        | Space    | Option for setting indentation character                                                                                                                                                                                                                                                    | CONVERSION             |
| collapseFolders              | boolean | -                 | true     | Importing will collapse all folders that have only one child element and lack persistent folder-level data.                                                                                                                                                                                 | CONVERSION             |
| optimizeConversion           | boolean | -                 | true     | Optimizes conversion for large specification, disabling this option might affect the performance of conversion.                                                                                                                                                                             | CONVERSION             |
| requestParametersResolution  | enum    | Example, Schema   | Schema   | Select whether to generate the request parameters based on the [schema](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject) or the [example](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#exampleObject) in the schema.  | CONVERSION             |
| exampleParametersResolution  | enum    | Example, Schema   | Example  | Select whether to generate the response parameters based on the [schema](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#schemaObject) or the [example](https://github.com/OAI/OpenAPI-Specification/blob/master/versions/3.0.2.md#exampleObject) in the schema. | CONVERSION             |
| folderStrategy               | enum    | Paths, Tags       | Paths    | Select whether to create folders according to the spec’s paths or tags.                                                                                                                                                                                                                     | CONVERSION             |
| schemaFaker                  | boolean | -                 | true     | Whether or not schemas should be faked.                                                                                                                                                                                                                                                     | CONVERSION             |
| stackLimit                   | integer | -                 | 8        | Number of nesting limit till which schema resolution will happen. Increasing this limit may result in more time to convert collection depending on complexity of specification. (To make sure this option works correctly "optimizeConversion" option needs to be disabled)                 | CONVERSION             |
| includeAuthInfoInExample     | boolean | -                 | true     | Select whether to include authentication parameters in the example request                                                                                                                                                                                                                  | CONVERSION             |
| shortValidationErrors        | boolean | -                 | false    | Whether detailed error messages are required for request <> schema validation operations.                                                                                                                                                                                                   | VALIDATION             |
| validationPropertiesToIgnore | array   | -                 | []       | Specific properties (parts of a request/response pair) to ignore during validation. Must be sent as an array of strings. Valid inputs in the array: PATHVARIABLE, QUERYPARAM, HEADER, BODY, RESPONSE_HEADER, RESPONSE_BODY                                                                  | VALIDATION             |
| showMissingInSchemaErrors    | boolean | -                 | false    | MISSING_IN_SCHEMA indicates that an extra parameter was included in the request. For most use cases, this need not be considered an error.                                                                                                                                                  | VALIDATION             |
| detailedBlobValidation       | boolean | -                 | false    | Determines whether to show detailed mismatch information for application/json content in the request/response body.                                                                                                                                                                         | VALIDATION             |
| suggestAvailableFixes        | boolean | -                 | false    | Whether to provide fixes for patching corresponding mismatches.                                                                                                                                                                                                                             | VALIDATION             |
| validateMetadata             | boolean | -                 | false    | Whether to show mismatches for incorrect name and description of request                                                                                                                                                                                                                    | VALIDATION             |
| ignoreUnresolvedVariables    | boolean | -                 | false    | Whether to ignore mismatches resulting from unresolved variables in the Postman request                                                                                                                                                                                                     | VALIDATION             |
| strictRequestMatching        | boolean | -                 | false    | Whether requests should be strictly matched with schema operations. Setting to true will not include any matches where the URL path segments don't match exactly.                                                                                                                           | VALIDATION             |
| allowUrlPathVarMatching      | boolean | -                 | false    | Whether to allow matching path variables that are available as part of URL itself in the collection request                                                                                                                                                                                 | VALIDATION             |
| disableOptionalParameters    | boolean | -                 | false    | Whether to set optional parameters as disabled                                                                                                                                                                                                                                              | CONVERSION             |
| keepImplicitHeaders          | boolean | -                 | false    | Whether to keep implicit headers from the OpenAPI specification, which are removed by default.                                                                                                                                                                                              | CONVERSION             |
| includeWebhooks              | boolean | -                 | false    | Select whether to include Webhooks in the generated collection                                                                                                                                                                                                                              | CONVERSION             |
| includeReferenceMap          | boolean | -                 | false    | Whether or not to include reference map or not as part of output                                                                                                                                                                                                                            | BUNDLE                 |
| includeDeprecated            | boolean | -                 | true     | Select whether to include deprecated operations, parameters, and properties in generated collection or not                                                                                                                                                                                  | CONVERSION, VALIDATION |

## newman

### install

```bash
npm install -g newman
```

### newman run --help

```bash
Usage: newman run <collection> [options]

Initiate a Postman Collection run from a given URL or path

Options:
  -e, --environment <path>              Specify a URL or path to a Postman Environment
  -g, --globals <path>                  Specify a URL or path to a file containing Postman Globals
  -r, --reporters [reporters]           Specify the reporters to use for this run (default: ["cli"])
  -n, --iteration-count <n>             Define the number of iterations to run
  -d, --iteration-data <path>           Specify a data file to use for iterations (either JSON or CSV)
  --folder <path>                       Specify the folder to run from a collection. Can be specified multiple times to run multiple folders (default: [])
  --global-var <value>                  Allows the specification of global variables via the command line, in a key=value format (default: [])
  --env-var <value>                     Allows the specification of environment variables via the command line, in a key=value format (default: [])
  --export-environment <path>           Exports the final environment to a file after completing the run
  --export-globals <path>               Exports the final globals to a file after completing the run
  --export-collection <path>            Exports the executed collection to a file after completing the run
  --postman-api-key <apiKey>            API Key used to load the resources from the Postman API
  --bail [modifiers]                    Specify whether or not to gracefully stop a collection run on encountering an error and whether to end the run with an error based on the optional modifier
  --ignore-redirects                    Prevents Newman from automatically following 3XX redirect responses
  -x , --suppress-exit-code             Specify whether or not to override the default exit code for the current run
  --silent                              Prevents Newman from showing output to CLI
  --disable-unicode                     Forces Unicode compliant symbols to be replaced by their plain text equivalents
  --color <value>                       Enable/Disable colored output (auto|on|off) (default: "auto")
  --delay-request [n]                   Specify the extent of delay between requests (milliseconds) (default: 0)
  --timeout [n]                         Specify a timeout for collection run (milliseconds) (default: 0)
  --timeout-request [n]                 Specify a timeout for requests (milliseconds) (default: 0)
  --timeout-script [n]                  Specify a timeout for scripts (milliseconds) (default: 0)
  --working-dir <path>                  Specify the path to the working directory
  --no-insecure-file-read               Prevents reading the files situated outside of the working directory
  -k, --insecure                        Disables SSL validations
  --ssl-client-cert-list <path>         Specify the path to a client certificates configurations (JSON)
  --ssl-client-cert <path>              Specify the path to a client certificate (PEM)
  --ssl-client-key <path>               Specify the path to a client certificate private key
  --ssl-client-passphrase <passphrase>  Specify the client certificate passphrase (for protected key)
  --ssl-extra-ca-certs <path>           Specify additionally trusted CA certificates (PEM)
  --cookie-jar <path>                   Specify the path to a custom cookie jar (serialized tough-cookie JSON)
  --export-cookie-jar <path>            Exports the cookie jar to a file after completing the run
  --verbose                             Show detailed information of collection run and each request sent
  -h, --help                            display help for command
```
