Please watch in raw format!

Check jsonMarge & jsonMargeCopy are equals:

String jsonMarge = JsonConverter.toJson(merge1);
System.out.println("_________________________ jsonMarge == _________________________\n" + jsonMarge);

Merge1 margeCopy = (Merge1) JsonConverter.fromJson(jsonMarge, Merge1.class);
String jsonMargeCopy = JsonConverter.toJson(margeCopy);
System.out.println("_________________________ jsonMargeCopy == _________________________\n" + jsonMargeCopy);

System.out.println("___ Equals jsonMarge & jsonMargeCopy == " + jsonMarge.equals(jsonMargeCopy) + "!!! :) ___");

TheSameNames theSameNames = new TheSameNames();
try {
    JsonConverter.toJson(theSameNames);
}
catch (TheSameFieldAndJsonValueNamesInDifferentFieldsException e) {
    System.out.println("___ Check exception == " + e + " ___");
}

Console output:
_________________________ jsonMarge == _________________________
{
	"differentArrays": {
		"primitiveChars": [
			[
				[
					'a'
				],
				[
					' '
				]
			],
			[
				[
					' '
				],
				[
					'b'
				]
			],
			[
				[
					' '
				],
				[
					'c'
				]
			]
		],
		"objectLocaleDates": [
			[
				[
					"-999999999-01-01",
					,
					
				],
				[
					,
					,
					
				]
			]
		],
		"wrapperDoubles": [
			[
				[
					'4.9E-324',
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					'0.0',
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					'1.7976931348623157E308'
				]
			]
		],
		"strings2": [
			[
				
			],
			[
				"\"fgsgergergw3fg\f\""
			]
		],
		"primitivesBoolean": [
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'true'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			]
		],
		"wrapperLongs": [
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				]
			],
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				]
			],
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						'-9223372036854775808'
					]
				]
			]
		],
		"strings1": [
			,
			"fsdfasdg\/\\\\\\"
		],
		"wrapperBooleans": [
			,
			'false',
			
		],
		"objectMerge3s": [
			[
				{
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				},
				{
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				}
			]
		],
		"objectMerge2s": [
			{
				"primitives": {
					"primitiveShort": '2',
					"primitiveInt": '3',
					"primitiveFloat": '1.1',
					"primitiveChar": '\n',
					"primitiveBoolean": 'true',
					"primitiveByte": '1',
					"primitiveLong": '4',
					"primitiveDouble": '1.2'
				},
				"primitiveWrappers": {
					"wrapperDouble": '1.4',
					"wrapperByte": '5',
					"wrapperChar": '\b',
					"wrapperInt": '7',
					"wrapperFloat": '1.3',
					"wrapperShort": '6',
					"wrapperLong": '8',
					"wrapperBoolean": 'true'
				},
				"merge3": {
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				}
			}
		],
		"emptyArray": [
		],
		"primitiveInts": [
			'0',
			'0',
			'-2147483648'
		],
		"primitiveFloats": [
			[
				'0.0',
				'0.0'
			],
			[
				'3.4028235E38',
				'0.0'
			],
			[
				'0.0',
				'1.4E-45'
			]
		]
	},
	"dateAndLocalDate": {
		"date": {
			"fastTime": '1'
		},
		"localDataWithFormat": "01­01­1111",
		"ld2": "3333-03-03"
	},
	"merge2": {
		"primitives": {
			"primitiveShort": '2',
			"primitiveInt": '3',
			"primitiveFloat": '1.1',
			"primitiveChar": '\n',
			"primitiveBoolean": 'true',
			"primitiveByte": '1',
			"primitiveLong": '4',
			"primitiveDouble": '1.2'
		},
		"primitiveWrappers": {
			"wrapperDouble": '1.4',
			"wrapperByte": '5',
			"wrapperChar": '\b',
			"wrapperInt": '7',
			"wrapperFloat": '1.3',
			"wrapperShort": '6',
			"wrapperLong": '8',
			"wrapperBoolean": 'true'
		},
		"merge3": {
			"strings": {
				"finalString": "1484076797481",
				"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
				"jsonValueString": "dfgdfg\n\b\r\txxdfg"
			},
			"nulls": {
			}
		}
	},
	"empty": {
	}
}
_________________________ jsonMargeCopy == _________________________
{
	"differentArrays": {
		"primitiveChars": [
			[
				[
					'a'
				],
				[
					' '
				]
			],
			[
				[
					' '
				],
				[
					'b'
				]
			],
			[
				[
					' '
				],
				[
					'c'
				]
			]
		],
		"objectLocaleDates": [
			[
				[
					"-999999999-01-01",
					,
					
				],
				[
					,
					,
					
				]
			]
		],
		"wrapperDoubles": [
			[
				[
					'4.9E-324',
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					'0.0',
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				]
			],
			[
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					
				],
				[
					,
					,
					,
					,
					'1.7976931348623157E308'
				]
			]
		],
		"strings2": [
			[
				
			],
			[
				"\"fgsgergergw3fg\f\""
			]
		],
		"primitivesBoolean": [
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'true'
					]
				]
			],
			[
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				],
				[
					[
						'false'
					],
					[
						'false'
					]
				]
			]
		],
		"wrapperLongs": [
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				]
			],
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				]
			],
			[
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						
					]
				],
				[
					[
						,
						,
						
					],
					[
						,
						,
						
					],
					[
						,
						,
						'-9223372036854775808'
					]
				]
			]
		],
		"strings1": [
			,
			"fsdfasdg\/\\\\\\"
		],
		"wrapperBooleans": [
			,
			'false',
			
		],
		"objectMerge3s": [
			[
				{
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				},
				{
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				}
			]
		],
		"objectMerge2s": [
			{
				"primitives": {
					"primitiveShort": '2',
					"primitiveInt": '3',
					"primitiveFloat": '1.1',
					"primitiveChar": '\n',
					"primitiveBoolean": 'true',
					"primitiveByte": '1',
					"primitiveLong": '4',
					"primitiveDouble": '1.2'
				},
				"primitiveWrappers": {
					"wrapperDouble": '1.4',
					"wrapperByte": '5',
					"wrapperChar": '\b',
					"wrapperInt": '7',
					"wrapperFloat": '1.3',
					"wrapperShort": '6',
					"wrapperLong": '8',
					"wrapperBoolean": 'true'
				},
				"merge3": {
					"strings": {
						"finalString": "1484076797481",
						"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
						"jsonValueString": "dfgdfg\n\b\r\txxdfg"
					},
					"nulls": {
					}
				}
			}
		],
		"emptyArray": [
		],
		"primitiveInts": [
			'0',
			'0',
			'-2147483648'
		],
		"primitiveFloats": [
			[
				'0.0',
				'0.0'
			],
			[
				'3.4028235E38',
				'0.0'
			],
			[
				'0.0',
				'1.4E-45'
			]
		]
	},
	"dateAndLocalDate": {
		"date": {
			"fastTime": '1'
		},
		"localDataWithFormat": "01­01­1111",
		"ld2": "3333-03-03"
	},
	"merge2": {
		"primitives": {
			"primitiveShort": '2',
			"primitiveInt": '3',
			"primitiveFloat": '1.1',
			"primitiveChar": '\n',
			"primitiveBoolean": 'true',
			"primitiveByte": '1',
			"primitiveLong": '4',
			"primitiveDouble": '1.2'
		},
		"primitiveWrappers": {
			"wrapperDouble": '1.4',
			"wrapperByte": '5',
			"wrapperChar": '\b',
			"wrapperInt": '7',
			"wrapperFloat": '1.3',
			"wrapperShort": '6',
			"wrapperLong": '8',
			"wrapperBoolean": 'true'
		},
		"merge3": {
			"strings": {
				"finalString": "1484076797481",
				"string1": "ass\/\/gs\fg\"\"'}\\$\n\n\n\\\\\b",
				"jsonValueString": "dfgdfg\n\b\r\txxdfg"
			},
			"nulls": {
			}
		}
	},
	"empty": {
	}
}
___ Equals jsonMarge & jsonMargeCopy == true!!! :) ___
___ Check exception == reflection.exceptions.TheSameFieldAndJsonValueNamesInDifferentFieldsException: Class: reflection.exampleClasses.TheSameNames, Name: s ___

Process finished with exit code 0
