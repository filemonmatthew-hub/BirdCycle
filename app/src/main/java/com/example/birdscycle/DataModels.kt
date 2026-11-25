package com.example.birdscycle

data class Habitat(
    val id: String,
    val name: String,
    val icon: String,
    val description: String,
    val climate: String,
    val adaptationFacts: String,
    val birds: List<Bird>
)

data class Bird(
    val name: String,
    val speciesInfo: String,
    val uniqueFact: String,
    val adaptation: String,
    val reproduction: String,
    val nestingInfo: String,
    val incubationInfo: String,
    val growthInfo: String
)

data class QuizQuestion(
    val question: String,
    val options: List<String>,
    val correctAnswer: Int
)

object SampleData {
    val habitats = listOf(
        Habitat(
            id = "tropical",
            name = "Tropical Forest",
            icon = "🌴",
            description = "Lush green forests with high rainfall and dense canopy layers.",
            climate = "Warm and humid year-round, rainfall exceeding 2000mm annually.",
            adaptationFacts = "Birds here often have short, broad wings to navigate dense trees and bright plumage for communication.",
            birds = listOf(
                Bird("Hummingbird", "Scolopax family", "Can fly backwards.", "Hovering flight adaptation", "Lays 2 tiny eggs", "Built on tiny branches", "14-23 days incubation", "Fledges in 20 days"),
                Bird("Parrot", "Psittaciformes", "Extremely intelligent", "Zygodactyl feet for climbing", "Nests in tree cavities", "Tree hollow padding", "18-28 days", "Stays with parents for months"),
                Bird("Toucan", "Ramphastidae", "Massive but lightweight beak", "Beak regulates body temperature", "Nests in old woodpecker holes", "Deep cavities", "16 days", "Born blind and naked")
            )
        ),
        Habitat(
            id = "wetland",
            name = "Wetland",
            icon = "🌊",
            description = "Areas where water covers the soil, including marshes, swamps, and bogs.",
            climate = "Variable temperatures with constant high water availability.",
            adaptationFacts = "Aves here possess webbed feet for swimming or long legs for wading through deep mud.",
            birds = listOf(
                Bird("Duck", "Anatidae family", "Feathers are waterproof.", "Webbed feet & flat bill", "Builds nests near water edge", "Ground hollow lined with down", "28 days", "Precocial (swims immediately)"),
                Bird("Swan", "Cygnus genus", "Mates for life.", "Long neck to reach underwater plants", "Large mound nests near water", "Reeds and sticks heap", "35-42 days", "Guarded heavily by parents"),
                Bird("Flamingo", "Phoenicopteridae", "Pink color comes from shrimp diet.", "Filter-feeding beak & ultra-long legs", "Mud cone mounds", "Raised mud structures", "27-31 days", "Fed with specialized crop milk")
            )
        ),
        Habitat(
            id = "savannah",
            name = "Savannah",
            icon = "🌾",
            description = "Open grasslands with scattered trees and distinct dry seasons.",
            climate = "Hot year-round with a drastic seasonal drought split.",
            adaptationFacts = "Birds often adapt for long-distance flight or running across vast open plains.",
            birds = listOf(
                Bird("Weaver Bird", "Ploceidae", "Master architects of nature.", "Strong conical beak for weaving", "Weaves complex hanging nests", "Woven grass hanging spheres", "12-15 days", "Fed on insects by community"),
                Bird("Vulture", "Cathartidae", "Incredible immune system.", "Bald head to stay clean while eating", "Nests on high cliffs or tall trees", "Scattered stick platforms", "40-50 days", "Slow development over 4 months"),
                Bird("Ostrich", "Struthio", "Largest and fastest running bird.", "Powerful legs, lost ability to fly", "Shared communal pit on the ground", "Shallow dirt scrapes", "42-46 days", "Runs with herd within days")
            )
        ),
        Habitat(
            id = "arctic",
            name = "Arctic Area",
            icon = "❄️",
            description = "Freezing, treeless tundra environments around the North Pole.",
            climate = "Extremely cold, short summers, sub-zero winters.",
            adaptationFacts = "Thick down feathers, white camouflage, and fat layers keep these aves alive.",
            birds = listOf(
                Bird("Snow Bunting", "Calcariidae", "Breeds further north than almost any bird.", "Changes plumage color without molting", "Nests deep in rock cracks", "Hidden rocky crevices", "12-13 days", "Rapid 10-day nest exit"),
                Bird("Snowy Owl", "Bubo scandiacus", "Keen nomadic hunter.", "Feathered talons and heavy insulation", "Scrapes on top of hummocks", "Elevated wind-swept mounds", "32-34 days", "White fluffy chicks roam early"),
                Bird("Penguin", "Spheniscidae", "Excellent deep-sea divers.", "Wings evolved into flippers", "Breeds on bare rock or ice packs", "Pebble nests or carried on feet", "35-64 days", "Forms massive chick crèches")
            )
        )
    )

    val quizQuestions = listOf(
        QuizQuestion("Which bird weaves intricate hanging nests from grass?", listOf("Ostrich", "Weaver Bird", "Toucan"), 1),
        QuizQuestion("What adaptation helps Arctic birds survive the cold?", listOf("Webbed feet", "Thick down feathers", "Long slender beaks"), 1),
        QuizQuestion("Where do ducks typically incubate their eggs?", listOf("High mountain cliffs", "Deep tree hollows", "Ground nests near water"), 2)
    )
}