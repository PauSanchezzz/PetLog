package com.example.petlog.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import com.example.prueba.ui.theme.backgroundDark
import com.example.prueba.ui.theme.backgroundLight
import com.example.prueba.ui.theme.errorContainerDark
import com.example.prueba.ui.theme.errorContainerLight
import com.example.prueba.ui.theme.errorDark
import com.example.prueba.ui.theme.errorLight
import com.example.prueba.ui.theme.inverseOnSurfaceDark
import com.example.prueba.ui.theme.inverseOnSurfaceLight
import com.example.prueba.ui.theme.inversePrimaryDark
import com.example.prueba.ui.theme.inversePrimaryLight
import com.example.prueba.ui.theme.inverseSurfaceDark
import com.example.prueba.ui.theme.inverseSurfaceLight
import com.example.prueba.ui.theme.onBackgroundDark
import com.example.prueba.ui.theme.onBackgroundLight
import com.example.prueba.ui.theme.onErrorContainerDark
import com.example.prueba.ui.theme.onErrorContainerLight
import com.example.prueba.ui.theme.onErrorDark
import com.example.prueba.ui.theme.onErrorLight
import com.example.prueba.ui.theme.onPrimaryContainerDark
import com.example.prueba.ui.theme.onPrimaryContainerLight
import com.example.prueba.ui.theme.onPrimaryDark
import com.example.prueba.ui.theme.onPrimaryLight
import com.example.prueba.ui.theme.onSecondaryContainerDark
import com.example.prueba.ui.theme.onSecondaryContainerLight
import com.example.prueba.ui.theme.onSecondaryDark
import com.example.prueba.ui.theme.onSecondaryLight
import com.example.prueba.ui.theme.onSurfaceDark
import com.example.prueba.ui.theme.onSurfaceLight
import com.example.prueba.ui.theme.onSurfaceVariantDark
import com.example.prueba.ui.theme.onSurfaceVariantLight
import com.example.prueba.ui.theme.onTertiaryContainerDark
import com.example.prueba.ui.theme.onTertiaryContainerLight
import com.example.prueba.ui.theme.onTertiaryDark
import com.example.prueba.ui.theme.onTertiaryLight
import com.example.prueba.ui.theme.outlineDark
import com.example.prueba.ui.theme.outlineLight
import com.example.prueba.ui.theme.outlineVariantDark
import com.example.prueba.ui.theme.outlineVariantLight
import com.example.prueba.ui.theme.primaryContainerDark
import com.example.prueba.ui.theme.primaryContainerLight
import com.example.prueba.ui.theme.primaryDark
import com.example.prueba.ui.theme.primaryLight
import com.example.prueba.ui.theme.scrimDark
import com.example.prueba.ui.theme.scrimLight
import com.example.prueba.ui.theme.secondaryContainerDark
import com.example.prueba.ui.theme.secondaryContainerLight
import com.example.prueba.ui.theme.secondaryDark
import com.example.prueba.ui.theme.secondaryLight
import com.example.prueba.ui.theme.surfaceDark
import com.example.prueba.ui.theme.surfaceLight
import com.example.prueba.ui.theme.surfaceVariantDark
import com.example.prueba.ui.theme.surfaceVariantLight
import com.example.prueba.ui.theme.tertiaryContainerDark
import com.example.prueba.ui.theme.tertiaryContainerLight
import com.example.prueba.ui.theme.tertiaryDark
import com.example.prueba.ui.theme.tertiaryLight

private val lightScheme = lightColorScheme(
    primary = primaryLight,
    onPrimary = onPrimaryLight,
    primaryContainer = primaryContainerLight,
    onPrimaryContainer = onPrimaryContainerLight,
    secondary = secondaryLight,
    onSecondary = onSecondaryLight,
    secondaryContainer = secondaryContainerLight,
    onSecondaryContainer = onSecondaryContainerLight,
    tertiary = tertiaryLight,
    onTertiary = onTertiaryLight,
    tertiaryContainer = tertiaryContainerLight,
    onTertiaryContainer = onTertiaryContainerLight,
    error = errorLight,
    onError = onErrorLight,
    errorContainer = errorContainerLight,
    onErrorContainer = onErrorContainerLight,
    background = backgroundLight,
    onBackground = onBackgroundLight,
    surface = surfaceLight,
    onSurface = onSurfaceLight,
    surfaceVariant = surfaceVariantLight,
    onSurfaceVariant = onSurfaceVariantLight,
    outline = outlineLight,
    outlineVariant = outlineVariantLight,
    scrim = scrimLight,
    inverseSurface = inverseSurfaceLight,
    inverseOnSurface = inverseOnSurfaceLight,
    inversePrimary = inversePrimaryLight,
)

private val darkScheme = darkColorScheme(
    primary = primaryDark,
    onPrimary = onPrimaryDark,
    primaryContainer = primaryContainerDark,
    onPrimaryContainer = onPrimaryContainerDark,
    secondary = secondaryDark,
    onSecondary = onSecondaryDark,
    secondaryContainer = secondaryContainerDark,
    onSecondaryContainer = onSecondaryContainerDark,
    tertiary = tertiaryDark,
    onTertiary = onTertiaryDark,
    tertiaryContainer = tertiaryContainerDark,
    onTertiaryContainer = onTertiaryContainerDark,
    error = errorDark,
    onError = onErrorDark,
    errorContainer = errorContainerDark,
    onErrorContainer = onErrorContainerDark,
    background = backgroundDark,
    onBackground = onBackgroundDark,
    surface = surfaceDark,
    onSurface = onSurfaceDark,
    surfaceVariant = surfaceVariantDark,
    onSurfaceVariant = onSurfaceVariantDark,
    outline = outlineDark,
    outlineVariant = outlineVariantDark,
    scrim = scrimDark,
    inverseSurface = inverseSurfaceDark,
    inverseOnSurface = inverseOnSurfaceDark,
    inversePrimary = inversePrimaryDark,
)


@Composable
fun PetLogTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        darkTheme -> darkScheme
        else -> lightScheme
    }

    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            window.statusBarColor = colorScheme.primary.toArgb()
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = darkTheme
        }
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}