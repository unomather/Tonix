package tonix.app.app_ui_small.navigation.bottom_navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.DrawableResource
import tonix.app.app_shared.core_ui.components.container_with_indicator.ContainerWithIndicator
import tonix.app.app_shared.core_ui.components.image.AppImage
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem.Assets
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem.DApps
import tonix.app.app_ui_small.navigation.bottom_navigation.BottomNavigationItem.Market
import tonix.app.resources.Res
import tonix.app.resources.ic_assets_selected
import tonix.app.resources.ic_assets_unselected
import tonix.app.resources.ic_defi_selected
import tonix.app.resources.ic_defi_unselected
import tonix.app.resources.ic_markets_selected
import tonix.app.resources.ic_markets_unselected

internal const val BOTTOM_NAVIGATION_HEIGHT = 48

@Composable
internal fun AppBottomNavigation(
    selectedItem: BottomNavigationItem?,
    onItemClick: (BottomNavigationItem) -> Unit,
    modifier: Modifier = Modifier
) {
    ContainerWithIndicator(
        items = bottomNavigationItems,
        selectedItem = selectedItem,
        onItemClick = { item -> onItemClick(item) },
        itemContent = { item, isSelected ->
            AppImage(
                image = if (isSelected) item.iconSelected else item.iconUnelected,
                color = colors.text,
                modifier = Modifier.size((BOTTOM_NAVIGATION_HEIGHT / 2).dp)
            )
        },
        withShadow = true,
        modifier = modifier
            .fillMaxWidth()
            .navigationBarsPadding()
            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
            .height(BOTTOM_NAVIGATION_HEIGHT.dp)
    )
}

internal sealed class BottomNavigationItem(
    val iconSelected: DrawableResource,
    val iconUnelected: DrawableResource
) {
    data object Assets: BottomNavigationItem(
        iconSelected = Res.drawable.ic_assets_selected,
        iconUnelected = Res.drawable.ic_assets_unselected
    )
    data object Market: BottomNavigationItem(
        iconSelected = Res.drawable.ic_markets_selected,
        iconUnelected = Res.drawable.ic_markets_unselected
    )
    data object DApps: BottomNavigationItem(
        iconSelected = Res.drawable.ic_defi_selected,
        iconUnelected = Res.drawable.ic_defi_unselected
    )
}

internal val bottomNavigationItems = listOf(Assets, Market, DApps)
