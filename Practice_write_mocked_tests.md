# Practice Writing and Running Tests with mocks

## Goals
* Testing classes with dependencies
* Run tests with mocks
* Test the Helper and Password classes independently of each other
    * Tests for Password should only fail if the bug is in Password class
    * Tests for Helper should only fail if the bug is in Helper class



### Table for checking test suite bug coverage
| Version | Correct | Buggy Password 1 | Buggy Helper 2 | ... | |
| --- | ---| --- | --- | --- | --- |
| Password Test name 1 | ✅ | ❌ | ✅ | ✅ | |
| Helper Test name 3 | ✅ | ✅ | ❌ | ✅ | |
| Coverage | 100% | 100% | 100% | 100% | |



```
//Version 2 Buggy Password, does not trim

//Version 3 Buggy Password, does not check password with isToShort
//Version 3 Buggy Helper, allows too short passwords

//Version 4 Buggy Password, throws the wrong exception message for short passwords

//Version 5 Buggy Password, does not throw and exception for short passwords

//Version 6 Buggy, does not throw an exception if the password does not contain a number

//Version 7 Buggy, isPasswordSame returns true for all passwords

```