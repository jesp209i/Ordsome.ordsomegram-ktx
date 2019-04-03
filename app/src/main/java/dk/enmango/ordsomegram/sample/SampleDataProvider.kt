package dk.enmango.ordsomegram.sample

import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request


class SampleDataProvider {
    val requestList: MutableList<Request> = mutableListOf<Request>()
    init {
        addRequest(
            Request(
                "0",
                "Die Pferde sind schön",
                "Tysk",
                "Dansk",
                mutableListOf(Answer("0", "Hestene er pæne", "0"))
            )
        )
        addRequest(
            Request(
                "1",
                "Thanks for dinner",
                "Engelsk",
                "Dansk",
                mutableListOf(Answer("1", "Tak for mad", "1"))
            )
        )
        addRequest(Request("2", "Yksi kaksi kolme", "Finsk", "Dansk", mutableListOf(Answer("2", "En to tre", "2"))))
        addRequest(
            Request(
                "3",
                "Pumpulivanua",
                "Finsk",
                "Dansk",
                mutableListOf(
                    Answer("3", "Bomuldsvat", "3"),
                    Answer("4", "Hestehest", "3"),
                    Answer("17", "Bomuldshat", "3"),
                    Answer("18", "Hestekattehest", "3"),
                    Answer("19", "Bomuldsskvat", "3"),
                    Answer("20", "MisseHestehest", "3"),
                    Answer("21", "Bomuldsvat", "3"),
                    Answer("22", "Hestehest", "3"),
                    Answer("23", "Bomuldsvat", "3"),
                    Answer("24", "Hestehest", "3"),
                    Answer("25", "Bomuldsvat", "3"),
                    Answer("26", "Hestehest", "3"),
                    Answer("27", "Bomuldsvat", "3"),
                    Answer("28", "Hestehest", "3"))
            )
        )
        addRequest(Request("4", "Arret", "Canadisk fransk", "Dansk", mutableListOf(Answer("5", "Stop", "4"))))
        addRequest(
            Request(
                "5",
                "Poutine",
                "Canadisk fransk",
                "Dansk",
                mutableListOf(Answer("6", "Poutine (pommes frites med brun sovs og ostestykker)", "5"))
            )
        )
        addRequest(
            Request(
                "6",
                "So long and thanks for all the fish",
                "Engelsk",
                "Dansk",
                mutableListOf(Answer("7", "Farvel og tak for alle fiskene", "6"))
            )
        )
        addRequest(
            Request(
                "7",
                "Das Leiden des jungen Werthers",
                "Tysk",
                "Dansk",
                mutableListOf(Answer("8", "Den unge Werthers lidelser", "7"))
            )
        )
        addRequest(
            Request(
                "8",
                "Sturm und Drang",
                "Tysk",
                "Dansk",
                mutableListOf(
                    Answer(
                        "9",
                        "Sturm und Drang - (Proto-romantisk bevægelse i tysk literatur i 1800-tallet",
                        "8"
                    )
                )
            )
        )
        addRequest(
            Request(
                "9",
                "The apple doesn't fall far from the three",
                "Engelsk",
                "Dansk",
                mutableListOf(Answer("10", "Æblet falder ikke langt fra stammen", "9"))
            )
        )
        addRequest(
            Request(
                "10",
                "Prozvonit",
                "Slovakisk",
                "Dansk",
                mutableListOf(
                    Answer(
                        "11",
                        "Starte et telefonopkald og slutte det igen før modtageren tager telefonen, for at modtageren må ringe op, og man derved slipper for at betale for opkaldet",
                        "10"
                    )
                )
            )
        )
        addRequest(
            Request(
                "11",
                "Iktsuarpok",
                "Inuit",
                "Dansk",
                mutableListOf(Answer("12", "når man går udenfor ofte for at undersøge om der kommer nogen", "11"))
            )
        )
        addRequest(
            Request(
                "12",
                "Torschlusspanik",
                "Tysk",
                "Dansk",
                mutableListOf(
                    Answer(
                        "13",
                        "Frygten for at tiden er ved at rinde ud (så man ikke når et livsmål eller en mulighed)",
                        "12"
                    )
                )
            )
        )
        addRequest(
            Request(
                "13",
                "Tartle",
                "Skottisk",
                "Dansk",
                mutableListOf(
                    Answer(
                        "14",
                        "Det akavede øjeblik hvor man et kort sekund har glemt den andens navn",
                        "13"
                    )
                )
            )
        )
        addRequest(
            Request(
                "14",
                "Saudade",
                "Portugisisk",
                "Dansk",
                mutableListOf(
                    Answer(
                        "15",
                        "En nostalgisk trang til at genopleve en oplevelse eller møde en person man kendte engang",
                        "14"
                    )
                )
            )
        )
        addRequest(
            Request(
                "15",
                "Portez ce vieux whisky au juge blond qui fume",
                "Fransk",
                "Dansk",
                mutableListOf(Answer("16", "Bring denne gamle whisky til den blonde dommer som ryger", "15"))
            )
        )
    }
    private fun addRequest(request: Request){
    //    requestHandler.saveRequest(request)
        requestList.add(request)
    }
    fun findById( id: String): Request?{
        return requestList.find{ request -> request.id == id }
    }
}
