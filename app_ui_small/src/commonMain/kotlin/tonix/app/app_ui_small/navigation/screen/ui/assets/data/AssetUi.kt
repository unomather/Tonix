package tonix.app.app_ui_small.navigation.screen.ui.assets.data

import androidx.compose.runtime.Immutable
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.resources.Res
import tonix.app.resources.ic_ton
import tonix.app.resources.ic_usdt
import tonix.app.resources.ic_btc

@Immutable
internal data class AssetUi(
    val name: String,
    val icon: DrawableResource,
    val ticker: String,
    val chain: String? = null,
    val balanceTicker: String,
    val balanceUsd: String,
    val price: String
)

internal fun getTestAssets() = listOf(
    AssetUi(
        name = "Toncoin",
        icon = Res.drawable.ic_ton,
        ticker = "TON",
        chain = null,
        balanceTicker = "1000",
        balanceUsd = "2,279",
        price = "2.279$"
    ),
    AssetUi(
        name = "Tether USD",
        icon = Res.drawable.ic_usdt,
        ticker = "USDT",
        chain = "TON",
        balanceTicker = "15000",
        balanceUsd = "15,000",
        price = "1$"
    ),
    AssetUi(
        name = "Bitcoin",
        icon = Res.drawable.ic_btc,
        ticker = "BTC",
        chain = "TON",
        balanceTicker = "0.25",
        balanceUsd = "28,125",
        price = "112,500$"
    )
)