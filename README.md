# Spring Rest Common
This project provide a common error dto class (mainly for validation) for Spring Boot Rest API,
With some commonly used Exception.
## Prerequisites

- **Java:** Version 17 or higher is required to use this library.
- **Spring Web:** Version 6.2.5 or higher is required to use this library.
- **Spring Context:** Version 6.2.5 or higher is required to use this library.
- **Jackson:** Version 2.18.3 or higher is required to use this library.
## Getting Started

### Adding the Dependency to Your Spring Project

To add this dependency to your Spring project, you can use Gradle with JitPack.

`build.gradle.kts`
```kotlin
repositories {
    maven {
        url = uri("https://jitpack.io")
    }
}
dependencies {
    implementation("com.github.thientoan3596:spring-rest-error:<TAG>")
}
```