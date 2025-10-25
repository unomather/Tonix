package tonix.app.app_shared.ui.di

import org.koin.dsl.module
import tonix.app.app_shared.ui.base.app_scope.AppScope
import tonix.app.app_shared.ui.base.app_scope.AppScopeImpl
import tonix.app.coroutines.AppDispatchers

val moduleAppSharedUi = module {
    single<AppScope> {
        AppScopeImpl(dispatcher = get<AppDispatchers>())
    }
}