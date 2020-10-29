properties properties: [[
                                $class: 'ParametersDefinitionProperty',
                                parameterDefinitions: [
                                        [ name        : 'person',
                                          defaultValue: 'Admin',
                                          description : 'Your name',
                                          $class      : 'StringParameterDefinition' ],
                                        [ name        : 'IsUpper',
                                          defaultValue: false,
                                          description : 'Print',
                                          $class      : 'BooleanParameterDefinition' ]
                                ]
                        ]]


stage('Print')
        {
            def toprint = "I'm $person"
            if(IsUpper){
                echo 'converting parameter to uppercase'
                toprint = toprint.toUpperCase()
            }
            echo "${toprint}";
        }