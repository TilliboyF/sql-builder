plugins {
    kotlin("jvm") version "1.9.21"
    id("maven-publish")
}

group = "com.github.tilliboyf"
version = "1.0-SNAPSHOT"

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
        }
    }
    repositories{
        maven{
            name = "GitHubPackages"
            url = uri("https://maven.pkg.github.com/TilliboyF/sql-builder")
            credentials{
                //username = project.findProperty("gpr.user") as String ?: System.getenv("USERNAME")
                //password = project.findProperty("gpr.token") as String ?: System.getenv("TOKEN")
            }
        }
    }
}

kotlin {
    jvmToolchain(17)
}
