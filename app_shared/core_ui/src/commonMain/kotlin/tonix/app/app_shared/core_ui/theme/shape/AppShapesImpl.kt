package tonix.app.app_shared.core_ui.theme.shape

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.unit.dp

data class AppShapesImpl(
    override val extraSmall: CornerBasedShape = RoundedCornerShape(4.dp),
    override val small: CornerBasedShape = RoundedCornerShape(8.dp),
    override val medium: CornerBasedShape = RoundedCornerShape(12.dp),
    override val large: CornerBasedShape = RoundedCornerShape(16.dp),
    override val extraLarge: CornerBasedShape = RoundedCornerShape(24.dp),
    override val circle: CornerBasedShape = RoundedCornerShape(50.dp)
): AppShapes