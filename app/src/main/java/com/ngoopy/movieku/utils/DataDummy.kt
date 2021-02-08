package com.ngoopy.movieku.utils

import com.ngoopy.movieku.data.entity.ListMoviesEntity
import com.ngoopy.movieku.data.entity.ListTVShowsEntity
import com.ngoopy.movieku.data.entity.MovieEntity
import com.ngoopy.movieku.data.entity.TVShowEntity
import kotlin.random.Random

object DataDummy {

    fun generateDummyListMovie() : List<ListMoviesEntity> {
        val movie = ArrayList<ListMoviesEntity>()

        for (i in generateDummyMovie()) {
            movie.add(ListMoviesEntity(
                Random.nextInt(1000),
                i.title,
                i.release_date,
                i.image
            ))
        }

        return movie
    }

    fun generateDummyMovie() : ArrayList<MovieEntity> {
        val movie = ArrayList<MovieEntity>()

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/tK1zy5BsCt1J4OzoDicXmr0UTFH.jpg",
            "The Croods: A New Age",
            "23 Desember 2020",
            "Petualangan, Keluarga, Animasi",
                "01:35",
                81f,
                "Keluarga prasejarah The Croods kembali ke shenanigans mereka yang lama di dunia baru yang berbahaya dan aneh."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/s2PPk1w6p6RhbPrZPizZ90ISdWh.jpg",
            "Honest Thief",
            "16 Oktober 2020",
            "Aksi, Kejahatan, Drama",
            "01:38",
            70f,
            "A bank robber tries to turn himself in because he's falling in love and wants to live an honest life...but when he realizes the Feds are more corrupt than him, he must fight back to clear his name."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/k68nPLbIST6NP96JmTxmZijEvCA.jpg",
                "Tenet",
                "26 Agustus 2020",
                "Aksi, Cerita Seru, Cerita Fiksi",
                "02:30",
                74f,
                "Armed with only one word - Tenet - and fighting for the survival of the entire world, the Protagonist journeys through a twilight world of international espionage on a mission that will unfold in something beyond real time."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/2AwPvNHphpZBJDqjZKVuMAbvS0v.jpg",
                "Wander",
                "4 Desember 2020",
                "Cerita Seru, Kejahatan, Misteri",
                "01:34",
                55f,
                "After getting hired to probe a suspicious death in the small town of Wander, a mentally unstable private investigator becomes convinced the case is linked to the same 'conspiracy cover up' that caused the death of his daughter."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/wVu2B58T61LAMiY68hxAA2NLcr9.jpg",
                "Greenland",
                "29 Juli 2020",
                "Aksi, Cerita Seru",
                "02",
                71f,
                "John Garrity, his estranged wife and their young son embark on a perilous journey to find sanctuary as a planet-killing comet hurtles toward Earth. Amid terrifying accounts of cities getting levelled, the Garrity's experience the best and worst in humanity. As the countdown to the global apocalypse approaches zero, their incredible trek culminates in a desperate and last-minute flight to a possible safe haven."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/eLT8Cu357VOwBVTitkmlDEg32Fs.jpg",
                "Jiu Jitsu",
                "20 November 2020",
                "Aksi, Fantasi, Cerita Fiksi",
                "01:42",
                57f,
                "Every six years, an ancient order of jiu-jitsu fighters joins forces to battle a vicious race of alien invaders. But when a celebrated war hero goes down in defeat, the fate of the planet and mankind hangs in the balance."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4n8QNNdk4BOX9Dslfbz5Dy6j1HK.jpg",
                "Fatman",
                "26 November 2020",
                "Aksi, Komedi, Fantasi",
                "01:40",
                77f,
                "A rowdy, unorthodox Santa Claus is fighting to save his declining business. Meanwhile, Billy, a neglected and precocious 12 year old, hires a hit man to kill Santa after receiving a lump of coal in his stocking."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/di1bCAfGoJ0BzNEavLsPyxQ2AaB.jpg",
                "Wonder Woman 1984",
                "25 Desember 2020",
                "Fantasi, Aksi, Petualangan",
                "02:31",
                71f,
                "Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/chGTXsvn53XvEnvsJ9ZD9eiYKx9.jpg",
                "Arthur & Merlin, Knights of Camelot",
                "28 Mei 2020",
                "Sejarah, Aksi, Petualangan",
                "01:31",
                60f,
                "King Arthur returns home after fighting the Roman Empire. His illegitimate son has corrupted the throne of Camelot and King Arthur must reunite with the wizard Merlin and the Knights of the Round Table to fight to get back his crown."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/1f3qspv64L5FXrRy0MF8X92ieuw.jpg",
                "Monsters of Man",
                "8 Desember 2020",
                "Cerita Fiksi",
                "02:11",
                77f,
                "A robotics company vying to win a lucrative military contract team up with a corrupt CIA agent to conduct an illegal live field test. They deploy four weaponized prototype robots into a suspected drug manufacturing camp in the Golden Triangle, assuming they'd be killing drug runners that no one would miss. Six doctors on a humanitarian mission witness the brutal slaughter and become prime targets."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/cLDPLia17AwMqSaRHccyAlInkch.jpg",
                "Heavenquest: A Pilgrim's Progress",
                "13 Juli 2020",
                "Petualangan, Fantasi, Aksi",
                "01:31",
                55f,
                "Inspired by the 1678 novel The Pilgrim's Progress and an imagined prequel to Bunyan's original writings. A regal man named Vangel is thrust on a journey against his will when he is suddenly and mysteriously arrested. Injured and lost after escaping the dark king’s men, Vangel begins to have strange dreams and visions of a mysterious woman in white calling him from the unknown territory of the North. Armed with a book called “The Record of the Ancients” that he receives from a wise sage named Elder, Vangel embarks on an adventure that takes him through treacherous mountain range, unending deserts, the Lake of Doubts, and the Forest of No Return. Along the way, travel companions share about a fabled good king and his son in the North if he can make it there alive."
        )
        )

        movie.add(
            MovieEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/lhMIra0pqWNuD6CIXoTmGwZ0EBS.jpg",
                "The Craft: Legacy",
                "28 Oktober 2020",
                "Kengerian, Drama, Fantasi",
                "01:34",
                62f,
                "An eclectic foursome of aspiring teenage witches get more than they bargained for as they lean into their newfound powers."
        )
        )

        return movie
    }

    fun generateDummyListTVShow() : List<ListTVShowsEntity> {
        val tvShow = ArrayList<ListTVShowsEntity>()

        for (i in generateDummyTVShow()) {
            tvShow.add(ListTVShowsEntity(
                Random.nextInt(1000),
                i.title,
                "${Random.nextInt(30)}/${Random.nextInt(12)}/${Random.nextInt(2000,2020)}",
                i.image
            ))
        }

        return tvShow
    }

    fun generateDummyTVShow() : List<TVShowEntity> {
        val tvShow = ArrayList<TVShowEntity>()

        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/BbNvKCuEF4SRzFXR16aK6ISFtR.jpg",
                "The Mandalorian",
                "Fantasy, Aksi, Petualangan",
                "00:35",
                "After the fall of the Galactic Empire, lawlessness has spread throughout the galaxy. A lone gunfighter makes his way through the outer reaches, earning his keep as a bounty hunter.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/gJ8VX6JSu3ciXHuC2dDGAo2lvwM.png",
                85f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/z1K4mJwISETia59rrnMdXxzoSrZ.jpg",
                "The Good Doctor",
                "Drama",
                "00:42",
                "A young surgeon with Savant syndrome is recruited into the surgical unit of a prestigious hospital. The question will arise: can a person who doesn't have the ability to relate to people actually save their lives?",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/ndAvF4JLsliGreX87jAc9GdjmJY.png",
                86f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/clnyhPqj1SNgpAdeSS6a6fwE6Bo.jpg",
            "Grey's Anatomy",
            "Drama",
            "00:43",
            "Ikuti kehidupan pribadi dan profesional sekelompok dokter di Rumah Sakit Gray Sloan Memorial di Seattle.",
            "Berlanjut",
            "https://image.tmdb.org/t/p/h30/ndAvF4JLsliGreX87jAc9GdjmJY.png",
            81f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/mYsWyfiIMxx4HDm0Wck7oJ9ckez.jpg",
            "Selena: The Series",
                "Drama",
                "00:40",
                "As Mexican-American Tejano singer Selena comes of age and realizes her dreams, she and her family make tough choices to hold on to love and music.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                75f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/1sBx2Ew4WFsa1YY32vlHt079O03.jpg",
            "Lucifer",
                "Kejahatan, Sci-fi, Fantasi",
                "00:45",
                "Bosan dan tidak bahagia sebagai Penguasa Neraka, Lucifer Morningstar meninggalkan tahtanya dan pensiun ke Los Angeles, di mana ia telah bekerja sama dengan detektif LAPD Chloe Decker untuk menjatuhkan penjahat. Tapi semakin lama dia menjauh dari dunia bawah, semakin besar ancaman bahwa yang terburuk dari umat manusia dapat melarikan diri.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                85f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/4G2aJJs1lXoS0n6ftZglkXtZpc6.jpg",
            "Industry",
                "Drama",
                "01:00",
                "In the cutthroat world of international finance, a group of young graduates compete for a limited set of permanent positions at a top investment bank in London. The boundaries between colleague, friend, lover, and enemy soon blur as they immerse themselves in a company culture defined as much by sex, drugs and ego as it is by deals and dividends.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/tuomPhY2UtuPTqqFnKMVHvSb724.png",
                71f
        )
        )
        tvShow.add(
            TVShowEntity(
"https://image.tmdb.org/t/p/w600_and_h900_bestv2/gmL6MSH3jK2T7zYvzo9dIZb393c.jpg",
                "30 Monedas",
                "Kejahatan, Mesteri, Drama",
                "01:03",
                "Father Vergara—an exorcist, boxer and ex-convict—lives in a remote village in Spain. Hoping to be lost and forgotten, Vergara’s demons catch up to him.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/tuomPhY2UtuPTqqFnKMVHvSb724.png",
                65f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/g6tIKGc3f1H5QMz1dcgCwADKpZ7.jpg",
            "His Dark Materials",
                "Drama, Sci-fi, Fantasy",
                "01:00",
                "Lyra is an orphan who lives in a parallel universe in which science, theology and magic are entwined. Lyra's search for a kidnapped friend uncovers a sinister plot involving stolen children, and turns into a quest to understand a mysterious phenomenon called Dust. She is later joined on her journey by Will, a boy who possesses a knife that can cut windows between worlds. As Lyra learns the truth about her parents and her prophesied destiny, the two young people are caught up in a war against celestial powers that ranges across many worlds.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/mVn7xESaTNmjBUyUtGNvDQd3CT1.png",
                81f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/6zBWSuYW3Ps1nTfeMS8siS4KUaA.jpg",
                "Riverdale",
                "Drama, Misteri",
                "00:45",
                "Set in the present, the series offers a bold, subversive take on Archie, Betty, Veronica and their friends, exploring the surreality of small-town life, the darkness and weirdness bubbling beneath Riverdale’s wholesome facade.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/ge9hzeaU7nMtQ4PjkFlc68dGAJ9.png",
                86f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/v0G8cbPtGoiTBFb4HW1hAJJFMol.jpg",
            "SEAL Team",
                "Aksi, Drama, Kejahatan, Politik",
                "00:43",
                "The lives of the elite Navy Seals as they train, plan and execute the most dangerous, high-stakes missions our country can ask.",
                "Berlanjut",
                "https://image.tmdb.org/t/p/h30/nm8d7P7MJNiBLdgIzUK0gkuEA4r.png",
                78f
        )
        )
        tvShow.add(
            TVShowEntity(
            "https://image.tmdb.org/t/p/w600_and_h900_bestv2/zU0htwkhNvBQdVSIKB9s6hgVeFK.jpg",
            "The Queen's Gambit",
                "Drama",
                "01:00",
                "In a Kentucky orphanage in the 1950s, a young girl discovers an astonishing talent for chess while struggling with addiction.",
                "Berakhir",
                "https://image.tmdb.org/t/p/h30/wwemzKWzjKYJFfCeiB57q3r4Bcm.png",
                87f
        )
        )

        return tvShow
    }
}