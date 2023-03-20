# DoublyLinkedList / LinkedList

Andrukhiv Vita IM-13

## Description

The first implementation of the list is doubly linked list without using built-in collections. The refactored variant is linked list, that uses built-in collections. Both variants allow you to add, delete, revert, and various actions with elements in the list. 

## Variant

The option is determined by the remainder of dividing the number of the gradebook by 4:

My number of the gradebook: 1301

1301 % 4 = 1

Variant: 1

Initial list implementation: doubly linked list without using built-in collections

A second implementation: list based on built-in arrays/lists

## Instruction

- Download 'Gradle' and 'kotlinc'.
- Clone repository

- Run test from command line:

```cmd
./gradlew test 
```

- Run demonstration file from command line in file directory:

```cmd
kotlinc Example.kt -include-runtime -d Example.jar
java -jar Example.jar
```
## Conclusion

In my opinion, the unit tests were really helpful. They allowed me to test the operation of each function in the DoublyLinkedList class individually and make sure that it works correctly. Testing helped identify and fix some bugs that were in the code and keep the same implementation after refactoring. That's why writing unit tests is an important part of software development and code quality assurance.

### [Link to the commit with failed CI tests](https://github.com/vita133/lab2_mtrp/commit/a2b177d6acce484daa5d2c4c83c28fb755732d27)