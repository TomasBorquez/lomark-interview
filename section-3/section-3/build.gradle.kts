plugins {
    java
    id("org.springframework.boot") version "3.3.3"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "me.tomas.borquez"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-web")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.apache.tomcat.embed:tomcat-embed-jasper")
    implementation("jakarta.servlet.jsp.jstl:jakarta.servlet.jsp.jstl-api")
    implementation("org.glassfish.web:jakarta.servlet.jsp.jstl")

    testImplementation("org.seleniumhq.selenium:selenium-java:4.22.0")
    testImplementation("io.github.bonigarcia:webdrivermanager:5.8.0")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
