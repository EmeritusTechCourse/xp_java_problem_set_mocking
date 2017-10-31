# Java Problem Set: Mocking

## Rationale

Because the number of paths though production code increases exponentially with the complexity of the application, it is necessary to mock dependencies in order to test them in isolation.

While libraries like Mockito perform much of this functionality for us, developers must understand how these tools work "under the hood" in order to use them effectively.

This exercise gives students practice creating mocks without the help of automated code generation.

## Objectives

- Demonstrate knowlege of the [difference between](https://martinfowler.com/articles/mocksArentStubs.html) mocks, fakes, and spies.
- Manually create spies
- Write code that utilizes constructor injection
- Write tests that utilize spies and DI

## Background

Your assignment is to write pure unit tests for an ORM.

An Orm has been written for you, as well as a `Driver` interface, and a real implementation (`SuperComplexDriver`). Sadly, the real implementation is slow and brittle, so although it will be used when the real app is running, we will want to inject a test double when testing.

## Assignment

1. Choose the appropriate type of test double to allow for pure, white-box unit testing
1. Write a test-double which implements the driver interface
1. Break up the existing black-box unit test into multiple whitebox tests
1. Inject your test-double in your tests
1. Use the correct behavior-based assertions, instead of the current state-based ones in your new white-box tests

## Resources

- To complete this assignment, you will need to understand the difference between types of test double. [This article](https://martinfowler.com/articles/mocksArentStubs.html) will provide the requisite knowledge.

## Stretch

- If you complete this exercise early, create a new branch and solve it again using [Mockito](http://site.mockito.org/)
   