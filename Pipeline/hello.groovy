properties properties: [[
                                $class: 'ParametersDefinitionProperty',
                                parameterDefinitions: [
                                        [ name        : 'isUpper',
                                          defaultValue: false,
                                          description : 'Print',
                                          $class      : 'BooleanParameterDefinition' ]
                                ]
                        ]]


stage('Print')
        {
            def toprint = "Hello World"
            def output = ""
            if(isUpper){
                echo 'converting parameter to uppercase'
                toprint = toprint.toUpperCase()
            }
            echo "${toprint}";
        }
