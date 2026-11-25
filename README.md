# BirdsCycle 🐦

**BirdsCycle** is an Android educational application built with Kotlin and Jetpack Compose. It helps users explore bird habitats, learn about selected bird species, discover basic lifecycle information, and check their understanding with a short quiz.

## Features

- **Habitat exploration** — explore four environments: Tropical Forest, Wetland, Savannah, and Arctic Area.
- **Habitat information** — read about each environment's climate and the adaptations birds use to survive there.
- **Bird profiles** — view species information, interesting facts, structural adaptations, and reproduction details.
- **Interactive lifecycle learning** — tap the nest, egg, and fledgling elements to reveal information about nesting, incubation, and growth.
- **Knowledge quiz** — answer multiple-choice questions and see your score at the end.

## Tech Stack

- **Language:** Kotlin
- **UI framework:** Jetpack Compose
- **Design components:** Material 3
- **Build system:** Gradle (Kotlin DSL)
- **Minimum Android SDK:** API 24 (Android 7.0)
- **Compile SDK:** API 36
- **Java compatibility:** Java 11

## Getting Started

### Requirements

- Android Studio
- Android SDK 36
- JDK 11
- Android device or emulator running Android 7.0 (API 24) or later

### Run the Project

1. Clone this repository:

   ```bash
   git clone https://github.com/filemonmatthew-hub/BirdCycle.git
   ```

2. Open the `BirdCycle` folder in Android Studio.
3. Allow Gradle to sync and download the project dependencies.
4. Select an Android emulator or connect an Android device.
5. Click **Run** in Android Studio to build and launch the app.

### Build a Debug APK

From the project root, run:

**Windows**

```bat
gradlew.bat assembleDebug
```

**macOS / Linux**

```bash
./gradlew assembleDebug
```

The generated APK will be available at:

```text
app/build/outputs/apk/debug/app-debug.apk
```

## Project Structure

```text
BirdCycle/
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/birdscycle/
│   │       │   ├── DataModels.kt
│   │       │   ├── MainActivity.kt
│   │       │   ├── UIComponents.kt
│   │       │   └── ui/
│   │       ├── res/
│   │       └── AndroidManifest.xml
│   └── build.gradle.kts
├── gradle/
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts
```

### Main Source Files

| File | Description |
|---|---|
| `DataModels.kt` | Defines the habitat, bird, and quiz data models, plus the sample educational content. |
| `MainActivity.kt` | Android entry point that launches the Compose application. |
| `UIComponents.kt` | Implements app navigation and the home, habitat, bird information, interactive learning, and quiz screens. |

## How to Use

1. Select a habitat on the home screen.
2. Read its climate and bird-adaptation information.
3. Choose a bird to view its facts and characteristics.
4. Open the interactive lifecycle scene and tap the nest, egg, or fledgling to read the related information.
5. Complete the quiz and view your final score.

## Project Notes

The current educational content is stored locally in the app's sample data. The lifecycle screen uses interactive, tappable UI elements with information pop-ups; it is not a 3D simulation.

---

Created as an educational project about birds, their habitats, and their life cycles.
