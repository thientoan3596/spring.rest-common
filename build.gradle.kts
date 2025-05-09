plugins {
    `java-library`
    `maven-publish`
}
java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
group = project.findProperty("group")?.toString() ?: "com.github.thientoan3596"
version = project.findProperty("version")?.toString() ?: "1.0.0-SNAPSHOT"
repositories {
    mavenCentral()
}

dependencies{
    api ("com.fasterxml.jackson.core:jackson-databind:2.18.3")
    api ("org.springframework:spring-web:6.2.5")
    api ("org.springframework:spring-context:6.2.5")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}
tasks.named<Test>("test") {
    useJUnitPlatform()
    testLogging {
       events("failed", "passed", "skipped", "standardError","standardOut")
   }
}
val sourcesJar by tasks.registering(Jar::class) {
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(project.version.toString())
    archiveClassifier.set("sources")
    from(sourceSets.main.get().allSource)
}
tasks.register<Jar>("releaseJar"){
    archiveBaseName.set(rootProject.name)
    archiveVersion.set(project.version.toString())
    from(sourceSets.main.get().output)
    finalizedBy(sourcesJar)
    doLast {
        println(archiveFile.get().asFile.absolutePath)
        println(sourcesJar.get().archiveFile.get().asFile.absolutePath)
    }
}

tasks.register("version") {
    doLast {
        println(project.version)
    }
}
tasks.register("name") {
     doLast {
        println(rootProject.name)
    }
}
tasks.register("file"){
    doLast {
        println("${rootProject.name}-${project.version}")
    }
}
publishing {
    publications {
        create<MavenPublication>("mavenJava") {
            from(components["java"])
            artifact(sourcesJar.get())
        }
    }
}
