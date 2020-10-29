properties properties: [[
                                $class: 'ParametersDefinitionProperty',
                                parameterDefinitions: [
                                        [ name        : 'IsUpper',
                                          defaultValue: false,
                                          description : 'Print',
                                          $class      : 'BooleanParameterDefinition' ]
                                ]
                        ]]


stage('Print')
        {
            def toprint = "Hello World"
            if(IsUpper){
                echo 'converting parameter to uppercase'
                toprint = toprint.toUpperCase()
            }
            echo "${toprint}";
        }