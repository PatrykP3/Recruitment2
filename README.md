# Recruitment2

It's a solution to recruitment task. Initial, incomplete state presents results of recruitment programming session. I want to evolve it first to have fully working solution and then possibly "springify" it.

Time for the task: 15 minutes for analysis and questions, 75 minutes for coding.

## Task
Create simple, single-threaded, in-memory database with limited set of data and transaction commands.

### Data commands

SET [name] [value]
Set variable [name] to [value].

GET [name]
Print value of variable [name].

DELETE [name]
Delete variable [name].

COUNT [value]
Print number of variables having value of [value].

Nor names nor values are allowed to contain spaces.

### Transaction commands

BEGIN
Open a transaction block.

ROLLBACK
Rollback current transaction.

COMMIT
Commit all open transactions.

ROLLBACK and COMMIT should print error message if no transaction is opened.

Nested transactions must be supported.

### Task details

Command should be processed one at a time.

Any type of input is allowed: stdin, unit tests, function calls...

#### Time complexity

Assume that data commands are most common and all should have complexity of O(log(N)) or better, when N is number of stored variables.

#### Space complexity

Be efficient in memory use: no copying all variables with every BEGIN command. Assume only small number of variables will be changed in transaction.

## Tags
### v1.0
#### Description
Initial state. Code state as it was after recruitment - so no nested transactions and still not working properly.
#### Differences
* README.md added
* .gitignore added.
