# ModernClaims-API

Repository: https://github.com/OreoStudios/ModernClaims-API

## Version 2 compatibility

Version 2 replaces the `ClaimDefinition` chunk count with a set of `ClaimChunk`
values, adds `Claim.chunks()` and `ClaimRepository.findByChunk(...)`, and derives
the claim's chunk count from that set. This changes the `ClaimDefinition`
constructor and requires implementations of `Claim` to provide `chunks()`.
Addons using version 1 must update and recompile against version 2.

[![JitPack](https://jitpack.io/v/OreoStudios/ModernClaims-API.svg)](https://jitpack.io/#OreoStudios/ModernClaims-API)

## Purpose

`ModernClaims-API` contains the public Java contracts used by plugins that integrate with `ModernClaims`.

This repository is intended for:

- API interfaces
- domain models
- repositories
- API events
- GUI and scheduler abstractions

It is not intended for the plugin implementation itself.

## Build

```powershell
./gradlew build
```

Artifacts:

- `build/libs/ModernClaims-API-2.0.0.jar`
- `build/libs/ModernClaims-API-2.0.0-sources.jar`

## JitPack

This repository is configured for JitPack with `maven-publish`, and the root contains `jitpack.yml` for Java 21 builds.

Based on JitPack's documentation:

- add `https://jitpack.io` as a repository
- use `com.github.Username:Repo:Version` coordinates
- prefer a GitHub release tag for stable versions
- a commit hash also works as the version if needed

Gradle:

```gradle
repositories {
    mavenCentral()
    maven {
        url = uri("https://jitpack.io")
        content {
            includeGroup("com.github.OreoStudios")
        }
    }
}

dependencies {
    implementation("com.github.OreoStudios:ModernClaims-API:v2.0.0")
}
```

Gradle Kotlin DSL:

```kotlin
repositories {
    mavenCentral()
    maven("https://jitpack.io") {
        content {
            includeGroup("com.github.OreoStudios")
        }
    }
}

dependencies {
    implementation("com.github.OreoStudios:ModernClaims-API:v2.0.0")
}
```

Maven:

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>

<dependency>
    <groupId>com.github.OreoStudios</groupId>
    <artifactId>ModernClaims-API</artifactId>
    <version>v2.0.0</version>
</dependency>
```

Current stable tag:

- `v2.0.0`

You can also use a commit hash if you want to consume a specific commit immediately.

Once a tag is pushed, JitPack will build it on first request. You can inspect builds at:

- `https://jitpack.io/#OreoStudios/ModernClaims-API`

## Usage

A consumer plugin should compile against this API jar and depend on the `ModernClaims` plugin at runtime.

Example:

```java
import fr.oreo.modernClaims.api.ModernClaimsApi;
import fr.oreo.modernClaims.api.ModernClaimsProvider;
import fr.oreo.modernClaims.api.gui.ModernClaimsMenu;
import org.bukkit.entity.Player;

public final class ExampleUsage {

    public void openClaimMenu(Player player) {
        ModernClaimsApi api = ModernClaimsProvider.get();
        api.gui().openMenu(player, ModernClaimsMenu.CLAIM_MAIN);
    }
}
```

Example consumer `plugin.yml`:

```yml
name: ExampleAddon
main: com.example.addon.ExampleAddon
version: 1.0.0
api-version: "1.21"
depend:
  - ModernClaims
```
