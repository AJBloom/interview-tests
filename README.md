# Project Setup and Implementation Guide

This guide provides instructions to set up your development environment, install Java, and implement the required logic to make the tests pass.

---

## Table of Contents
1. [Download and Install an IDE](#1-download-and-install-an-ide)
2. [Install Java Development Kit (JDK)](#2-install-java-development-kit-jdk)
3. [Open the Project](#3-open-the-project)
4. [Run and View the Existing Tests](#4-run-and-view-the-existing-tests)
5. [Implement Logic to Pass the Tests](#5-implement-logic-to-pass-the-tests)
6. [Example Implementation](#6-example-implementation)
7. [Debugging and Re-running Tests](#7-debugging-and-re-running-tests)
8. [Commit Your Changes](#8-commit-your-changes)

---

## 1. Download and Install an IDE

We recommend using **IntelliJ IDEA**, as it is well-suited for Java and Kotlin development.

1. Visit [IntelliJ IDEA Download Page](https://www.jetbrains.com/idea/download/).
2. Download the **Community Edition** (free version) for your operating system.
3. Install IntelliJ IDEA by following the installation guide.

---

## 2. Install Java Development Kit (JDK)

This project requires **Java 17** to function.

### Through your IDE

Often, the IDE will automatically detect and prompt you to download the JDK for the project if it's missing.
When opening the project for the first time in IntelliJ IDEA:

1. If a compatible JDK is not configured, IntelliJ will display a notification or a prompt suggesting JDK installation.
2. You can follow the provided link in the prompt to download and set up the required JDK directly within the IDE.
3. After downloading, IntelliJ will automatically configure the project to use the new JDK.

### OR Manually
1. Download JDK 17:
    - [Oracle JDK](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
    - [AdoptOpenJDK (OpenJDK)](https://adoptopenjdk.net/)
2. Install JDK 17 based on your operating system.
3. After installation, add JDK 17 to IntelliJ IDEA:
    - Go to **File** > **Project Structure** > **SDKs** > **Add JDK**.
    - Select the folder where JDK 17 is installed.

---

## 3. Open the Project

To start working on the project:

1. Clone the repository or extract the project into a folder.
2. Open IntelliJ IDEA, then click:
    - **Open** > Navigate to the project folder, and open it.
3. Set the appropriate JDK:
    - Go to **File** > **Project Structure** > **Project** and select JDK 17 under the SDK dropdown.

---

## 4. Run and View the Existing Tests

This project uses **JUnit 5** to ensure functionality works as expected.

1. Open the test files:
    - Tests written in **Java** are under `src/test/java`.
2. Right-click on the test class (e.g., `AeroplaneTest`) and select **Run 'TestName'**.
3. Observe the output:
    - Any failing tests will appear in red in the test runner window.

---

## 5. Implement Logic to Pass the Tests

The methods in some classes (e.g., `Aeroplane` and `PassengerService`) contain unimplemented logic. 
These are marked with `throw new UnsupportedOperationException`.

### Steps:
1. Identify the functionality described in the test cases.
2. Open the corresponding class and locate the unimplemented method.
3. Write the logic to meet the test expectations.

If you aren't comfortable writing Java immediately, you can write **pseudocode** as comments within the method.
- Pseudocode helps describe the logic in a language-independent way and can later be translated to Java.
- For example:
  ```
  // Pseudocode:
  // 1. Check if the input is valid
  // 2. If valid, perform the specified operation
  //    a. Iterate through the list
  //    b. Find the matching element
  //    c. Update the element with the new value
  // 3. Return the result or an appropriate message
  ```
- Alternatively, if you prefer Python-like syntax:
  ```
  # Example in Python-like syntax:
  if input_is_valid:
      for element in list:
          if element matches criteria:
              update_element()
      return result
  else:
      raise Exception("Invalid input")
  ```
- This way, you can focus on designing the logic before syntax implementation.
