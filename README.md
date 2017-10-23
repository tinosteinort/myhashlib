ServiceLoader Example
=====================

This is an example for an API extendable with Implementations from other JARs within the classpath.

To load implementations from an interface, the ServiceLoader is used.

See running Example: [ExampleTest](myhashlib-usage-example/src/test/java/de/tse/myhashlib/example/ExampleTest.java)


The example shows a simple case. There is an API Module in which the myhashlib API is defined. The API allows
 to get the name of all supported hashing algorithms and to get an implementation by a specific name.

```java
// get available functions
Set<String> names = HashFunctions.getAvailableHashFunctions();
```

```java
// get a function by name
HashFunction function = HashFunctions.getInstance("WeakHash");
```

```java
// execute a function
String hashValue = function.execute("Data to hash");
```

The API project also delivers a implementation of a weak algorithm ("WeakHash"). To provide a new
 implementation, just add a new dependency. See `myhashlib-sha` for a full implementation of the API.
 Don't forget to look at [this](myhashlib-sha/src/main/resources/META-INF/services/de.tse.myhashlib.HashFunctionFactory) File,
 if you want to provide a new implementation.
