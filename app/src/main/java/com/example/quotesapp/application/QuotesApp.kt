package com.example.quotesapp.application

import android.app.Application
import com.example.quotesapp.repo.QuoteRepository
import com.example.quotesapp.room.QuoteDatabase
import com.example.quotesapp.viewModel.QuoteViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import org.koin.dsl.module

class QuotesApp: Application() {
    private val database by lazy { QuoteDatabase.getDatabase(this) }
    val repository by lazy { QuoteRepository(database.quoteDao()) }

    override fun onCreate() {
        super.onCreate()

        /**
         * use Koin Library as a service locator
         */
        val myModule = module {

            //Declare a ViewModel - be later inject into Fragment with dedicated injector using by viewModel()
            single {
                QuoteViewModel(
                    get(),
                    repository
                )
            }

            /*single {
                CreateTaskViewModel(
                    get()
                )
            }*/
        }

        startKoin {
            androidContext(this@QuotesApp)
            modules(listOf(myModule))
        }
    }
}