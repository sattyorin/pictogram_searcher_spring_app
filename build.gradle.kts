import java.io.File

plugins {
	java
	id("org.springframework.boot") version "3.1.3"
	id("io.spring.dependency-management") version "1.1.3"
}

group = "pictosearcher"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-webflux")
	implementation("org.springframework.boot:spring-boot-starter-aop")
  implementation("jakarta.validation:jakarta.validation-api")
	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("io.projectreactor:reactor-test")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks["bootRun"].dependsOn("buildReact", "copyReact")
tasks["build"].dependsOn("copyReact")
tasks.named("processResources").configure {
    dependsOn("copyReact")
}

val reactAppPath: String? = System.getenv("REACT_APP_PATH")
if (reactAppPath == null) {
    throw IllegalArgumentException("Please set the REACT_APP_PATH environment variable.")
}

// Custom tasks to build and copy the React app
tasks.register<Exec>("buildReact") {
    workingDir = File(reactAppPath)
    commandLine("npm", "run", "build")
}

tasks.register<Copy>("copyReact") {
    from("$reactAppPath/build")
    into("src/main/resources/static")
    dependsOn("buildReact")
}
