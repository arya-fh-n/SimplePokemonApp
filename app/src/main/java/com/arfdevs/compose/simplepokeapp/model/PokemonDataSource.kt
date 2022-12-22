package com.arfdevs.compose.simplepokeapp.model

import com.arfdevs.compose.simplepokeapp.R

object PokemonDataSource {
    val dummyPokemonData = listOf(
        Pokemon(
            1,
            R.drawable.poke_1,
            "Bulbasaur",
            Type("Grass", "Poison"),
            "Bulbasaur dapat ditemukan tidur siang di bawah sinar matahari. Dengan mandi banyak sinar matahari, benih di punggungnya tumbuh makin besar."
        ),
        Pokemon(
            2,
            R.drawable.poke_2,
            "Ivysaur",
            Type("Grass", "Poison"),
            "Untuk menyokong kuncupnya, kaki dan pinggang Ivysaur menjadi kuat. Jika Pokémon ini menghabiskan lebih banyak waktu beristirahat di bawah sinar matahari, ini tanda bahwa kuncup tersebut akan tumbuh besar."
        ),
        Pokemon(
            3,
            R.drawable.poke_3,
            "Venusaur",
            Type("Grass", "Poison"),
            "Dikatakan bahwa bunga Venusaur akan berwarna cerah jika memperoleh cukup nutrisi dan sinar matahari. Aroma bunga ini dapat menenangkan hati orang yang menghirupnya."
        ),
        Pokemon(
            4,
            R.drawable.poke_4,
            "Charmander",
            Type("Fire"),
            "Charmander memiliki sifat menyukai benda panas. Kabarnya ujung ekornya akan mengeluarkan asap jika kehujanan."
        ),
        Pokemon(
            5,
            R.drawable.poke_5,
            "Charmeleon",
            Type("Fire"),
            "Charmeleon memiliki sifat kasar. Pokémon ini mengayunkan ekor membaranya dan menyayat musuh menggunakan cakarnya yang tajam."
        ),
        Pokemon(
            6,
            R.drawable.poke_6,
            "Charizard",
            Type("Fire"),
            "Charizard menyemburkan api berpijar yang dapat melelehkan bebatuan sekalipun dan kadang menyebabkan terjadinya kebakaran gunung."
        ),
        Pokemon(
            7,
            R.drawable.poke_7,
            "Squirtle",
            Type("Water"),
            "Tempurung Squirtle tidak hanya berperan untuk melindungi diri. Bentuk bundar dan lekukan di permukaannya mengurangi resistansi air, sehingga Pokémon ini dapat berenang dengan kecepatan tinggi."
        ),
        Pokemon(
            8,
            R.drawable.poke_8,
            "Wartortle",
            Type("Water"),
            "Ekor Wartortle yang besar dan diselimuti oleh bulu tebal warnanya berubah menjadi makin tua seiring bertambahnya umur. Goresan luka di tempurungnya merupakan bukti kekuatannya."
        ),
        Pokemon(
            9,
            R.drawable.poke_9,
            "Blastoise",
            Type("Water"),
            "Bidikan lubang penyembur di tempurung Blastoise akurat. Pokémon ini dapat menembakkan peluru air tepat mengenai kaleng kosong yang terpisah sejauh 50 m."
        ),
        Pokemon(
            10,
            R.drawable.poke_10,
            "Caterpie",
            Type("Bug"),
            "Caterpie mengeluarkan bau tidak enak dari antena di kepalanya untuk mengusir musuh dan melindungi dirinya."
        ),
        Pokemon(
            11,
            R.drawable.poke_11,
            "Metapod",
            Type("Bug"),
            "Kondisi menanti evolusi. Metapod hanya dapat mengeraskan diri, jadi dia berdiam diri agar tidak diserang."
        ),
        Pokemon(
            12,
            R.drawable.poke_12,
            "Butterfree",
            Type("Bug", "Flying"),
            "Saat Butterfree mengepakkan sayapnya dengan singkat dan cepat, serbuk yang mengandung racun mematikan akan terbang ke arah lawan dengan menaiki angin."
        ),
        Pokemon(
            13,
            R.drawable.poke_13,
            "Weedle",
            Type("Bug", "Poison"),
            "Weedle memiliki indera penciuman yang sangat tajam. Hidung besar merahnya dapat mencium serta membedakan daun yang disukai dan tidak disukai."
        ),
        Pokemon(
            14,
            R.drawable.poke_14,
            "Kakuna",
            Type("Bug", "Poison"),
            "Kakuna berpegangan di pohon dan hampir tak bergerak sama sekali, tapi di dalam, Pokémon ini sangat sibuk mempersiapkan dirinya untuk evolusi. Sebagai buktinya, tubuhnya terasa panas."
        ),
        Pokemon(
            15,
            R.drawable.poke_15,
            "Beedrill",
            Type("Bug", "Poison"),
            "Beedrill adalah Pokémon yang bersifat sangat teritorial. Tidak ada yang boleh mendekati sarangnya demi keselamatan diri sendiri. Jika marah, mereka akan menyerang sebagai gerombolan yang ganas."
        ),
    )
}