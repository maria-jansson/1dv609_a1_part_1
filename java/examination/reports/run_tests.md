## Krav:
1. Pwd får inte innehålla whitespace
2. Pwd ska vara minst 12 chars
3. Pwd ska innehålla minst 1 siffra
4. Hash startvärde ska vara 7
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
4. simpleHash_Should_Return_Same_Hash_For_Same_String
5. isPassWordSame_Should_Return_False_For_Different_Passwords
6. constructor_Should_Show_Correct_Error_Message_For_Short_Password

## Coverage
| Version | Correct | NoTrim | NoLengthCheck | WrongMinLength11 | WrongMinLength6 | NoNumberCheck | BugDoesNotHash | CompareAlwaysTrue | WrongErrMsg | **MyCustomBug** |
| ------- | ------- | ------ | ------------- | ---------------- | --------------- | ------------- | -------------- | ----------------- | ----------- | --------------- |
| constructor_Should_Trim_Whitespace_From_Password                 | ✅      | ❌ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ |  |
| constructor_Should_Throw_Exception_For_Short_Password            | ✅      | ✅ | ❌ | ❌ | ❌ | ✅ | ✅ | ✅ | ✅ | |
| constructor_Should_Throw_Exception_For_Password_Without_Number   | ✅      | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ | ✅ | |
| simpleHash_Should_Return_Same_Hash_For_Same_String               | ✅      | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | ✅ | |
| isPassWordSame_Should_Return_False_For_Different_Passwords       | ✅      | ✅ | ✅ | ✅ | ✅ | ✅ | ✅ | ❌ | ✅ | |
| constructor_Should_Show_Correct_Error_Message_For_Short_Password | ✅      | ✅ | ❌ | ✅ | ❌ | ✅ | ✅ | ✅ | ❌ | |
| Coverage                                                         | 100%    | 100% | 100% | 100% | 100% | --- | --- | --- | --- | --- |