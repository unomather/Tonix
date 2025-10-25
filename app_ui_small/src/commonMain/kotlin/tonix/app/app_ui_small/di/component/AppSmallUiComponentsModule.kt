package tonix.app.app_ui_small.di.component

import com.arkivanov.decompose.ComponentContext
import org.koin.core.parameter.parametersOf
import org.koin.dsl.module
import tonix.app.app_shared.core_ui.view_model.di.getViewModel
import tonix.app.app_ui_small.navigation.AppComponent
import tonix.app.app_ui_small.navigation.AppNavigator
import tonix.app.app_ui_small.navigation.AppViewModel

internal val moduleAppSmallUiComponents = module {
    /**
     * APP
     */
    factory { (context: ComponentContext) ->
        AppComponent(
            context = context,
            viewModel = context.getViewModel<AppViewModel> { parametersOf(context) },
            navigator = get<AppNavigator> { parametersOf(context) }
        )
    }
}