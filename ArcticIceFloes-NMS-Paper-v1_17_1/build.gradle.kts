plugins {
    java
    kotlin("jvm") version "1.5.21"
}

group = "com.github.sigureruri"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

tasks.withType(JavaCompile::class) {
    options.encoding = "UTF-8"
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://oss.sonatype.org/content/groups/public/")
}

dependencies {
    implementation(project(":ArcticIceFloes-core"))
    compileOnly(files("libs/paper-1.17.1.jar"))
    compileOnly("org.jetbrains.kotlin:kotlin-stdlib:1.5.21")
}