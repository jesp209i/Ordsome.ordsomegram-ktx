package dk.enmango.ordsomegram.services

import dk.enmango.ordsomegram.viewmodel.RequestListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

val appModule: Module = module{
    viewModel { RequestListViewModel(get()) }
    single(createdAtStart = true) {RequestRepository(get())}
    single {APIController(get())}

}