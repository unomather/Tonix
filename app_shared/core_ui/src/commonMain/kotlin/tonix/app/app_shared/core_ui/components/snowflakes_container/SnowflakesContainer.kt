package tonix.app.app_shared.core_ui.components.snowflakes_container

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import kotlin.random.Random

@Composable
fun SnowflakesContainer(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    BoxWithConstraints(modifier = modifier) {
        val density = LocalDensity.current
        val widthPx = with(density) { maxWidth.toPx() }
        val heightPx = with(density) { maxHeight.toPx() }

        // 2. Создаем и запоминаем начальное состояние снежинок.
        // Пересоздаем, если размеры контейнера изменятся.
        val initialSnowflakes = remember(widthPx, heightPx) {
            createSnowflakes(widthPx, heightPx)
        }

        var snowState by remember { mutableStateOf(initialSnowflakes) }
        var lastFrameTime by remember { mutableStateOf(0L) }

        // 3. Запускаем "игровой" цикл анимации
        LaunchedEffect(Unit) {
            while (true) {
                withFrameNanos { newTime ->
                    val elapsedMillis = (newTime - lastFrameTime) / 1_000_000f

                    // Обновляем состояние, только если это не первый кадр
                    if (lastFrameTime != 0L) {
                        snowState = updateSnowflakes(snowState, elapsedMillis, widthPx, heightPx)
                    }
                    lastFrameTime = newTime
                }
            }
        }

        // 4. Сначала рисуем снежинки на Canvas
        Canvas(modifier = Modifier.fillMaxSize()) {
            snowState.forEach { flake ->
                drawCircle(
                    color = Color.White.copy(alpha = 0.8f),
                    radius = flake.radius,
                    center = Offset(flake.x, flake.y)
                )
            }
        }

        // 5. Потом рисуем контент
        content()
    }
}

private data class Snowflake(
    val x: Float,
    val y: Float,
    val radius: Float,
    val speed: Float,
    val drift: Float
)

/**
 * Начальный список снежинок, разбросанных по экрану.
 */
private fun createSnowflakes(width: Float, height: Float, count: Int = 75) = List(count) {
    Snowflake(
        x = Random.nextFloat() * width,
        y = Random.nextFloat() * height,
        radius = Random.nextFloat() * 4f + 2f, // Радиус от 2 до 6 пикселей
        speed = Random.nextFloat() * 1.5f + 1f, // Скорость падения
        drift = Random.nextFloat() * 2f - 1f    // Боковое смещение (ветер)
    )
}

/**
 * Обновляет позицию каждой снежинки для следующего кадра.
 */
private fun updateSnowflakes(
    flakes: List<Snowflake>,
    elapsedMillis: Float,
    width: Float,
    height: Float
): List<Snowflake> {
    // Нормализуем скорость на основе времени кадра (стремимся к 60fps)
    val elapsedFactor = elapsedMillis / 16f

    return flakes.map { flake ->
        var newY = flake.y + flake.speed * elapsedFactor
        var newX = flake.x + flake.drift * elapsedFactor

        // Если снежинка ушла за нижний край, "переродить" ее наверху
        if (newY > height + flake.radius) {
            newY = -flake.radius
            newX = Random.nextFloat() * width
        }

        // Зацикливание по горизонтали (если уходит за край)
        if (newX > width + flake.radius) newX = -flake.radius
        if (newX < -flake.radius) newX = width + flake.radius

        flake.copy(x = newX, y = newY)
    }
}