plugins {
    kotlin("jvm") version "1.9.21"
    id("maven-publish")
}

group = "com.github.tilliboyf"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
}

tasks.test {
    useJUnitPlatform()
}


publishing {
    publications{
        create<MavenPublication>("mavenJava"){
            from(components["java"])
            groupId = "com.github.TilliboyF"
            artifactId = "sql-builder"
            version = "0.0.1-SNAPSHOT"
        }
    }
    repositories{
        maven{
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/TilliboyF/sql-builder")
            credentials{
                username = System.getenv("USERNAME")
                password = System.getenv("TOKEN")
            }
        }
    }
}

kotlin {
    jvmToolchain(17)
}
