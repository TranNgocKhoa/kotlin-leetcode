plugins {
    kotlin("jvm") version "2.1.20"
    application
}

group = "leetcode"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
}

tasks.register<JavaExec>("stringToInteger") {
    group = "Execution"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("string_to_integer.SolutionKt")
}

tasks.register<JavaExec>("addTwoNumbers") {
    group = "Execution"
    classpath = sourceSets.main.get().runtimeClasspath
    mainClass.set("add_two_numbers.SolutionKt")
}



tasks.test {
    useJUnitPlatform()
}
kotlin {
    jvmToolchain(21)
}