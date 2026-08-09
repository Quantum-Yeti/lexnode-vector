import sun.jvmstat.monitor.MonitoredVmUtil.mainClass

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
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(25))
    }
}

application {
    mainClass.set("com.theoria.lexnode.Main")
}

tasks.test {
    useJUnitPlatform()
}