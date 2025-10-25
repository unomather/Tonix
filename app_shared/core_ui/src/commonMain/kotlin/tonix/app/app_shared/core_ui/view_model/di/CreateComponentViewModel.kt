package tonix.app.app_shared.core_ui.view_model.di

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.getOrCreate
import org.koin.core.parameter.ParametersHolder
import org.koin.mp.KoinPlatform.getKoin
import tonix.app.app_shared.core_ui.view_model.BaseViewModel

inline fun <reified VM: BaseViewModel<*, *, *>> ComponentContext.getViewModel(
    noinline parameters: (() -> ParametersHolder)? = null
): VM = instanceKeeper.getOrCreate { getKoin().get(parameters = parameters) }
