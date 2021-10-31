package br.com.dio.myportfolio.domain.di

import br.com.dio.myportfolio.data.di.DataModule
import br.com.dio.myportfolio.domain.ListUserRepositoriesUseCase
import org.koin.core.context.loadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

object DomainModule {

    fun load() {
        loadKoinModules(useCaseModule())
    }


    private fun useCaseModule(): Module {
        return module {
            factory { ListUserRepositoriesUseCase(get())
           // factory { NovoUseCase(get())
           // factory { OutroUseCase(get())
            }
        }
    }

}