package tonix.app.coroutines

import kotlinx.coroutines.CoroutineDispatcher

interface AppDispatchers {
    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}