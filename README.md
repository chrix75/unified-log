# unified-log

This project offers basic interfaces and implementations for usage of events sourcing (https://martinfowler.com/eaaDev/EventSourcing.html).

## Purpose

This Kotlin library offers a way for starting with Event sourcing and its target is to provide 
an technical solution agnostic implementation.

With this library you can:

+ Build Event from object
+ Implement an interface for saving these events

The current implementation only provides an in-memory unified log.

To see usage, I invite you to read test files.

## Maven Dependency
```xml
<dependency>
  <groupId>com.github.chrix75</groupId>
  <artifactId>unified-log</artifactId>
  <version>0.2.1</version>
</dependency>
```
