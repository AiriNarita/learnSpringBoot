import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.3.0"
	id("io.spring.dependency-management") version "1.1.5"

	kotlin("jvm") version "1.9.24"
	kotlin("plugin.spring") version "1.9.24"

	// doma利用のためのプラグイン
	id("org.domaframework.doma.compile") version "2.0.0"
	kotlin("kapt") version "1.9.22"
}

group = "learnSpringBoot.com.example"
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
	implementation("org.springframework.boot:spring-boot-starter-thymeleaf")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.seasar.doma.boot:doma-spring-boot-starter:1.7.0")
	implementation("org.seasar.doma:doma-kotlin:2.56.0")
	kapt("org.seasar.doma:doma-processor:2.56.0") //TODO: kaptはJavaとKotlinのannotation連携？
	implementation("org.springframework.boot:spring-boot-devtools") // h2 console
	compileOnly("org.projectlombok:lombok")
	runtimeOnly("com.h2database:h2")
	runtimeOnly("com.mysql:mysql-connector-j")
	annotationProcessor("org.projectlombok:lombok")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}