package com.example.birdscycle

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

// --- SCREEN MANAGER ---
@Composable
fun BirdsCycleApp() {
    var currentScreen by remember { mutableStateOf("home") }
    var selectedHabitat by remember { mutableStateOf<Habitat?>(null) }
    var selectedBird by remember { mutableStateOf<Bird?>(null) }

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFF4F7F6)
    ) {
        when (currentScreen) {
            "home" -> HomeScreen { habitat ->
                selectedHabitat = habitat
                currentScreen = "habitat_info"
            }
            "habitat_info" -> HabitatInfoScreen(
                habitat = selectedHabitat!!,
                onBack = { currentScreen = "home" },
                onSelectBird = { bird ->
                    selectedBird = bird
                    currentScreen = "bird_info"
                }
            )
            "bird_info" -> BirdInfoScreen(
                bird = selectedBird!!,
                onBack = { currentScreen = "habitat_info" },
                onViewInteractive = { currentScreen = "interactive" }
            )
            "interactive" -> InteractiveExplorationScreen(
                bird = selectedBird!!,
                onBack = { currentScreen = "bird_info" },
                onGoToQuiz = { currentScreen = "quiz" }
            )
            "quiz" -> QuizScreen(
                onBackToHome = {
                    currentScreen = "home"
                    selectedBird = null
                    selectedHabitat = null
                }
            )
        }
    }
}

// --- 1. HOMEPAGE ---
@Composable
fun HomeScreen(onHabitatSelected: (Habitat) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Text("🐦 BirdsCycle", fontSize = 32.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E5A44))
        Text("Immersive Aves Educational Exploration", fontSize = 14.sp, color = Color.Gray, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(32.dp))
        Text("Choose an Environment to Explore:", fontSize = 18.sp, fontWeight = FontWeight.Medium)
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(16.dp)) {
            items(SampleData.habitats) { habitat ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onHabitatSelected(habitat) },
                    shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(habitat.icon, fontSize = 40.sp)
                        Spacer(modifier = Modifier.width(16.dp))
                        Column {
                            Text(habitat.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text(habitat.description, fontSize = 12.sp, color = Color.DarkGray, maxLines = 2)
                        }
                    }
                }
            }
        }
    }
}

// --- 2. ENVIRONMENT INFO SCREEN ---
@Composable
fun HabitatInfoScreen(habitat: Habitat, onBack: () -> Unit, onSelectBird: (Bird) -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("← Back", modifier = Modifier.clickable { onBack() }, color = Color(0xFF2E5A44), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text("${habitat.icon} ${habitat.name}", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(12.dp))

        Card(colors = CardDefaults.cardColors(containerColor = Color(0xE8EFEFF2))) {
            Column(modifier = Modifier.padding(16.dp)) {
                Text("Climate Information", fontWeight = FontWeight.Bold, color = Color(0xFF1B3D2F))
                Text(habitat.climate, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(8.dp))
                Text("Adaptation Strategy", fontWeight = FontWeight.Bold, color = Color(0xFF1B3D2F))
                Text(habitat.adaptationFacts, fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Choose a Bird from this Environment:", fontWeight = FontWeight.Bold, fontSize = 16.sp)
        Spacer(modifier = Modifier.height(12.dp))

        habitat.birds.forEach { bird ->
            Button(
                onClick = { onSelectBird(bird) },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 6.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E5A44))
            ) {
                Text("Explore ${bird.name}", color = Color.White)
            }
        }
    }
}

// --- 3. BIRD INFORMATION SCREEN ---
@Composable
fun BirdInfoScreen(bird: Bird, onBack: () -> Unit, onViewInteractive: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp)
    ) {
        Text("← Back", modifier = Modifier.clickable { onBack() }, color = Color(0xFF2E5A44), fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(16.dp))
        Text(bird.name, fontSize = 30.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E5A44))
        Text("Species: ${bird.speciesInfo}", fontSize = 14.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(16.dp))

        Card(colors = CardDefaults.cardColors(containerColor = Color.White), modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text("✨ Unique Fact: ${bird.uniqueFact}", fontSize = 14.sp)
                Text("🧬 Structural Adaptation: ${bird.adaptation}", fontSize = 14.sp)
                Text("🥚 Reproduction: ${bird.reproduction}", fontSize = 14.sp)
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = onViewInteractive,
            modifier = Modifier.fillMaxWidth().height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFE28743))
        ) {
            Text("Go to Interactive Lifecycle Scene ➔", fontSize = 16.sp, fontWeight = FontWeight.Bold)
        }
    }
}

// --- 4. INTERACTIVE SIMULATION EXPLORATION ---
@Composable
fun InteractiveExplorationScreen(bird: Bird, onBack: () -> Unit, onGoToQuiz: () -> Unit) {
    var activePopupText by remember { mutableStateOf<String?>(null) }
    var activePopupTitle by remember { mutableStateOf<String?>(null) }

    Box(modifier = Modifier.fillMaxSize()) {
        // Environment Interactive Background Sandbox
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFDCEEFA))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("← Back", modifier = Modifier.clickable { onBack() }, fontWeight = FontWeight.Bold, color = Color.Black)
                Text("Interactive Sandbox", fontWeight = FontWeight.Bold, color = Color.DarkGray)
            }

            Text("Tap elements to observe the Lifecycle", fontSize = 13.sp, color = Color.DarkGray, modifier = Modifier.padding(top = 8.dp))
            Spacer(modifier = Modifier.height(40.dp))

            // Interactive Element 1: Nest
            Box(
                modifier = Modifier
                    .size(110.dp)
                    .background(Color(0xFF8B5A2B), RoundedCornerShape(50))
                    .clickable {
                        activePopupTitle = "🪺 Nesting Phase"
                        activePopupText = bird.nestingInfo
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Nest Structure\n(Click Me)", textAlign = TextAlign.Center, color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Interactive Element 2: Egg
            Box(
                modifier = Modifier
                    .size(90.dp)
                    .background(Color(0xFFFFFDD0), RoundedCornerShape(40))
                    .clickable {
                        activePopupTitle = "🥚 Incubation Phase"
                        activePopupText = bird.incubationInfo
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Egg / Incubation\n(Click Me)", textAlign = TextAlign.Center, color = Color.DarkGray, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Interactive Element 3: Chick
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .background(Color(0xFFFFD700), RoundedCornerShape(30))
                    .clickable {
                        activePopupTitle = "🐣 Growth & Fledgling"
                        activePopupText = bird.growthInfo
                    },
                contentAlignment = Alignment.Center
            ) {
                Text("Fledgling Chick\n(Click Me)", textAlign = TextAlign.Center, color = Color.Black, fontSize = 12.sp, fontWeight = FontWeight.Bold)
            }

            Spacer(modifier = Modifier.weight(1f))

            Button(onClick = onGoToQuiz, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E5A44))) {
                Text("Test Knowledge (Quiz Context)")
            }
        }

        // Educational Popup Window Modal Layer
        AnimatedVisibility(
            visible = activePopupText != null,
            modifier = Modifier.align(Alignment.BottomCenter)
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                shape = RoundedCornerShape(topStart = 24.dp, topEnd = 24.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 16.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp)) {
                    Text(activePopupTitle ?: "", fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E5A44))
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(activePopupText ?: "", fontSize = 15.sp, color = Color.Black)
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = { activePopupText = null; activePopupTitle = null },
                        modifier = Modifier.align(Alignment.End),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Gray)
                    ) {
                        Text("Close Info")
                    }
                }
            }
        }
    }
}

// --- 5. QUIZ ENGINE SECTION ---
@Composable
fun QuizScreen(onBackToHome: () -> Unit) {
    var currentIdx by remember { mutableStateOf(0) }
    var score by remember { mutableStateOf(0) }
    var quizFinished by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("🧠 Knowledge Mini Challenge", fontSize = 22.sp, fontWeight = FontWeight.Bold, color = Color(0xFF2E5A44))
        Spacer(modifier = Modifier.height(24.dp))

        if (!quizFinished) {
            val q = SampleData.quizQuestions[currentIdx]
            Text("Question ${currentIdx + 1} of ${SampleData.quizQuestions.size}", fontSize = 14.sp, color = Color.Gray)
            Spacer(modifier = Modifier.height(8.dp))
            Text(q.question, fontSize = 18.sp, fontWeight = FontWeight.SemiBold, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(24.dp))

            q.options.forEachIndexed { index, option ->
                Button(
                    onClick = {
                        if (index == q.correctAnswer) score++
                        if (currentIdx + 1 < SampleData.quizQuestions.size) {
                            currentIdx++
                        } else {
                            quizFinished = true
                        }
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White, contentColor = Color.Black),
                    elevation = ButtonDefaults.buttonElevation(2.dp)
                ) {
                    Text(option, modifier = Modifier.padding(8.dp))
                }
            }
        } else {
            Card(
                colors = CardDefaults.cardColors(containerColor = Color(0xFFEAEFEF)),
                modifier = Modifier.fillMaxWidth().padding(16.dp)
            ) {
                Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                    Text("Session Completed 🎉", fontSize = 22.sp, fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.height(12.dp))
                    Text("Your Score: $score / ${SampleData.quizQuestions.size}", fontSize = 18.sp)
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = onBackToHome,
                        colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2E5A44))
                    ) {
                        Text("Return to Homepage")
                    }
                }
            }
        }
    }
}