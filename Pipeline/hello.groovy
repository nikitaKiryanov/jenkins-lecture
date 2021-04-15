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
            echo "${isUpper}" 
            if(isUpper==true){
                echo 'converting parameter to uppercase'
                toprint = toprint.toUpperCase()
            }
            echo "${toprint}";
        }
