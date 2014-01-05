# DBUnit - Validation

## Motivation

DBUnit is a very useful library for writing tests that use relational databases.
For example, it allows to cleanly insert required data before a test.
The problem starts if you want to use the test over a long time. Than the
test should become more robust against changes. Often you don't need to prove
that a column has exactly a defined value. It's enough to prove if it is greater
than given value.

## Solution
If you use [dbunit-datasetbuilder](https://github.com/marcphilipp/dbunit-datasetbuilder)
You can define easily a validator as the expected value.
The tricky part is how to put this in the normal assert.
For this a validator must be from the type of the column.
For `GreaterThan` this means it must extend the class number`.
Perhaps there is a more cleaner way.

## Status
At the moment it's an alpha-version. The idea should be clear, but there are a
lot of validations to define.
