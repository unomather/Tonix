package tonix.app.app_shared.core_ui.theme.typography

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

class AppTypographyImpl(
    override val h1: TextStyle = TextStyle(
        fontSize = 30.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold
    ),
    override val h2: TextStyle = TextStyle(
        fontSize = 24.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium
    ),
    override val h3: TextStyle = TextStyle(
        fontSize = 20.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold
    ),
    override val h4: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.SemiBold
    ),
    override val h5: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold
    ),
    override val h6: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold
    ),
    override val body1: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium
    ),
    override val body2: TextStyle = TextStyle(
        fontSize = 16.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal
    ),
    override val body3: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium
    ),
    override val body4: TextStyle = TextStyle(
        fontSize = 14.sp,
        lineHeight = 18.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal
    ),
    override val sub1: TextStyle = TextStyle(
        fontSize = 12.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal
    ),
    override val sub2: TextStyle = TextStyle(
        fontSize = 10.sp,
        lineHeight = 16.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold
    ),
    override val button: TextStyle = TextStyle(
        fontSize = 17.sp,
        lineHeight = 24.sp,
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium
    )
): AppTypography