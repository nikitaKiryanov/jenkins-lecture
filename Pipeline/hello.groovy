properties properties: [[
                                $class: 'ParametersDefinitionProperty',
                                parameterDefinitions: [
                                        [ name        : 'toUpper',
                                          defaultValue: false,
                                          description : 'Print',
                                          $class      : 'BooleanParameterDefinition' ]
                                ]
                        ]]


stage('Print')
        {
            def toprint = "Hello World"
            toUpper = toUpper.toBoolean()
            if(toUpper){
                echo 'converting parameter to uppercase'
                toprint = toprint.toUpperCase()
            }
            echo "${toprint}";
        }
