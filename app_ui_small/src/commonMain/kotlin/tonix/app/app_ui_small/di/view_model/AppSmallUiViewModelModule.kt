package tonix.app.app_ui_small.di.view_model

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module
import tonix.app.app_ui_small.navigation.AppViewModel

val moduleAppSmallUiViewModel = module {
    /**
     * APP
     */
    factoryOf(::AppViewModel)
}