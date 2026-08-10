plugins {
    id("java")
    application
}

group = "com.theoria"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    // Bill of Materials (BOM) enforces dependency alignment
    // across the JUnit 5 ecosystem and avoids version conflict bugs
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")

    // Explicit inclusion ensures seamless test execution within Gradle 8+
    // command-line test runners and modern IDEs
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {{}
        // Enforce Java 25 via Toolchains to guarantee reproducible builds
        // across environments and CI/CD pipelines
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

application {
    mainClass.set("com.theoria.lexnode.Main")
}

tasks.test {
    useJUnitPlatform()
}