plugins {
    `java-library`
}

repositories {
    jcenter()
    mavenCentral()
}

dependencies {
    testImplementation("junit:junit:4.13")
    api("org.apache.commons:commons-math3:3.6.1")
    implementation("com.google.guava:guava:29.0-jre")

    implementation("com.google.code.gson:gson:2.8.6")
    testImplementation("org.slf4j:slf4j-simple:1.7.30")
    testImplementation("com.github.tomakehurst:wiremock:2.27.2")
}
