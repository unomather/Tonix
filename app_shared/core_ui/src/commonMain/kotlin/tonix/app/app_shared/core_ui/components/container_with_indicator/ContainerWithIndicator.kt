package tonix.app.app_shared.core_ui.components.container_with_indicator

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import tonix.app.app_shared.core_ui.theme.CustomTheme.colors
import tonix.app.app_shared.core_ui.theme.CustomTheme.shapes

@Composable
fun <T> ContainerWithIndicator(
    modifier: Modifier,
    items: List<T>,
    selectedItem: T?,
    onItemClick: (item: T) -> Unit,
    itemContent: @Composable BoxScope.(item: T, isSelected: Boolean) -> Unit,
    withShadow: Boolean = false,
    containerBackgroundColor: Color = colors.backgroundLight
) {
    val density = LocalDensity.current
    var parentWidth by remember { mutableIntStateOf(0) }
    val itemWidth = when {
        parentWidth > 0 -> with(density) { parentWidth.toDp() } / items.size
        else -> 0.dp
    }
    val animatedOffset by animateDpAsState(
        animationSpec = tween(),
        targetValue = itemWidth * items.indexOf(selectedItem)
    )
    Box(
        modifier = modifier
            .clip(shapes.extraLarge)
            .background(
                color = containerBackgroundColor,
                shape = shapes.extraLarge
            )
    ) {
        Indicator(
            itemWidth = itemWidth,
            animatedOffset = animatedOffset
        )
        Row(
            modifier = Modifier
                .fillMaxHeight()
                .onGloballyPositioned { coordinates ->
                    parentWidth = coordinates.size.width
                }
        ) {
            items.forEach { type ->
                val isSelected = type == selectedItem
                Item(
                    itemContent = { itemContent(type, isSelected) },
                    onClick = { onItemClick(type) },
                    isSelected = isSelected
                )
            }
        }
    }
}

@Composable
private fun RowScope.Item(
    itemContent: @Composable BoxScope.() -> Unit,
    onClick: () -> Unit,
    isSelected: Boolean
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .weight(1f)
            .fillMaxHeight()
            .clip(shapes.extraLarge)
            .clickable { onClick() }
    ) {
        itemContent()
    }
}

@Composable
private fun Indicator(
    itemWidth: Dp,
    animatedOffset: Dp
) {
    Box(
        modifier = Modifier
            .offset(x = animatedOffset)
            .width(itemWidth)
            .fillMaxHeight()
            .clip(shapes.extraLarge)
            .background(
                color = colors.accent,
                shape = shapes.extraLarge
            )
    )
}