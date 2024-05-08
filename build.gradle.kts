plugins {
    id("java")
}

group = "kfu.itis"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    testImplementation("org.junit.jupiter:junit-jupiter-params:5.10.0")

//    testImplementation("org.seleniumhq.selenium:selenium-firefox-driver:2.48.2")
    testImplementation("org.seleniumhq.selenium:selenium-java:2.48.2")
    testImplementation("org.seleniumhq.selenium:selenium-support:2.48.2")

    testImplementation("javax.xml.bind:jaxb-api:2.3.1")
    testImplementation("com.sun.xml.bind:jaxb-impl:2.3.1")
    testImplementation("org.glassfish.jaxb:jaxb-runtime:2.3.1")

    testImplementation("com.github.2gis.winium:winium-webdriver:0.1.0-1")
//    testImplementation("org.seleniumhq.selenium:selenium-remote-driver:2.48.2")
}

tasks.test {
    useJUnitPlatform()
}
