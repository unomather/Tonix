package tonix.app.app_shared.ui.base.app_scope

import kotlinx.coroutines.CoroutineScope
import tonix.app.coroutines.AppDispatchers

internal class AppScopeImpl(dispatcher: AppDispatchers): AppScope {
    override val scope = CoroutineScope(dispatcher.io)
}