plugins {
    id("java")
}

group = "kr.bluenyang"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("io.github.cdimascio:dotenv-java:3.2.0")
    implementation("com.google.code.gson:gson:2.13.1")
    implementation("kr.bluenyang:LLMInfra")
}

tasks.test {
    useJUnitPlatform()
}