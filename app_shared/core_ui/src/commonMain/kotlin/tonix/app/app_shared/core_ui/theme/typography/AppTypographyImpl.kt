package tonix.app.app_shared.core_ui.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class AppTypographyImpl(
    private val fontFamily: FontFamily
): AppTypography {
    override val h1 get() = TextStyle(
        fontSize = 30.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
    override val h2 get() = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium
    )
    override val h3 get() = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold
    )
    override val h4 get() = TextStyle(
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.SemiBold
    )
    override val h5 get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
    override val h6 get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
    override val body1 get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium
    )
    override val body2 get() = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    )
    override val body3 get() = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium
    )
    override val body4 get() = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    )
    override val sub1 get() = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Normal
    )
    override val sub2 get() = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Bold
    )
    override val button get() = TextStyle(
        fontSize = 17.sp,
        lineHeight = 24.sp,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium
    )
}