package dk.enmango.ordsomegram.services

import org.koin.dsl.module

val appModule = module{
    single {RequestRepository()}
}