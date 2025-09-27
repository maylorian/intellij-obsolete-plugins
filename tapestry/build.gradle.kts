plugins {
  id("java")
  id("org.jetbrains.intellij.platform") version "2.9.0"
}

group = "com.intellij"
version = "252.0"

repositories {
  mavenCentral()
  intellijPlatform {
    defaultRepositories()
  }
}

dependencies {
  intellijPlatform {
    intellijIdeaUltimate("2025.2")
    bundledPlugins(
      "com.intellij.javaee",
      "com.intellij.css",
      "com.intellij.properties"
    )
  }
}

sourceSets.getByName("main") {
  java.srcDir("src/main/gen")
  java.exclude("com/intellij/tapestry/intellij/view/**")
  java.exclude("com/intellij/tapestry/intellij/toolwindow/**")
  java.exclude("com/intellij/tapestry/intellij/actions/createnew/**")
  java.exclude("com/intellij/tapestry/intellij/actions/safedelete/**")
  java.exclude("com/intellij/tapestry/intellij/actions/navigation/TagDocumentationNavigation.java")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(21))
  }
}

intellijPlatform {
  pluginConfiguration {
    ideaVersion {
      sinceBuild.set("252")
    }
  }
}

tasks {
  buildSearchableOptions {
    enabled = false
  }

	withType<Test> {
		enabled = false
	}
}

dependencies {
  implementation("commons-chain:commons-chain:1.2")

  testImplementation("org.testng:testng:7.6.1")
  testImplementation("org.easymock:easymock:4.0.2")
  testImplementation("org.objenesis:objenesis:3.2")
  testImplementation("org.xmlunit:xmlunit-core:2.9.0")
  testImplementation("org.xmlunit:xmlunit-matchers:2.9.0")
}