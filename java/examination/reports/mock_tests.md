# SSNHelper
## Krav:
1. Ska kontrollera för korrekt längd av 11
2. Ska kontrollera för korrekt format av 6 siffror, ett bindestreck, 4 siffror
3. Ska kontrollera om månad är korrekt (1-12)
4. Ska kontrollera om dag är korrekt (1-31)
5. Ska kontrollräkna mha Luhn så att siffrorna har korrekta värden

## Befintliga buggar:
| Bugg                                                    | Krav | Överlapp |
|---------------------------------------------------------|------|----------|
| Dag kan vara max 30                                     | 4    |          |
| Månad tillåts vara 0                                    | 3    |          |
| isCorrectFormat returnerar alltid true                  | 2    | X        |
| isCorrectFormat returnerar alltid false                 | 2    | X        |
| Felaktig algoritm för att räkna ut giltigt personnummer | 5    |          |
| isCorrectLength har felaktig kontroll                   | 1    |          |


## Coverage: 
<!-- ✅❌ -->
| Test | Correct | DayMax30 | Month0OK | FormatAlwaysTrue | FormatAlwaysFalse | IncorrectLuhn | inCorrectLength | **MyCustomBug** |
| ---- | ------- | -------- | -------- | ------------------- | -------------------- | ------------- | --------------- | --------------- |
| isValidDay_Should_Return_True_For_Valid_Input         | ✅ | ❌  | ✅ | ✅  | ✅ | ✅  | ✅ |   |
| isValidMonth_Should_Return_False_For_Invalid_Input    | ✅ | ✅  | ❌ | ✅  | ✅ | ✅  | ✅ |   |
| isCorrectFormat_Should_Return_True_For_Valid_Input    | ✅ | ✅  | ✅ | ✅  | ❌ | ✅  | ✅ |   |
| isCorrectFormat_Should_Return_False_For_Invalid_Input | ✅ | ✅  | ✅ | ❌  | ✅ | ✅  | ✅ |   |
| luhnIsCorrect_Should_Return_True_For_Valid_Input      | ✅ | ✅  | ✅ | ✅  | ✅ | ❌  | ✅ |   |
| isCorrectLength_Should_Return_False_For_Invalid_Input | ✅ | ✅  | ❌ | ✅  | ✅ | ✅  | ❌ |   |
| Coverage                                              | 97% | 88% | 95% | 89% | 89% | 88% | 90% | % |

## Notes:
BuggySSNHelperAllowMonth0 har felaktig kontroll av isCorrectLength utöver den planerade buggen i den klassen.

------------------------------------

# SwedishSocialSecurityNumber
## Krav:
1. Input ska trimmas
2. Kontrollera input längd (11)
3. Kontrollera input format (YYMMDD-XXXX)
4. Kontrollera giltig tid (månad och dag)
5. Kontrollera att input följer Luhn-algoritm
6. Kunna returnera pnr i delar (år, månad, dag, serienummer) och fullständigt

## Befintliga buggar:
| Bugg                                                    | Krav |
|---------------------------------------------------------|------|
| Kontrollerar inte längd på input                        | 2    |
| Kontrollerar inte enligt Luhn-algoritm                  | 5    |
| Trimmar inte input                                      | 1    |
| getYear() returnerar fel siffror                        | 6    |


## Coverage: 
<!-- ✅❌ -->
| Test | Correct | NoLengthCheck | NoLuhnCheck | NoTrim | IncorrectGetYear | **MyCustomBug1** | **MyCustomBug2** |
| ---- | ------- | ------------- | ----------- | ------ | ---------------- | ---------------- | ---------------- |
| constructor_Should_Check_For_Input_Length             | ✅ | ❌ | - | - | - | - | - |
| constructor_Should_Check_Input_Against_Luhn_Algorithm | ✅ | - | ❌ | - | - | - | - |
| constructor_Should_Trim_Input                         | ✅ | - | - | ❌ | - | - | - |
| getYear_Should_Return_Correct_Numbers                 | ✅ | - | - | - | ❌ | - | - |
| constructor_Should_Check_For_Correct_Format           | ✅ | - | - | - | - | ❌ | - |
| constructor_Should_Check_For_Valid_Month              | ✅ | - | - | - | - | - | ❌ |
| Coverage                                              | 64% | 66% | 66% | 63% | 64% | 66% | 58% |