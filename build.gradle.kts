import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.5"
	id("io.spring.dependency-management") version "1.0.15.RELEASE"
	kotlin("jvm") version "1.6.21"
	kotlin("plugin.spring") version "1.6.21"
}

group = "com.dbasbas"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation ("com.graphql-java:voyager-spring-boot-starter:5.0.2")
	implementation ("com.graphql-java:graphql-java-tools:5.2.4")
	implementation("com.graphql-java-kickstart:graphql-spring-boot-starter:14.0.0")
	implementation("com.graphql-java-kickstart:graphiql-spring-boot-starter:11.1.0")
	implementation("com.expediagroup:graphql-kotlin-spring-server:6.2.5")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	runtimeOnly("org.postgresql:postgresql")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	implementation("javax.persistence:javax.persistence-api:2.2")
	implementation("org.springframework.data:spring-data-jpa:2.7.5")
	implementation("com.zaxxer:HikariCP:4.0.3")
	implementation("org.springframework.boot:spring-boot-starter-jdbc:2.7.5")
	implementation("com.graphql-java:graphql-java-extended-scalars:19.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

fun runtime(c: Char) {

}
