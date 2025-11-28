## Krav:
1. Pwd får inte innehålla whitespace
2. Pwd ska vara minst 12 chars
3. Pwd ska innehålla minst 1 siffra
4. Pwd ska hashas med en simpel algoritm (hashValue = hashValue * 31 + every input char)
5. Ska kunna jämföra olika pwd
6. Ge korrekta felmeddelanden

## Befintliga buggar:
| Bugg                                     | Krav | Överlapp |
|------------------------------------------|------|----------|
| Trimmar inte whitespaces                 | 1    |          |
| Kollar inte längd på pwd                 | 2    | X        |
| Har fel minsta längd i kontroll (11)     | 2    | X        |
| Har fel minsta längd i kontroll (6)      | 2    | X        |
| Kollar inte ifall pwd har siffra         | 3    |          |
| Inkorrekt hash-algoritm                  | 4    |          |
| isPasswordSame returnerar ALLTID true    | 5    |          |
| Fel exception msg vid för kort pwd check | 6    |          |

## Tester:
1. constructor_Should_Trim_Whitespace_From_Password
2. constructor_Should_Throw_Exception_For_Short_Password
3. constructor_Should_Throw_Exception_For_Password_Without_Number
4. hashing_Should_Be_Consistent_For_Same_Input
5. isPassWordSame_Should_Return_False_For_Different_Passwords
6. constructor_Should_Show_Correct_Error_Message_For_Short_Password

## Instruction Coverage
| Test | Correct | NoTrim | NoLengthCheck | WrongMinLength11 | WrongMinLength6 | NoNumberCheck | IncorrectHash | isPwdSameAlwaysTrue | WrongErrMsg | **MyCustomBug** |
| ---- | ------- | ------ | ------------- | ---------------- | --------------- | ------------- | ------------- | ------------------- | ----------- | --------------- |
| constructor_Should_Trim_Whitespace_From_Password                 | ✅   | ❌  | ✅  | ✅  | ✅  | ✅  | ❌  | ✅  | ✅  | ✅  |
| constructor_Should_Throw_Exception_For_Short_Password            | ✅   | ✅  | ❌  | ❌  | ❌  | ✅  | ✅  | ✅  | ✅  | ✅  |
| constructor_Should_Throw_Exception_For_Password_Without_Number   | ✅   | ✅  | ✅  | ✅  | ✅  | ❌  | ✅  | ✅  | ✅  | ✅  |
| hashing_Should_Be_Consistent_For_Same_Input                      | ✅   | ✅  | ✅  | ✅  | ✅  | ✅  | ❌  | ✅  | ✅  | ✅  |
| isPassWordSame_Should_Return_False_For_Different_Passwords       | ✅   | ✅  | ✅  | ✅  | ✅  | ✅  | ✅  | ❌  | ✅  | ✅  |
| constructor_Should_Show_Correct_Error_Message_For_Short_Password | ✅   | ✅  | ❌  | ✅  | ❌  | ✅  | ✅  | ✅  | ❌  | ✅  |
| Coverage                                                         | 97% | 97% | 96% | 97% | 87% | 96% | 97% | 100% | 97% | 97% |
