# Gradi

A playground project for exploring Contexts and Dependency Injection (CDI) concepts using Gradle as the build tool. This project demonstrates various CDI features such as dependency injection, interceptors, qualifiers, and lifecycle management with OpenWebBeans (OWB).

## Features

- **CDI Container Bootstrapping**: Manual initialization of the CDI container using OpenWebBeans.
- **Service Layer**: Math services (`MathService`, `AddService`, `SubstractService`) showcasing dependency injection.
- **Interceptors**: Custom interceptor (`TracedInterceptor`) for method tracing and logging.
- **Logging**: Integrated logging with Logback and custom logging redirection.
- **Testing**: Comprehensive test suite including:
  - Unit tests with Mockito
  - CDI integration tests
  - Bean validation tests
  - Test categories (UnitTests, IntegrationTests, SmokeTests)
- **Code Quality**: Configured with Checkstyle, FindBugs, and PMD for static analysis.
- **Build Tool**: Gradle with custom tasks and plugins.

## Project Structure

- `src/main/java`: Main source code
  - `Main.java`: Application entry point that bootstraps CDI and demonstrates service usage
  - Services: `MathService`, `AddService`, `SubstractService`
  - `Traced.java`, `TracedInterceptor.java`: Interceptor for tracing
  - `LoggerProducer.java`: CDI producer for logger instances
  - `Resources.java`: Utility class
- `src/test/java`: Test classes
  - CDI tests, Mockito tests, Bean validation tests
- `config/`: Configuration files for code quality tools
- `build.gradle`: Gradle build script

## Prerequisites

- Java 11 or higher
- Gradle (or use the included wrapper)

## Building and Running

1. **Build the project**:
   ```bash
   ./gradlew build
   ```

2. **Run the application**:
   ```bash
   ./gradlew run
   ```

   This will start the CDI container, inject services, and perform a sample math operation (adding 3 + 5).

3. **Run tests**:
   ```bash
   ./gradlew test
   ```

4. **Run specific test categories**:
   ```bash
   ./gradlew test --tests "*UnitTests*"
   ./gradlew test --tests "*IntegrationTests*"
   ./gradlew test --tests "*SmokeTests*"
   ```

5. **Code quality checks**:
   ```bash
   ./gradlew checkstyleMain
   ./gradlew findbugsMain
   ./gradlew pmdMain
   ```

## Dependencies

Key dependencies include:
- OpenWebBeans (OWB) for CDI implementation
- Logback for logging
- JUnit and Mockito for testing
- Bean Validation API

See `build.gradle` for the complete list.

## Contributing

This is a playground project for learning and experimentation. Feel free to explore, modify, and extend the CDI features demonstrated here.

## License

This project is licensed under the Apache License 2.0 - see the [LICENSE](LICENSE) file for details.

