package tonix.app.di

import org.koin.dsl.module
import tonix.app.coroutines.AppDispatchers
import tonix.app.coroutines.AppDispatchersImpl

val moduleShared = module {
    single<AppDispatchers> {
        AppDispatchersImpl()
    }
}