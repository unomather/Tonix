package tonix.app.coroutines

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

internal data class AppDispatchersImpl(
    override val io: CoroutineDispatcher = Dispatchers.Default, // TODO: Wait for IO in commonMain
    override val main: CoroutineDispatcher = Dispatchers.Main,
    override val default: CoroutineDispatcher = Dispatchers.Default
): AppDispatchers