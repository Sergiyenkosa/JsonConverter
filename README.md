jsonMarge == 
{
	"dateAndLocalDate": {
		"date": {
			"fastTime": 1
		},
		"localDataWithFormat": "01­01­1111",
		"ld2": "3333-03-03"
	},
	"merge2": {
		"primitives": {
			"primitiveShort": 2,
			"primitiveInt": 3,
			"primitiveFloat": 1.1,
			"primitiveChar": '\n',
			"primitiveBoolean": true,
			"primitiveByte": 1,
			"primitiveLong": 4,
			"primitiveDouble": 1.2
		},
		"primitiveWrappers": {
			"wrapperDouble": 1.4,
			"wrapperByte": 5,
			"wrapperChar": '\b',
			"wrapperInt": 7,
			"wrapperFloat": 1.3,
			"wrapperShort": 6,
			"wrapperLong": 8,
			"wrapperBoolean": true
		},
		"merge3": {
			"strings": {
				"finalString": "1483761939126",
				"string1": "assgsg\"\"'}\\$\n\n\n\\\\\b",
				"jsonValueString": "dfgdfg\n\b\r\txxdfg"
			},
			"nulls": {
			}
		}
	},
	"empty": {
	}
}
jsonMargeCopy == 
{
	"dateAndLocalDate": {
		"date": {
			"fastTime": 1
		},
		"localDataWithFormat": "01­01­1111",
		"ld2": "3333-03-03"
	},
	"merge2": {
		"primitives": {
			"primitiveShort": 2,
			"primitiveInt": 3,
			"primitiveFloat": 1.1,
			"primitiveChar": '\n',
			"primitiveBoolean": true,
			"primitiveByte": 1,
			"primitiveLong": 4,
			"primitiveDouble": 1.2
		},
		"primitiveWrappers": {
			"wrapperDouble": 1.4,
			"wrapperByte": 5,
			"wrapperChar": '\b',
			"wrapperInt": 7,
			"wrapperFloat": 1.3,
			"wrapperShort": 6,
			"wrapperLong": 8,
			"wrapperBoolean": true
		},
		"merge3": {
			"strings": {
				"finalString": "1483761939126",
				"string1": "assgsg\"\"'}\\$\n\n\n\\\\\b",
				"jsonValueString": "dfgdfg\n\b\r\txxdfg"
			},
			"nulls": {
			}
		}
	},
	"empty": {
	}
}
Equals jsonMarge & jsonMargeCopy = true!!! :)
Checking exception: reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException: Class: reflection.exampleClasses.TheSameNames, Name: s
