package dk.enmango.ordsomegram

import dk.enmango.ordsomegram.services.IRequestRepository
import dk.enmango.ordsomegram.services.RequestRepository
import org.koin.dsl.module

    val appModule = module {
        single<IRequestRepository> { RequestRepository() }
        single { RequestHandler(get()) }
        // single = singleton
        // factory = creates new instance each time
    }
