package tonix.app.app_shared.ui.base.app_scope

import kotlinx.coroutines.CoroutineScope

interface AppScope {
    val scope: CoroutineScope
}