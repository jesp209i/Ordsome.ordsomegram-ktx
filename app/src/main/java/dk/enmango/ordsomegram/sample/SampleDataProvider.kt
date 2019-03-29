package dk.enmango.ordsomegram.sample

import dk.enmango.ordsomegram.services.RequestHandler
import dk.enmango.ordsomegram.model.Answer
import dk.enmango.ordsomegram.model.Request


class SampleDataProvider(
    // val requestHandler: RequestHandler
) {


    val requestList: MutableList<Request> = mutableListOf<Request>()
    init {
        addRequest(Request("0", "Die Pferde sind schön", "Tysk", "Dansk", "Hestene er pæne"))
        addRequest(Request("1", "Thanks for dinner", "Engelsk", "Dansk", "Tak for mad"))
        addRequest(Request("2", "Yksi kaksi kolme", "Finsk", "Dansk", "En to tre"))
        addRequest(Request("3", "Pumpulivanua", "Finsk", "Dansk", "Bomuldsvat"))
        addRequest(Request("4", "Arret", "Canadisk fransk", "Dansk", "Stop"))
        addRequest(Request("5", "Poutine", "Canadisk fransk", "Dansk", "Poutine (pommes frites med brun sovs og ostestykker)"))
        addRequest(Request("6", "So long and thanks for all the fish", "Engelsk", "Dansk","Farvel og tak for alle fiskene"))
        addRequest(Request("7", "Das Leiden des jungen Werthers", "Tysk", "Dansk", "Den unge Werthers lidelser"))
        addRequest(Request("8", "Sturm und Drang", "Tysk", "Dansk", "Sturm und Drang - (Proto-romantisk bevægelse i tysk literatur i 1800-tallet"))
        addRequest(Request("9", "The apple doesn't fall far from the three", "Engelsk", "Dansk", "Æblet falder ikke langt fra stammen"))
        addRequest(Request("10", "Prozvonit", "Slovakisk", "Dansk", "Starte et telefonopkald og slutte det igen før modtageren tager telefonen, for at modtageren må ringe op, og man derved slipper for at betale for opkaldet"))
        addRequest(Request("11", "Iktsuarpok", "Inuit", "Dansk", "når man går udenfor ofte for at undersøge om der kommer nogen"))
        addRequest(Request("12", "Torschlusspanik", "Tysk", "Dansk", "Frygten for at tiden er ved at rinde ud (så man ikke når et livsmål eller en mulighed)"))
        addRequest(Request("13", "Tartle", "Skottisk", "Dansk", "Det akavede øjeblik hvor man et kort sekund har glemt den andens navn"))
        addRequest(Request("14", "Saudade", "Portugisisk", "Dansk", "En nostalgisk trang til at genopleve en oplevelse eller møde en person man kendte engang"))
        addRequest(Request("15", "Portez ce vieux whisky au juge blond qui fume", "Fransk","Dansk", "Bring denne gamle whisky til den blonde dommer som ryger"))
/*
        addAnswer(Answer("0","Hestene er pæne","0"))
        addAnswer(Answer("1","Tak for mad","1"))
        addAnswer(Answer("2","en to tre","2"))
        addAnswer(Answer("3","Bomuldsvat","3"))
        addAnswer(Answer("4","Stop","4"))
        addAnswer(Answer("5","Poutine (pommes frites med brun sovs og ostestykker)","5"))
        addAnswer(Answer("6","Farvel og tak for alle fiskene","6"))
        addAnswer(Answer("7","Den unge Werthers lidelser","7"))
        addAnswer(Answer("8","Sturm und Drang - (Proto-romantisk bevægelse i tysk literatur i 1800-tallet","8"))
        addAnswer(Answer("9","Æblet falder ikke langt fra stammen","9"))
        addAnswer(Answer("10","Starte et telefonopkald og slutte det igen før modtageren tager telefonen, for at modtageren må ringe op, og man derved slipper for at betale for opkaldet","10"))
        addAnswer(Answer("11","når man går udenfor ofte for at undersøge om der kommer nogen","11"))
        addAnswer(Answer("12","Frygten for at tiden er ved at rinde ud (så man ikke når et livsmål eller en mulighed)","12"))
        addAnswer(Answer("13","Det akavede øjeblik hvor man et kort sekund har glemt den andens navn","13"))
        addAnswer(Answer("14","En nostalgisk trang til at genopleve en oplevelse eller møde en person man kendte engang","14"))
*/
    }

    //fun addAnswer(answer: Answer){
    //   requestHandler.saveAnswer(answer)
    //}

    fun addRequest(request: Request){
    //    requestHandler.saveRequest(request)
        requestList.add(request)
    }
    fun getRequest(id: String): Request? {
    //    return requestHandler.findRequest(id)
        return requestList.find{ r -> r.id == id}
    }

}
