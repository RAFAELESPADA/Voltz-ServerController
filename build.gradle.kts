plugins {
    java
    checkstyle
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

repositories {
    mavenCentral()
    maven("https://jitpack.io")
    maven("https://repo.extendedclip.com/releases/")
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots")
    maven("https://oss.sonatype.org/content/repositories/snapshots/")
    maven("https://repo.craftationgaming.com/chaos")
    maven("https://maven.enginehub.org/repo/")
    maven("https://repo.rosewooddev.io/repository/public/")
}

dependencies {
    compileOnly(files("libs/yplugins-3.5.9.jar"))
    compileOnly(files("libs/bedwars-plugin-25.2.jar"))
    compileOnly(files("libs/KP-CORE-v4.0.1.jar"))
    compileOnly(files("libs/KP-PVP-v1.8-1.12.jar"))
    compileOnly(files("libs/yPoints-2.4.1.jar"))
    compileOnly(files("libs/worldguard-6.2.jar"))
    compileOnly(files("libs/worldedit-bukkit-6.1.9.jar"))
    
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("me.clip:placeholderapi:2.11.7")
    compileOnly("net.dmulloy2:ProtocolLib:5.4.0")
    compileOnly("net.luckperms:api:5.5")
    compileOnly("me.RockinChaos.itemjoin:ItemJoin:6.0.4-RELEASE")
    compileOnly("com.sk89q.worldedit:worldedit-bukkit:7.2.15")
    compileOnly("org.black_ixx:playerpoints:3.3.3")
    compileOnly("com.github.NEZNAMY:TAB-API:5.2.5")

    compileOnly("org.spigotmc:spigot-api:1.8.8-R0.1-SNAPSHOT") {
        exclude(group = "net.md-5", module = "bungeecord-chat")
    }
    compileOnly(files("libs/bungee.jar"))

    compileOnly("org.projectlombok:lombok:1.18.42")
    annotationProcessor("org.projectlombok:lombok:1.18.42")
}

checkstyle {
    toolVersion = "10.12.4"
    configFile = file("checkstyle.xml")
    isIgnoreFailures = false
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
}
