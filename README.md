# Java Interview Exercise — Aeroplane Passenger Management

This is a take-home coding exercise. Your task is to implement the logic in two classes so that all tests pass.

**There is no pressure to set up a full development environment.** If you would rather read the code and write pseudocode or plain English explanations of your approach, that is completely fine — we are interested in how you think, not whether you can configure a Java toolchain. Do as much or as little as you are comfortable with.

---

## What the exercise involves

The code models a simple aeroplane passenger system. Two classes need implementing:

- `Aeroplane` — manages a list of passengers on the plane (adding, removing, querying)
- `PassengerService` — utility methods for filtering, sorting, and calculating costs

Each unimplemented method has a description of what it should do. The tests in `AeroplaneTest.java` show exactly what inputs and outputs are expected.

You are not expected to modify the tests or add new files.

---

## Option A — No setup required

Just open the two files directly and write your solution as code, pseudocode, or comments:

- `src/main/java/org/example/model/Aeroplane.java`
- `src/main/java/org/example/model/PassengerService.java`

For example, instead of implementing a method you could write:

```java
public int countPassengers() {
    // return the size of the passengers list
}
```

That is enough for us to understand your thinking.

---

## Option B — Run the tests locally

If you already have Java 17 and Maven set up, or are happy to install them yourself, you can run the tests to verify your implementation:

```bash
# Run all tests
mvn clean test

# Run a single test
mvn test -Dtest=AeroplaneTest#shouldAddPassengerOnEnter
```

> **Note:** We do not provide support for local environment setup. Any software you install is at your own discretion — please source tools from their official websites and review any licence terms before installing.

If you want an IDE, IntelliJ IDEA (Community Edition) and VS Code with the Java Extension Pack are commonly used free options.

